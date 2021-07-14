/**
 * Transactions class represents all the money transactions made in the atm
 * @author haritalari
 * version 1.0
 */
public class Transactions {
	private int fiveBills = 100;
	private int tenBills = 100;
	private int twentyBills = 100;
	private int fiftyBills = 100;
	private int hunderedBills = 100;
	private double amount;
	final int HUNDERED_VALUE = 100;
	final int FIFTY_VALUE = 50;
	final int TWENTY_VALUE = 20;
	final int TEN_VALUE = 10;
	final int FIVE_VALUE = 5;
	private int amountOfFiveBillsToGive;
	private int amountOfTenBillsToGive;
	private int amountOfTwentyBillsToGive;
	private int amountOfFiftyBillsToGive;
	private int amountOfHunderedBillsToGive;
	/**
	 * method which adds 5 dollar bills to the atm
	 * @param _amount amount to be added
	 */
	public void addFiveBills(int _amount) {
		fiveBills += _amount;
	}
	/**
	 * method which adds 10 dollar bills to the atm
	 * @param _amount amount to be added
	 */
	public void addTenBills(int _amount) {
		tenBills += _amount;
	}
	/**
	 * method which adds 20 dollar bills to the atm
	 * @param _amount amount to be added
	 */
	public void addTwentyBills(int _amount) {
		twentyBills += _amount;
	}
	/**
	 * method which adds 50 dollar bills to the atm
	 * @param _amount amount to be added
	 */
	public void addFiftyBills(int _amount) {
		fiftyBills += _amount;
	}
	/**
	 * method which adds 100 dollar bills to the atm
	 * @param _amount amount to be added
	 */
	public void addHunderedBills(int _amount) {
		hunderedBills += _amount;
	}
	/**
	 * method which removes 5 dollar bills from the atm
	 * @param _amount amount to be removed
	 */
	public void removeFiveBills(int _amount) {
		if(fiveBills>=_amount) {
			fiveBills -= _amount;
			System.out.println("Transaction successful");
		}
		else {
			System.out.println("");
			System.out.println("The amount you requested is greater than what is available");
		}
	}
	/**
	 * method which removes 10 dollar bills from the atm
	 * @param _amount amount to be removed
	 */
	public void removeTenBills(int _amount) {
		if(tenBills>=_amount) {
			tenBills -= _amount;
			System.out.println("");
			System.out.println("Transaction successful");
		}
		else {
			System.out.println("The amount you requested is greater than what is available");
		}
	}
	/**
	 * method which removes 20 bills from the atm
	 * @param _amount amount to be removed
	 */
	public void removeTwentyBills(int _amount) {
		if(twentyBills>=_amount) {
			twentyBills -= _amount;
			System.out.println("");
			System.out.println("Transaction successful");
		}
		else {
			System.out.println("The amount you requested is greater than what is available");
		}
	}
	/**
	 * method which removes 50 dollar bills from the atm
	 * @param _amount amount to be removed
	 */
	public void removeFiftyBills(int _amount) {
		if(fiftyBills>=_amount) {
			fiftyBills -= _amount;
			System.out.println("Transaction successful");
		}
		else {
			System.out.println("The amount you requested is greater than what is available");
		}
	}
	/**
	 * method which removes 100 dollar bills from the atm
	 * @param _amount
	 */
	public void removeHunderedBills(int _amount) {
		if(hunderedBills>=_amount) {
			hunderedBills -= _amount;
			System.out.println("Transaction successful");
		}
		else {
			System.out.println("The amount you requested is greater than what is available");
		}
	}
	/**
	 * method which makes a deposit to a specified account
	 * @param _temp the account the deposit needs to be made to 
	 * @param _depositType account 
	 * @param _amount
	 */
	public void makeDeposit(Accounts _temp, String _depositType, double _amount) {
		if(_depositType.equals("Checking")) {
			_temp.addToCheckingBalance(_amount);
		}
		if(_depositType.equals("Saving")) {
			_temp.addToSavingsBalance(_amount);
		}
	}
	/**
	 * makes a transfer between accounts by subtracting the balance from the person sending the amount
	 * and adding to the account recieving the account
	 * @param _transfering the account that is transfering the money
	 * @param _acceptingTransfer the account that is receiving the account
	 * @param _amount amount to be transfered
	 */
	public void makeTransaction(Accounts _transfering, Accounts _acceptingTransfer, double _amount) {
		_transfering.subtractFromCheckingBalance(_amount);
		_acceptingTransfer.addToCheckingBalance(_amount);
		System.out.println("Transaction Successful");
	}
	/**
	 * checks to see if a withdrawal is possible given the accont and amount
	 * @param _temp account that is requesting the withdraw
	 * @param _amount amount to be withdrawn
	 * @param _withdrawalType which account the withdrawal is to be made from
	 * @return returns a boolean that checks to see if the withdraw is possible
	 */ 
	public boolean isWithdrawalPossible(Accounts _temp, double _amount, String _withdrawalType) {
		boolean verify = false;
		int amountAvailable = 0;
		amountAvailable += (HUNDERED_VALUE * hunderedBills) + (FIFTY_VALUE + fiftyBills) + (TWENTY_VALUE + twentyBills) + (TEN_VALUE + tenBills) + (FIVE_VALUE + fiveBills);
		if(_amount % 5 > 0) {
			System.out.println("The amount you entered must be divisible by 5");
		}
		else if(amountAvailable < _amount) {
			System.out.println("This ATM currently does not have enough funds to make that transaction, sorry.");
		}else {
			verify = true;
		}
		return verify;
	}
	/**
	 * if boolean is true from the isWithdrawalPossible method 
	 * the withdrawal is made
	 * @param _temp the account the withdrawal is being made for
	 * @param _amount the amount to be withdrawn
	 * @param _withdrawalType the account the withdrawal is to be made for 
	 */
	public void makeWithdrawal(Accounts _temp, double _amount, String _withdrawalType) {
		 amountOfFiveBillsToGive = 0;
		 amountOfTenBillsToGive = 0;
		 amountOfTwentyBillsToGive = 0;
		 amountOfFiftyBillsToGive = 0;
		 amountOfHunderedBillsToGive = 0;
		 amount = _amount;
		
		if(_withdrawalType.equals("Checking")) 
			_temp.subtractFromCheckingBalance(_amount);
		if(_withdrawalType.equals("Saving"))
			_temp.subtractFromSavingBalance(_amount);
		
		settingHunderedBillAmounts();
		settingFiftyBillAmounts();
		settingTwentyBillAmounts();
		settingTenBillAmounts();
		settingFiveBillAmounts();
		
		System.out.println();
		System.out.println("Transaction Successful you will be recieving");
		System.out.println("Hundered Bills: " + amountOfHunderedBillsToGive);
		System.out.println("Fifty Bills: " + amountOfFiftyBillsToGive);
		System.out.println("Twenty Bills: " + amountOfTwentyBillsToGive);
		System.out.println("Ten Bills: " + amountOfTenBillsToGive);
		System.out.println("Five Bills: " + amountOfFiveBillsToGive);
		
		
	}
	/**
	 * private helper method
	 * method that removes 100 dollar bills from the atm upon withdrawal
	 */
	private void settingHunderedBillAmounts() {
		int amountOfBills = (int)amount/HUNDERED_VALUE;
		if(amountOfBills>0) {
			if(amountOfBills<=hunderedBills) {
				amountOfHunderedBillsToGive = amountOfBills;
				hunderedBills -= amountOfBills;
				amount = amount % HUNDERED_VALUE;
			}
			else if(amountOfBills>hunderedBills) {
				amountOfHunderedBillsToGive = hunderedBills;
				hunderedBills = 0;
				amount = amount - (amountOfHunderedBillsToGive * HUNDERED_VALUE);
			}
		}
	}
	/**
	 * private helper method
	 * method that removes 50 dollar bills from the atm upon withdrawal
	 */
	private void settingFiftyBillAmounts() {
		int amountOfBills = (int)amount/FIFTY_VALUE;
		if(amountOfBills>0) {
			if(amountOfBills<=fiftyBills) {
				amountOfFiftyBillsToGive = amountOfBills;
				fiftyBills -= amountOfBills;
				amount = amount % FIFTY_VALUE;
			}
			else if(amountOfBills>fiftyBills) {
				amountOfFiftyBillsToGive = fiftyBills;
				fiftyBills = 0;
				amount = amount - (amountOfFiftyBillsToGive * FIFTY_VALUE);
			}
		}
	}
	/**
	 * private helper method
	 * method that removes 20 bills from the atm upon withdrawal
	 */
	private void settingTwentyBillAmounts() {
		int amountOfBills = (int)amount/TWENTY_VALUE;
		if(amountOfBills>0) {
			if(amountOfBills<=twentyBills) {
				amountOfTwentyBillsToGive = amountOfBills;
				twentyBills -= amountOfBills;
				amount = amount % TWENTY_VALUE;
			}
			else if(amountOfBills>twentyBills) {
				amountOfTwentyBillsToGive = twentyBills;
				twentyBills = 0;
				amount = amount - (amountOfTwentyBillsToGive * TWENTY_VALUE);
			}
		}
	}
	/**
	 * private helper method
	 * method checks to see if 10 bills need to be removed from atm upon withdrawal
	 * if bills need to be removed it removes them and checks if there are any to remove
	 */
	private void settingTenBillAmounts() {
		int amountOfBills =(int)amount/TEN_VALUE;
		if(amountOfBills>0) {
			if(amountOfBills<=tenBills) {
				amountOfTenBillsToGive = amountOfBills;
				tenBills -= amountOfBills;
				amount = amount % TEN_VALUE;
			}
			else if(amountOfBills>tenBills) {
				amountOfTenBillsToGive = tenBills;
				tenBills = 0;
				amount = amount - (amountOfTenBillsToGive * TEN_VALUE);
			}
		}
	}
	/**
	 * private helper method
	 * method checks to see if 5 bills need to be removed for withdrawal
	 * if they need to be removed they will be removed
	 */
	private void settingFiveBillAmounts() {
		int amountOfBills = (int)amount/FIVE_VALUE;
		if(amountOfBills>0) {
			if(amountOfBills<=fiveBills) {
				amountOfFiveBillsToGive = amountOfBills;
				fiveBills -= amountOfBills;
				amount = amount % FIVE_VALUE;
			}
			else if(amountOfBills>fiveBills) {
				amountOfFiveBillsToGive = fiveBills;
				fiveBills = 0;
				amount = amount - (amountOfFiveBillsToGive * FIVE_VALUE);
			}
		}
	}
	/**
	 * to string method that shows how many bills are in the atm at any given moment
	 */
	public String toString() {
		return "\nHundered Bills: " + hunderedBills + "\nFifty Bills: " + fiftyBills + "\nTwenty Bills: " + twentyBills + "\nTen Bills: " + tenBills + "\nFive Bills: " + fiveBills;
	}
}
