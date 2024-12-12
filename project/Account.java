package project;
 enum Type{
	 SAVINGS,
	 CURRENT
	 
 }
public class Account {

 private int AccountNo;
 
 private String Name;
 
 private Type AccountType;
 
 private double Balance;
 
 public Account(int AccountNo,String Name,Type AccountType,double Balance) {
	 
	 this.AccountNo=AccountNo;
	 
	 this.Name=Name;
	 
	 this.AccountType=AccountType;
	 
	 this.Balance =Balance;
 }
public int getAccountNo() {
	return AccountNo;
}
public void setAccountNo(int accountNo) {
	AccountNo = accountNo;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public Type getAccountType() {
	return AccountType;
}
public void setAccountType(Type accountType) {
	AccountType = accountType;
}
public double getBalance() {
	return Balance;
}
public void setBalance(double balance) {
	
	Balance = balance;
}
public void deposit(double amount) {
	if(amount>0) {
		 Balance = Balance+amount;
		System.out.println("Amount Deposit is Sucessfully");
	}
	else {
		System.out.println("invalid deposit amount");
	}
}


public void withdraw(double amount) {
	  
	if(amount > 0 && amount <= Balance) {
		 Balance = Balance-amount;
		
		 System.out.println("Withdraw Sucessfully");
		}
		else {
			System.out.println("you have insufficint balance");
		}
	
}
}



