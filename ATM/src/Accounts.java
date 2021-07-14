/**
 * Accounts class represents accounts created for use at ATM
 * @author haritalari
 * version 1.0
 */
public class Accounts {
	private String name;
	private int accountNumber;
	private String passCode;
	private double checkingBalance;
	private double savingsBalance;
	/**
	 * constructor that creates a user account
	 * @param _name creates the name of the user 
	 * @param _accountNumber creates the user account number
	 * @param _passCode creates the user passcode
	 * @param _checkingBalance creates the checking balance of user
	 * @param _savingsBalance creates the savings balance of hte user
	 */
	public Accounts(String _name, int _accountNumber, String _passCode, Double _checkingBalance, Double _savingsBalance ) {
		name = _name;
		accountNumber = _accountNumber;
		passCode = _passCode;
		checkingBalance = _checkingBalance;
		savingsBalance = _savingsBalance;
	}
	/**
	 * constructor
	 * creates the operator account for user 
	 * @param _passCode creates passcode for operator
	 */
	public Accounts(String _passCode) {
		passCode = _passCode;
	}
	/**
	 * getter method 
	 * @return returns name of user account
	 */
	public String getName() {
		return name;
	}
	/**
	 * getter method
	 * @return returns the passcode of an account
	 */
	public String getPassCode() {
		return passCode;
	}
	/**
	 * getter method
	 * @return returns the checking balance of a user account
	 */
	public double getCheckingBalance() {
		return checkingBalance;
	}
	/**
	 * getter method
	 * @return returns savings balance of a user account
	 */
	public double getSavingsBalance() {
		return savingsBalance;
	}
	/**
	 * getter method
	 * @return returns account number for user account
	 */
	public int getAccountNumber() {
		return accountNumber;
	}
	/**
	 * setter method
	 * @param _amount adds balance to checking account 
	 */
	public void addToCheckingBalance(double _amount) {
		checkingBalance = checkingBalance + _amount;
	}
	/**
	 * setter method
	 * @param _amount adds balance to savings account
	 */
	public void addToSavingsBalance(double _amount) {
		savingsBalance = savingsBalance + _amount;
	}
	/**
	 * setter method
	 * @param _amount subtracts funds from users checking account
	 */
	public void subtractFromCheckingBalance(double _amount) {
		checkingBalance = checkingBalance - _amount;
	}
	/**
	 * setter method
	 * @param _amount subtracts funds from users savings account
	 */
	public void subtractFromSavingBalance(double _amount) {
		savingsBalance = savingsBalance - _amount;
	}
}
