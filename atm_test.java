import java.io.*;
import java.util.*;
class atm_test
{
    public static void main() throws IOException
    {
        FileReader fr = new FileReader("/Users/medhansh/Documents/Projects/ATM.txt");
        BufferedReader bw = new BufferedReader(fr);
        Scanner sc = new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        String s = ""; int y;
        char ch;
        while((s=bw.readLine())!=null)
        {
            System.out.println("Enter your 3-digit pin number");
            int x = sc.nextInt();
            StringTokenizer st = new StringTokenizer(s,",");
            y = st.countTokens();
            String A[] = new String[y];
            for(int a=0; a<y; a++)
                A[a] = st.nextToken();
            if(String.valueOf(x) == A[1])
            {
                System.out.println("Valid Pin");
                System.out.println("Name: " + A[2]);
            }
        }
    }
}