package project;

import java.util.ArrayList;  
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bank 
{
	  private static  ArrayList<Account> accDetails= new ArrayList<>();
	  	 
  public static void Addaccount(Account ac) 
  {
           accDetails.add(ac);
           System.out.println("account added sucessfully");
           
	  
  }
  public static void SearchAccountNumber(int AccountNo )
  {
	List<Account> account = accDetails.stream()
               .filter(ac -> ac.getAccountNo() == AccountNo)
               .collect(Collectors.toList());
	
      if(account.isEmpty())
      {
    	  System.out.println(" Account No found");
      }
      else
      {
    	  
    	  Account account1 = account.get(0);
     	
    	 System.out.println("account found");
		 
    	 System.out.println("Holder AccountNumber: "+account1.getAccountNo());
		 
    	 System.out.println("Holder Name: "+account1.getName());
		 
    	 System.out.println("Holder AccountBalance: "+account1.getBalance());
		 
    	 System.out.println("Holder AccountType: "+account1.getAccountType());
	}
  }
  
  
 
  
  public static void Deposit(int AccountNo, double depositamount) {
      List<Account> isAvail = accDetails.stream() //flag
              .filter(ac -> ac.getAccountNo() == AccountNo)
              .collect(Collectors.toList());

      if (!isAvail.isEmpty())
      {
         
    	  Account account = isAvail.get(0);
          
    	  account.deposit(depositamount);
          
    	  System.out.println("Deposit Successfully. New Balance: " + account.getBalance());
      }
      else 
      {
          System.out.println("Account No Not Found");
      }
  }
      
  
      
      
      public static void  Withdraw(int AccountNo, double withdrawamount) {
          List<Account> isAvail = accDetails.stream()
                  .filter(ac -> ac.getAccountNo() == AccountNo)
                  .collect(Collectors.toList());

          if (!isAvail.isEmpty())
          {
              Account account = isAvail.get(0);
              if (withdrawamount > account.getBalance()) 
              {
                  System.out.println("Insufficient Balance");
              } 
              else
              {
                  account.withdraw(withdrawamount);
                  System.out.println("Withdraw Successfully. New Balance: " + account.getBalance());
              }
          } 
          else
          {
              System.out.println("Account No Not Found");
          }
      }
  	
      public static void ViewAllAccount() 
      {
    	  if(accDetails.isEmpty()) 
    	  {
    	  System.out.println("No account found");
    	  }
    	  else
    	  {
    	  for(Account account:accDetails)
    	  {
     System.out.println("Holder AccountNumber: "+account.getAccountNo());
     
     System.out.println("Holder Name: "+account.getName());
     
     System.out.println("Holder AccountBalance: "+account.getBalance());
     
     System.out.println("Holder AccountType: "+account.getAccountType());
     
    	  
    	  }
    	  }
      }
public static boolean isValidName(String Name) 
{
    	  return Name.matches("[a-zA-Z]+");
}

	
  
	public static void main(String[] args) {
     
     
     Scanner sc = new Scanner(System.in);
     
     String choice ="Y";
     
     while(choice.equalsIgnoreCase("y")) {
   
    	 System.out.println("Welocome to our Bank Service");
    	
    	 System.out.println("1.Add Account\t 2.searchAccountNumber\t 3.deposit\t 4.Withdraw\t 5.ViewallAcount\t 6.interest\t"  );
    	 
    	 int prefchoice = sc.nextInt();
    	 
    	 switch(prefchoice){
    	 
    	 case 1:
    	
         System.out.println("enter the AccountNumber ");
    	
         int  AccountNo =  sc.nextInt();
         
         String Name;
    	 
         while (true) {
    		   
        	 System.out.println("Enter the name: ");
    		 
        	 Name = sc.next();
    		 
        	 if (isValidName(Name)) 
        	 {
    		      
        		 break; 
    		    } 
        	 else 
        	 {
    		        System.out.println("Invalid name. Please enter only alphabetic characters.");
    		    }
    		}

    	 System.out.println("enter the account type/(Savings/Current)");
    	 
    	 String AccountType = sc.next().toUpperCase();
    	 try 
    	 {
    		 Type Accounttype = Type.valueOf(AccountType);
    		 
    		 System.out.println("Enter the Intial Balance you want deposit");
        	 
    		 double Balance = sc.nextDouble();
        	 
        	 Account account = new Account(AccountNo,Name,Accounttype,Balance);
        	  
        	 Addaccount(account);
    	 }
    	 catch(IllegalArgumentException e) 
    	 {
    		 System.out.println(" Invalid Account Type : Please enter a valid type" );
    	 }
    	 break;
    	 
 
    	 case 2:
            System.out.println("Enter the AccountNo");
    		 
    		 int accountNo= sc.nextInt();
    		 
    		 SearchAccountNumber(accountNo);
    		 break;
    		 	
    	 case 3:
    		 
    		 System.out.println("Enter the AccountNo");
   		  
  		      accountNo = sc.nextInt();
		
  		      if(accDetails.stream().noneMatch(ac->ac.getAccountNo()==accountNo))
  		      {
			 System.out.println("Account No Found");
		      }
  		      else 
  		      {
		       System.out.println("Enter the Depsoit Amount");
		 
		       double despoistamount = sc.nextDouble();
		      
		       Deposit(accountNo, despoistamount);
		 }
		  break;
      		  
    	 case 4:
    		 System.out.println("Enter the AccountNo");
  		 
		     accountNo = sc.nextInt();
  		
		     if(accDetails.stream().noneMatch(ac->ac.getAccountNo()==accountNo)) 
		    {
			 System.out.println("Account No Found");
		     }
             else 
		    {
			 System.out.println("Enter the  WithdrawAmount");
	   		  
			 double withdrawamount = sc.nextDouble();
	   		 
			 Withdraw(accountNo, withdrawamount);
		     }  
  		     break;
    		 
    	 case 5:
    		 
             ViewAllAccount();
    		 
    		 break;
    	 case 6:
    		 double principle =sc.nextDouble();
    		 double rate = sc.nextDouble();
    		 int year =sc.nextInt();
    		 double SI = ( principle*rate*year)/100;
    		 System.out.println(SI);
    		 break;
    			
    	
    		 
   		  
   	 default:
   		 System.out.println("Invalid Berth Preference");
    	 }
    	
    	 System.out.println("Do You Want Continue (y/n)");
   		  
    	 choice  = sc.next();
   		  
    	 System.out.println("Thank you for Choosing our Bank ");
    	 
    	 }
     sc.close();
	}
}
