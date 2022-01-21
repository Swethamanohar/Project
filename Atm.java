import java.util.*;
import java.io.*;
class ATM{
    
    public static final Scanner sc=new Scanner(System.in);

    static ATM[] atm;

    public String name,pin;
    public int balance=0;
    public ArrayList<String> User_Statement;
    

    ATM(String name,String pin,int balance){
        this.name=name;
        this.pin=pin;
        this.balance=balance;
    }
    
    
   public static boolean adminpass(){
        Boolean b=true;
        for(int x=1;x<=3;x++){
            int a=1;
            System.out.println();  
            System.out.println("---Continue to login---");
            System.out.println();
            System.out.print("Admin name : ");     
            String name=sc.nextLine();
            System.out.print("password : ");     
            String password=sc.nextLine();
            if(name.equals("Swetha") && password.equals("2002") && a<=3){
                System.out.println();
                b=true;
                break;
                
            }
            else{
                System.out.println();
                System.out.println("Invalid name or password");
                a+=1;
                b=false;
                if(x==1){
                    System.out.println("You are left with 2 more attempts");
                }
                else if(x==2){
                    System.out.println("You are left with 1 more attempts");
                }
                else if(x==3){
                    System.out.println("!!!No more Attempts left!!!");
                    break;
                }
                
            }
        }
        return b;
        
    }
    
    public static int userpass(int s1,int r2,int t3){
        Boolean b=true;
        int currentuser=-1;
        for(int x=1;x<=3;x++){
            int a=1;
            
            System.out.println();  
            System.out.println("---Continue to login---");
            System.out.println();
            System.out.print("Username : ");     
            String name=sc.nextLine();
            System.out.print("pin number : ");     
            String password=sc.nextLine();
            
            if (atm[s1].name.equals(name) && atm[s1].pin.equals(password)){
                currentuser = s1;                    
                b=true;
                break;
            }
            else if(atm[r2].name.equals(name) && atm[r2].pin.equals(password)){
                currentuser = r2;                    
                b=true;
                break;
            }
            else if(atm[t3].name.equals(name) && atm[t3].pin.equals(password)) {
                currentuser = t3;                    
                b=true;
                break;
            }
            else{
                System.out.println();
                System.out.println("Invalid name or password");
                a+=1;
                b=false;
                if(x==1){
                    System.out.println("You are left with 2 more attempts");
                }
                else if(x==2){
                    System.out.println("You are left with 1 more attempts");
                }
                else if(x==3){
                    System.out.println("!!!No more Attempts left!!!");
                    break;
                }
            }
        }
        return currentuser;
    }

public static void main(String args[]){
      
    Scanner sc=new Scanner(System.in);
    int balance=25000,deposit;
    int withdraw;
    System.out.println("Welcome to Automated Teller Machine!!!");

    
    
    atm = new ATM[3];
    atm[0] = new ATM("swetha", "7202", 3000);
    atm[0].User_Statement = new ArrayList<>();
    atm[1] = new ATM("ridhu", "7202", 5000);
    atm[1].User_Statement = new ArrayList<>();
    atm[2] = new ATM("taanu", "7202", 6000);
    atm[2].User_Statement = new ArrayList<>();

    while(true){
        System.out.println();
        System.out.println("Select your UserType...");
        System.out.println();
        System.out.println("Choose 1 for Admin");
        System.out.println("Choose 2 for User");
        System.out.println("Choose 3 for Exit");
        System.out.println();
        int n=sc.nextInt();
        
        switch(n){
            case 1:
            if(adminpass()){
            System.out.println("Welcome Admin");
            System.out.println();
            System.out.println("Type 1 - Deposit funds");
            System.out.println("Type 2 - View balance ");
            System.out.println("Type 3 - Exit");
            System.out.println();
            System.out.print("Enter your choice : ");
            int ad=sc.nextInt();
            if(ad==1){
                System.out.println("Enter the amount to deposit: ");
                deposit=sc.nextInt();
                balance=balance+deposit;
                System.out.println("Balance Amount is:  "+balance);
                System.out.println("Your money Deposited Successfully...");
            }
            else if(ad==2) {
            	System.out.println("Balance of your account is:  "+balance);
            }
            
            else if(ad==3){
                
                System.out.println();
                System.out.println("Thank you for using our ATM");
                break;           
            }
            else{
                System.out.println("Ivalid Input");
                System.out.println("Please check the input and try again !!!");
            }
            }  
            break;

            case 2:
            
            int s1=0,r2=1,t3=2;
            int c=-1;
            boolean b=false;
            int cur=userpass(s1, r2, t3);
            if(cur==0){
                c=0;
                b=true;
            }
            else if(cur==1){
                c=1;
                b=true;
            }
            else if(cur==2){
                c=2;
                b=true;
            }

            if(b==true){
            
            System.out.println();
            System.out.println("\n Hello..."+atm[c].name+"\n");
            System.out.println("1.Withdraw fund");
            System.out.println("2.Check account balance");
            System.out.println("3.Mini Statement");
            System.out.println("4.Change you Pin");
            System.out.println("5.Exit");
            System.out.println();
            System.out.println();
            System.out.println("Enter your choice");
            int user=sc.nextInt();
                      
            if(user==1){
                System.out.print("Enter amount to withdraw : ");
                
                withdraw=sc.nextInt();
               
                if(balance>=withdraw){
                    
                    
                    balance=balance-withdraw;
                    
                    System.out.println("Your account balance is:  "+balance);
                    System.out.println();
                    System.out.println("Please collect your cash");
              
                    
                }
                
                else{
                    System.out.println("You don't have enough money to withdraw");
                    System.out.println("Your Account balance is:  "+balance);                   
                }
            }
            else if(user==2){
                System.out.println("Your Account balance is:  "+balance);
                
            }
           
            else if(user==3){
                System.out.println("Mini Statement !");
                if(atm[c].User_Statement.size()>=1){
                    for (int k = 0;k < atm[c].User_Statement.size(); k++) {
                        System.out.println(atm[c].User_Statement.get(k));
                    }
                break;
                }
                else{
                    System.out.println("\nThere is no transactions yet...");
                    break;
                }
            }
            else if(user==4){
                System.out.print("Enter your Old Pin: ");
                String oldpin = sc.next();
                sc.nextLine();
                System.out.print("Enter your new pin: ");
                String newpin = sc.nextLine();
               
                if(atm[c].pin.equals(oldpin)){
                atm[c].pin = newpin;
                System.out.println("Pin has been changed Successfully !!!");
                break;
                }
                else{
                    System.out.println("Incorrect old pin...");
                }
            }
            else if(user==5){
                
                System.out.println("Exit Successfully!!!");
                System.out.println();
                System.out.println("Thank you for using our ATM");
                break;
            }
            else{
                System.out.println("Invalid Input");
                System.out.println("Please check the input and try again...");
            }
            }
            break;
            case 3:
                
                System.out.println();
                System.out.println("Thank you for using our ATM");
                System.exit(0);
                break;
        }
    }
}
}
