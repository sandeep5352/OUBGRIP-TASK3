import java.util.*;
public class Main
{
    static String name;
    static int ac,pin,ap,choice,a,trans_count=0,c=0;
    static Scanner sc=new Scanner(System.in);
    static boolean flag=true;
    static float balance=20000f;
    static String History="";
    
    public static void register(){
        System.out.println("Enter your name:");
        name=sc.next();
        System.out.println("Enter your Account number:");
        ac=sc.nextInt();
        System.out.println("Enter your pin:");
        pin=sc.nextInt();
        System.out.println("Hello "+name+" you have registered successfully.\n");
        
    }
    public static void login(){
        System.out.printf("\nFor login Enter your ATM pin:");
        ap=sc.nextInt();
        if(ap==pin){
            System.out.println("Loggined successfully");
        }
        else{
            System.out.println("Please enter correct pin!!!");
            c=c+1;
            if(c==3){
                System.out.println("You have reached your maximum limits , try after 24 hrs ");
                System.exit(0);
            }
            login();
            
        }
    }
    public static void deposit() {
        System.out.print("\nEnter the amount you want to Deposit  :");
        float dep_amount=sc.nextFloat();
        balance+=dep_amount;
        trans_count+=1;
        History=History.concat(dep_amount+" Rupees deposited into your account\n");
        System.out.println("If you want to display the balance  Enter 1 else 0:");
        a=sc.nextInt();
        if(a==1){
            total_bal();
        }
    }
	public static void transfer() {
        System.out.println("\nEnter the Account number of person to whom you want to transfer :");
        int tran_acc=sc.nextInt();
        System.out.println("\nEnter the amount you want to Transfer :");
        float tran_amount=sc.nextFloat();
        if(tran_amount<=balance) {
            System.out.println("\n "+tran_amount+" Rupees is successfully transferred to account number "+tran_acc);
            balance-=tran_amount;
            trans_count+=1;
            History=History.concat(tran_amount+" Rupees tranferred from your account\n");
        }
        else {
        System.out.println("Sorry money transfer is not possible! due to INSUFFICIENT BALANCE");
        }
    }
	
    public static void withdraw() {
        System.out.println("\nEnter the amount you want to Withdraw  :");
        float withdr_amount=sc.nextFloat();
        if(withdr_amount<=balance) {
            balance-=withdr_amount;
            trans_count+=1;
            History=History.concat(withdr_amount+" Rupees withdrawn from your account\n");
            System.out.println("Amount withdrawn successfully");
            System.out.println("If you want to display the balance  Enter 1 else 0:");
            a=sc.nextInt();
            if(a==1){
                total_bal();
            }
            
        }
        else {
            System.out.println("\nSorry you can't withdraw!! INSUFFICIENT BALANCE");
        }
    }


    public static void total_bal() {
    System.out.println("\nYour Current Balance is "+balance+" Rupees");
    }

    public static void trans_History() {
        if(trans_count>0) {
            System.out.println("\nYou have performed "+trans_count+" transactions.");
            System.out.println("\nTransaction Details:");
            System.out.print(History);
        }
        else {
            System.out.println("\nNo Transactions are performed.");}
        
    }
	public static void main(String[] args) {
		System.out.println("** ~ Welcome to ATM interface ~ **");
		System.out.println();
		System.out.println();
		System.out.println("If you are a new user enter 1 or else 0 : ");
		int input=sc.nextInt();
		if(input==1){
		    register();
		    login();
		    while(flag==true) {
		        System.out.println("\nchoose one option to perform:");
		        System.out.println("\n1.DEPOSIT\n2.WITHDRAW\n3.TRANSFER\n4.TRANSACTION HISTORY\n5.CHECK BALANCE\n6.QUIT");
		        choice=sc.nextInt();
		        switch(choice) {
		            case 1:deposit();
		            break;
		            case 2:withdraw();
		            break;
		            case 3:transfer();
		            break;
		            case 4:trans_History();
		            break;
		            case 5:total_bal();
		            break;
		            case 6:flag=false;
		            System.out.println("\nplease collect your card\nThank you");
		            break;
		            default:System.out.println("Please select an option from 1 to 6"); }
		            }
		    }
		    else{
		        login();
		        while(flag==true) {
		        System.out.println("\nchoose one option to perform:");
		        System.out.println("\n1.DEPOSIT\n2.WITHDRAW\n3.TRANSFER\n4.TRANSACTION HISTORY\n5.CHECK BALANCE\n6.QUIT");
		        choice=sc.nextInt();
		        switch(choice) {
		            case 1:deposit();
		            break;
		            case 2:withdraw();
		            break;
		            case 3:transfer();
		            break;
		            case 4:trans_History();
		            break;
		            case 5:total_bal();
		            break;
		            case 6:flag=false;
		            System.out.println("\nplease collect your card\nThank you");
		            break;
		            default:System.out.println("Please select an option from 1 to 6"); 
				    }
		        }
		    }
	    }
     }
