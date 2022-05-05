import java.io.*;
import java.util.*;
class atm_project
{
    int acc_num, pin, balance_amt, amount,z;
    String name, dtt;
    char acc_type, transaction_type;
    DATE transaction_dt, joining_dt;
    Scanner sc = new Scanner(System.in);
    Scanner in = new Scanner(System.in);
    public void new_acc() throws IOException
    {
        FileWriter fw = new FileWriter("/Users/medhansh/Documents/Projects/Master.txt",true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        String n; char ch;
        int r,m,p,c,a;
        do
        {
            System.out.println("Enter your account number");
            acc_num = in.nextInt();
            System.out.println("Enter your name");
            name = sc.nextLine();
            System.out.println("Enter your 4-digit PIN");
            pin = in.nextInt();
            System.out.println("Enter your type of account[S for Savings or C for Current]");
            acc_type = in.next().toUpperCase().charAt(0);
            System.out.println("Enter your balance_amt");
            balance_amt = in.nextInt();
            System.out.println("Enter the date of joining");
            dtt = sc.nextLine();
            joining_dt = new DATE(dtt);
            pw.println(acc_num + "," + pin + "," + name + "," + acc_type + "," + balance_amt + "," + dtt);
            System.out.println("Do you want to enter another customer's details. Enter 'Y' if you want to, otherwise enter 'N'");
            ch = in.next().toUpperCase().charAt(0);
        }while(ch=='Y');
        pw.close(); 
        bw.close();
        fw.close();
    }

    public void checkbalance(int pin_num) throws IOException
    {
        FileReader fr = new FileReader("/Users/medhansh/Documents/Projects/Master.txt");
        BufferedReader bw = new BufferedReader(fr);
        String s="";
        while((s=bw.readLine())!=null)
        {
            int a,p,x;
            char ch;
            StringTokenizer st = new StringTokenizer(s,",");
            x = st.countTokens();
            String A[] = new String[x];
            for(int b=0; b<x; b++)
                A[b] = st.nextToken();
            if(A[1].equals(String.valueOf(pin_num)))
            {
                System.out.println("Balance amount: " + A[4]);
                break;
            }
        }
        bw.close();
        fr.close();
    }

    public int withdraw(int pin_num, int p) throws IOException
    {
        FileReader fr = new FileReader("/Users/medhansh/Documents/Projects/Master.txt");
        BufferedReader bw = new BufferedReader(fr);
        String s = "";
        char ch;
        int x,a=0,cnt=-1;
        while((s=bw.readLine())!=null)
        {
            cnt++;
            StringTokenizer st = new StringTokenizer(s,",");
            x = st.countTokens();
            String A[] = new String[x];
            for(int b=0; b<x; b++)
                A[b] = st.nextToken();
            if(A[1].equals(String.valueOf(pin_num)))
            {
                a = Integer.parseInt(A[4]);
                a-=p;
                break;
            }
        }
        bw.close();
        fr.close();
        return cnt;
    }
    
    public int deposit(int pin_num, int p) throws IOException
    {
        FileReader fr = new FileReader("/Users/medhansh/Documents/Projects/Master.txt");
        BufferedReader bw = new BufferedReader(fr);
        String s = "";
        char ch;
        int x,a=0,cnt=0;;
        while((s=bw.readLine())!=null)
        {
            cnt++;
            StringTokenizer st = new StringTokenizer(s,",");
            x = st.countTokens();
            String A[] = new String[x];
            for(int b=0; b<x; b++)
                A[b] = st.nextToken();
            if(A[1].equals(String.valueOf(pin_num)))
            {
                a = Integer.parseInt(A[4]);
                a+=p;
                break;
            }
        }
        bw.close();
        fr.close();
        return cnt;
    }
    
    public void print(int acc_num) throws IOException
    {
        FileReader fr = new FileReader("/Users/medhansh/Documents/Projects/Transactions.txt");
        BufferedReader bw = new BufferedReader(fr);
        String s="";
        int cnt=0,x;
        System.out.println("Account Number      Date of Transaction     Type of Transaction     Amount transacted");
        while((s=bw.readLine())!=null)
        {
            StringTokenizer st = new StringTokenizer(s,",");
            x = st.countTokens();
            String A[] = new String[x];
            for(int b=0; b<x; b++)
                A[b] = st.nextToken();
            if(A[0].equals(String.valueOf(acc_num)))
            {
                cnt++;
                System.out.println(acc_num + "              " + A[1] + "              " + A[2] + "                       " + A[3]);
            }
            if(cnt==3)
                break;
        }
    }
}