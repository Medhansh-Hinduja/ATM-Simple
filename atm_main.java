import java.io.*;
import java.util.*;
class atm_main
{
    public static void main() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        atm_master obj1 = new atm_master();
        atm_transactions obj = new atm_transactions();
        obj1.loading();
        int acc_num, pin,w,d,a=0,b=0,x=0,chk=0;
        char ch;
        chk = obj1.validate();//chk contains index position of the user's data
        if(chk==-1)
        {
            System.out.println("Login Failed");
            System.exit(0);
        }
        do
        {
            /** MENU */
            System.out.println("1. Check Account Balance");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Deposit Cash");
            System.out.println("4. Display your last 3 transactions");
            System.out.println("5. Exit");
            System.out.println("Enter your choice - 1/2/3/4/5");
            x = sc.nextInt();
            if(x==1)
            {
                obj1.display_balance(chk);
            }
            else if(x==2)
            {
                if(obj.withdraw(obj1, chk) == -1)
                    System.out.println("Withdrawal Failed");
                else
                    System.out.println("Withdrawal Successful");
            }
            else if(x==3)
            {
                if(obj.deposit(obj1, chk) == -1)
                    System.out.println("Deposit Failed");
                else
                    System.out.println("Deposit Successful");  
            }
            else if(x==4)
            {
                obj1.last3_transactions(chk);
            }
            else if(x==5)
            {
                obj.close();
                obj1.update_file();
            }
        }while(x!=5);
        System.out.println("Thank you for choosing our ATM. Have a nice day!");
    }    
}