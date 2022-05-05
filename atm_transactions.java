import java.util.*;
import java.io.*;
class atm_transactions
{
    int acc_num, amt;
    char acc_type;
    String date;
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter pw;
    public atm_transactions() throws IOException
    {
        fw = new FileWriter("Transactions.txt", true);
        bw = new BufferedWriter(fw);
        pw = new PrintWriter(bw);
    }

    public int withdraw(atm_master obj, int index) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter withdrawal amount");
        amt = sc.nextInt();
        System.out.println("Date of transaction");
        date = in.next();
        acc_num = obj.get_accnum(index);
        acc_type = 'W';
        boolean chk = obj.check_balance(index, amt);
        if(!chk)
            return -1; 
        obj.update_balance(index,'W',amt);
        pw.println(acc_num + "," + date + "," + acc_type + "," + amt);
        return 1;
    }

    public int deposit(atm_master obj, int index) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        System.out.println("Enter deposit amount");
        amt = sc.nextInt();
        System.out.println("Date of transaction");
        date = in.next();
        acc_num = obj.get_accnum(index);
        acc_type = 'D';  
        pw.println(acc_num + "," + date + "," + acc_type + "," + amt);
        obj.update_balance(index,'D',amt);
        return 1;
    }

    public void close() throws IOException
    {
        pw.close();
        bw.close();
        fw.close();
    }
}