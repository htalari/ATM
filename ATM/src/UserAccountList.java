/**
 * UserAccountList represents a list of all the user accounts that are usable in the ATM
 * @author haritalari
 * version 1.0
 */

import java.util.ArrayList;

public class UserAccountList {
	
	private ArrayList<Accounts> accountList = new ArrayList<Accounts>();
	/**
	 * method which adds user accounts to an array list
	 * @param _account adds this user account to the array list
	 */
	public void addAccount(Accounts _account) {
		accountList.add(_account);
	}
	/**
	 * method which checks to see if a username and password combo are in the list
	 * @param _name given username to check
	 * @param _passCode given password to check 
	 * @return returns a boolean for if the account is or is not in the list
	 */
	public boolean verifyUser(String _name, String _passCode) {
		boolean verify = false;
		for(int i = 0;i<accountList.size();i++) {
			Accounts temp = accountList.get(i);
			if(temp.getName().equals(_name) && temp.getPassCode().equals(_passCode)) {
				verify = true;
			}
		}
		return verify;
	}
	/**
	 * method which checks to see if an account number is related to any account in list
	 * @param _accountNum account number to be checked 
	 * @return returns the account for which the account number pertains to if it is in the list
	 */
	public Accounts verifyAccountNumber(int _accountNum) {
		Accounts returning = null;
		for (int i = 0;i<accountList.size();i++) {
			Accounts temp = accountList.get(i);
			if(temp.getAccountNumber() == _accountNum) {
				returning = temp;
			}
		}
		return returning;
	}
	/**
	 * grabs user account that pertains to a specified username and password
	 * @param _name username to check for
	 * @param _passCode password to check for
	 * @return returns the account to which the username or password pertains to if the parameters are valid
	 */
	public Accounts getAccount(String _name, String _passCode) {
		Accounts returning = null;
		for(int i = 0;i<accountList.size();i++) {
			Accounts temp = accountList.get(i);
			if(temp.getName().equals(_name) && temp.getPassCode().equals(_passCode)) {
				returning = temp;
			}
		}
		return returning;
	}
}
