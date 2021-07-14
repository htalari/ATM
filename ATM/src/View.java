/**
 * View class represents what the user sees as well as verifies certain inputs the user types
 * @author Talari
 * version 1.0
 */


import java.text.DecimalFormat;
import java.util.Scanner;
public class View {
	private UserAccountList accountList = new UserAccountList();
	private Transactions transactions = new Transactions();
	private Scanner scan = new Scanner(System.in);
	private Accounts tempAcc;
	private Accounts operator;
	private Accounts tempTransactionAccount;
	private String value;
	private String tempName;
	private String tempPassCode;
	private String depositType;
	private String withdrawalType;
	private int movingBills;
	private int tempAccountNumber;
	private double amount;
	private static DecimalFormat df2 = new DecimalFormat(".##");
	/**
	 * constructor that creates all user accounts and operator account
	 *
	 */
	public View() {
		Accounts acc1 = new Accounts("Hari", 123456, "M", 12000.00, 1000.00);
		accountList.addAccount(acc1);
		Accounts acc2 = new Accounts("Dave", 111111, "B", 500.00, 100.00);
		accountList.addAccount(acc2);
		Accounts acc3 = new Accounts("Matt", 222222, "D", 2000.00, 400.00);
		accountList.addAccount(acc3);
		Accounts acc4 = new Accounts("Teddy", 333333, "KK", 1750.00, 237.00);
		accountList.addAccount(acc4);
		Accounts acc5 = new Accounts("Beats", 444444, "L", 70.00, 10.00);
		accountList.addAccount(acc5);
		operator = new Accounts("Leader");
	}
	/**
	 * shows user the welcome text for using the atm
	 * user can decide if they want to log in as a user or operator
	 */
	public void start() {
		System.out.println("Welcome to the Talari ATM");
		System.out.println("Will you be Logging in as a User or Operator?");
		System.out.println("Type U for user or O for operator:");
		value = scan.nextLine();
		this.CheckAccountType();
	}
	/**
	 * private helper method which checks the input user typed for how they want to log in
	 * if user does not type any specifed input then this methed gets recursed
	 */
	private void CheckAccountType() {
		if(value.equalsIgnoreCase("U")) {
			this.typeUserInput();
		}
		else if(value.equalsIgnoreCase("O")) {
			this.typeOperatorInput();
		}
		else {
			System.out.println("Please type U for user or O for Operator:");
			value = scan.nextLine();
			CheckAccountType();
		}
	}
	/**
	 * private helper method that asks operator to type their passcode
	 */
	private void typeOperatorInput() {
		System.out.println("Please type your PassCode:");
		tempPassCode = scan.nextLine();
		this.verifyOperator();
	}
	/**
	 * private helper method that asks user to type their username and password
	 */
	private void typeUserInput() {
		System.out.println("Please type your name hit enter and then type your password:");
		tempName = scan.nextLine();
		tempPassCode = scan.nextLine();
		this.verifyUser(tempName, tempPassCode);
	}
	/**
	 * private helper method which checks if the user account is valid
	 * @param _tempName the username of the user typed
	 * @param _tempPassCode the password the user typed
	 */
	private void verifyUser(String _tempName, String _tempPassCode) {
		boolean verify = false;
		verify = accountList.verifyUser(_tempName, _tempPassCode);
		if(verify) {
			tempAcc = accountList.getAccount(_tempName, _tempPassCode);
			this.userAccountSummary();
			this.typeOfTransaction();
		}
		if(!verify) {
			System.out.println("The Input you entered was not correct");
			this.typeUserInput();
		}
	}
	/**
	 * private helper method which checks to see if the password the operator typed was valid
	 */
	private void verifyOperator() {
		if(tempPassCode.equals(operator.getPassCode())) {
			this.operatorActions();
		}
		else {
			System.out.println("Your passcode was incorrect");
			this.typeOperatorInput();
		}
	}
	/**
	 * private helper method that shows the user possible actions they can make
	 */
	private void operatorActions() {
		System.out.println(transactions.toString());
		System.out.println();
		System.out.println("Would you like to remove or add bills to the ATM?");
		System.out.println("Type R to remove bills, type A to add bills, or L to leave operator mode");
		value = scan.nextLine();
		this.removeOrAddBills();
	}
	/**
	 * private helper method that checks to see if the user wanted to remove or add bills
	 * if they did not select a valid option they are asked to retype for a valid input
	 */
	private void removeOrAddBills() {
		if(value.equalsIgnoreCase("R")) {
			this.howManyToRemove();
		}
		else if(value.equalsIgnoreCase("A")) {
			this.howManyToAdd();
		}
		else if(value.equalsIgnoreCase("L")) {
			this.start();
		}
		else {
			System.out.println("Invalid input, Please type R to remove bills or A to add bills.");
			value = scan.nextLine();
			this.removeOrAddBills();
		}
	}
	/**
	 * program asks the operator how many bills they would like to add to the ATM machine
	 * if they enter a number less than 0 or something that is not a number they are asked to retype for a valid input
	 */
	private void howManyToAdd() {
		try {
			System.out.println("How many bills do you want to add?");
			value = scan.nextLine();
			movingBills = Integer.parseInt(value);
			if(movingBills < 0) {
				System.out.println("cannot enter negative numbers");
				this.howManyToAdd();
			}
			this.typeOfAdd();

		}catch(Exception e) {
			System.out.println("Please enter an integer.");
			this.howManyToAdd();
		}
	}
	/**
	 * program asks the operator which type of bill they are trying to add to the ATM machine
	 * if they do not type a valid type of bill then they are asked to type for a valid input
	 */
	private void typeOfAdd() {
		System.out.println("Type 5 to add five bills, 10 for ten bills, 20 for twenty bills, 50 for fifty bills, and 100 for hundered bills");
		value = scan.nextLine();
		if(value.equals("5")) {
			transactions.addFiveBills(movingBills);
			this.operatorActions();
		}
		else if(value.equals("10")) {
			transactions.addTenBills(movingBills);
			this.operatorActions();
		}
		else if(value.equals("20")) {
			transactions.addTwentyBills(movingBills);
			this.operatorActions();
		}
		else if(value.equals("50")) {
			transactions.addFiftyBills(movingBills);
			this.operatorActions();
		}
		else if(value.equals("100")) {
			transactions.addHunderedBills(movingBills);
			this.operatorActions();
		}
		else {
			System.out.println("Please enter a valid integer.");
			this.typeOfAdd();
		}
	}
	/**
	 * program asks the operator how many bills they are attempting to remove
	 * if they enter a number less than 0 or input that isnt a number they are requested to retype for valid input
	 */
	private void howManyToRemove() {
		try {
			System.out.println("how many bills do you want to remove?");
			value = scan.nextLine();
			movingBills = Integer.parseInt(value);
			if(movingBills<0) {
				System.out.println("cannot enter negative numbers");
				this.howManyToRemove();
			}
			this.typeOfRemove();
		}catch(Exception e) {
			System.out.println("please enter an integer");
			this.howManyToRemove();
		}
	}
	/**
	 * program asks the operator which type of bills they are trying to remove
	 * if they do not enter a valid type of bill the program asks the user to retype for valid input
	 */
	private void typeOfRemove() {
		System.out.println("Type 5 to remove five bills, 10 for ten bills, 20 for twenty bills, 50 for fifty bills, and 100 for hundered bills");
		value = scan.nextLine();
		if(value.equals("5")) {
			transactions.removeFiveBills(movingBills);
			this.operatorActions();
		}
		else if(value.equals("10")) {
			transactions.removeTenBills(movingBills);
			this.operatorActions();
		}
		else if(value.equals("20")) {
			transactions.removeTwentyBills(movingBills);
			this.operatorActions();
		}
		else if(value.equals("50")) {
			transactions.removeFiftyBills(movingBills);
			this.operatorActions();
		}
		else if(value.equals("100")) {
			transactions.removeHunderedBills(movingBills);
			this.operatorActions();
		}
		else {
			System.out.println("You did not enter a correct value");
			this.typeOfRemove();
		}

	}
	/**
	 * shows the user a summary of their account and current balances
	 */
	private void userAccountSummary() {
		System.out.println();
		System.out.println("Name: " + tempAcc.getName());
		System.out.println("Account Number: " + tempAcc.getAccountNumber());
		System.out.println("Your current Checking Balance is: " + df2.format(tempAcc.getCheckingBalance()));
		System.out.println("Your current Savings Balance is: " + df2.format(tempAcc.getSavingsBalance()));
	}
	/**
	 * program asks user which type of transaction they are attempting to make or if they want to log out
	 */
	private void typeOfTransaction() {
		System.out.println();
		System.out.println("Will you be making a Transfer, Withdrawal, Deposit, or Leave?");
		System.out.println("Please type W for withdrawal, D for Deposit, T for Transfer, or L to Leave: ");
		value = scan.nextLine();
		this.checkTransaction();
	}
	/**
	 * program checks to see if input typed by user for type of transaction is valid
	 * if input is invalid then user is asked to type a valid input for type of transaction
	 */
	private void checkTransaction() {
		if(value.equalsIgnoreCase("W")) {
			this.typeOfWithdrawal();
		}
		else if(value.equalsIgnoreCase("D")) {
			this.typeOfDeposit();
		}
		else if(value.equalsIgnoreCase("T")) {
			this.accountTransferTo();
		}
		else if(value.equalsIgnoreCase("L")) {
			this.start();
		}
		else {
			System.out.println("Please type W for withdrawal, D for Deposit, T for transfer, or L to Leave: ");
			value = scan.nextLine();
			this.checkTransaction();
		}
	}
	/**
	 * program asks user upon choosing to make a deposit if deposit is going to be from checkings or savings account
	 */
	private void typeOfDeposit() {
		System.out.println("will you be making the deposit into your checking or savings account? ");
		System.out.println("Please type C for Checkings or S for Savings: ");
		value = scan.nextLine();
		this.verifyTypeOfDeposit();
	}
	/**
	 * program verifies which account the user wants to make the deposit from
	 * if the user did not type valid input the typeOfDeposit() method is called to have the user retype input
	 */
	private void verifyTypeOfDeposit() {
		if(value.equalsIgnoreCase("C")) {
			depositType = "Checking";
			this.depositAmount();
		}
		else if(value.equalsIgnoreCase("S")) {
			depositType = "Saving";
			this.depositAmount();
		}
		else {
			System.out.println("Please type C for Checkings or S for Savings: ");
			value = scan.nextLine();
			this.verifyTypeOfDeposit();
		}
	}
	/**
	 * asks the user to type how much money they wish to deposit into their account
	 * if the user types a number less than 0 or input that is not an integer they will be asked to retype input
	 */
	private void depositAmount() {
		try {

			System.out.println("Please type how much money you would like to Deposit: ");
			value = scan.nextLine();
			amount = Double.parseDouble(value);
			if(amount<0) {
				System.out.println("cannot type negative numbers");
				this.depositAmount();
			}
			transactions.makeDeposit(tempAcc, depositType, amount);
			this.userAccountSummary();
			this.typeOfTransaction();
		}catch(Exception e) {
			System.out.println("Please enter a valid Number: ");
			this.depositAmount();
		}
	}
	/**
	 * asks the user which account they are attempting to make a transfer to
	 * if the account number is invalid the program requests the user to retype for valid input
	 */
	private void accountTransferTo() {

		try {
			System.out.println("Please enter the account number of whom you wish to transfer to: ");
			value = scan.nextLine();
			tempAccountNumber = Integer.parseInt(value);
			tempTransactionAccount = accountList.verifyAccountNumber(tempAccountNumber);
			if(tempTransactionAccount == null) {
				System.out.println("The number you entered was invalid.");
				this.accountTransferTo();
			}
			else
				this.transferAmount();

		}catch(Exception e) {
			System.out.println("Number typed was invalid");
			this.accountTransferTo();
		}
	}
	/**
	 * asks user how much money they are trying to transfer
	 * if they enter a number that is less than zero or input that is not an input they are asked to retype an amount
	 */
	private void transferAmount() {
		try {
			System.out.println("Please enter the amount you want to transfer: ");
			value = scan.nextLine();
			amount = Double.parseDouble(value);

			if(amount > tempAcc.getCheckingBalance()) {
				System.out.println("The amount you entered is greater than your checking balance, please enter another amount.");
				this.transferAmount();
			}
			else if(amount < 0) {
				System.out.println("cannot type negative numbers");
				this.transferAmount();
			}
			else {
				transactions.makeTransaction(tempAcc, tempTransactionAccount, amount);
				this.userAccountSummary();
				this.typeOfTransaction();
			}
		}catch(Exception e) {
			System.out.println("The amount you entered was invalid.");
			this.transferAmount();
		}
	}
	/**
	 * asks the user which type of withdrawal they
	 * a withdrawal from their checkings account or savings account
	 */
	private void typeOfWithdrawal() {
		System.out.println("Will you be making a withdrawal from your savings or checking account?");
		System.out.println("Please press C for checkings and S for savings.");
		value = scan.nextLine();
		this.verifyTypeOfWithdrawal();
	}
	/**
	 * verifies what the user typed for if they want to make the withdrawal from their checkings or savings account
	 * if they did not type valid input the method typeOfWithdrawal is called for the user to retype for valid input
	 */
	private void verifyTypeOfWithdrawal() {
		if(value.equalsIgnoreCase("C")) {
			withdrawalType = "Checking";
			this.withdrawalAmount();
		}
		else if(value.equalsIgnoreCase("S")) {
			withdrawalType = "Saving";
			this.withdrawalAmount();
		}
		else {
			System.out.println("Please type C for Checkings or S for Savings: ");
			value = scan.nextLine();
			this.verifyTypeOfWithdrawal();
		}
	}
	/**
	 * asks user how much money they want to withdrawal
	 * methed checks to see if the amount is valid
	 * checks if the amount is smaller or equal to the balance the user has
	 * checks if the amount is greater than 0
	 * if the user does not type input that is valid they will be asked to retype until valid input
	 */
	private void withdrawalAmount() {
		boolean verify = false;
		try {
			System.out.println("Please enter the amount of money you wish to withdraw");
			value = scan.nextLine();
			amount = Double.parseDouble(value);

			if(amount < 0) {
				System.out.println("cannot enter a negative amount");
				this.withdrawalAmount();
			}
			else if(withdrawalType.equals("Checking")) {
				if(tempAcc.getCheckingBalance()<amount) {
					System.out.println("You do not have that much money in your checking account.");
					this.withdrawalAmount();
				}
				else
					verify = true;
			}
			else if(withdrawalType.equals("Saving")) {
				if(tempAcc.getSavingsBalance()<amount) {
					System.out.println("You do not have enough money in your savings account.");
					this.withdrawalAmount();
				}
				else
					verify = true;
			}

			if(verify){
				verify = false;
				verify = transactions.isWithdrawalPossible(tempAcc, amount, withdrawalType);
				if(verify == false) {
					this.withdrawalAmount();
				}
				else if(verify == true) {
					transactions.makeWithdrawal(tempAcc, amount, withdrawalType);
					this.userAccountSummary();
					this.typeOfTransaction();
				}
			}
		}catch(Exception e) {
			System.out.println("The amount you entered was invalid.");
			this.withdrawalAmount();
		}
	}
}
