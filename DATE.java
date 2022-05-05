import java.util.Scanner;
class DATE
{
    int dt,mn,yr;
    static int days[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
    static String A[] = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
    public DATE()
    {
        dt=1;
        mn=1;
        yr=1900;
    }

    public DATE(int dt, int mn, int yr)
    {
        this.dt=dt;
        this.mn=mn;
        this.yr=yr;
        if(!validate())
            dt=mn=yr=0;
    }

    public DATE(String s)
    {
        int a=s.indexOf('/');
        int b=s.lastIndexOf('/');
        dt=Integer.parseInt(s.substring(0,a));
        mn=Integer.parseInt(s.substring(a+1,b));
        yr=Integer.parseInt(s.substring(b+1));
        if(!validate())
            dt=mn=yr=0;
    }

    public DATE(DATE obj)
    {
        this.dt=obj.dt;
        this.mn=obj.mn;
        this.yr=obj.yr;
        if(!validate())
            dt=mn=yr=0;
    }

    public void display()
    {
        System.out.println(dt + " " + mn + " " + yr);
    }

    public String long_form()
    {
        return A[mn] + " " + dt + ", " + yr;
    }

    public boolean validate()
    {
        if((dt>=1 && dt<=31) && (mn==1 || mn==3 || mn==5 || mn==7 || mn==8 || mn==10 || mn==12) && (yr>=1000 && yr<=9999))
            return true;
        else if((dt>=1 && dt<=30) && (mn==4 || mn==6 || mn==9 || mn==11) && (yr>=1000 && yr<=9999))
            return true;
        else if(mn==2)
            if((yr%4==0 && yr%100!=0) || yr%400==0)
                return dt>=1 && dt<=29;
            else
                return dt>=1 && dt<=28;
        else
            return false;
    }

    public boolean leapchk()
    {
        return ((yr%4==0 && yr%100!=0) || yr%400==0);
    }

    public String monthname()
    {
        return A[mn];
    }

    public String dispdate()
    {
        return dt+"/"+mn+"/"+yr;
    }

    public boolean equals(DATE obj)
    {
        return (this.dt==obj.dt && this.mn==obj.mn && this.yr==obj.yr); 
    }

    public int compareTo(DATE obj)
    {
        String s=""+this.yr+this.mn+this.dt;
        String s1=""+obj.yr+obj.mn+obj.dt;
        if(s.compareTo(s1) > 0)
            return 1;
        else if(s.compareTo(s1) < 0)
            return -1;
        return 0;
    }

    public int convert()
    {
        int total=0;int num=0;
        for(num=0;num<yr;num++)
        {
            if(leapchk()==true)
                total++;
        }
        total+=((yr-1)*365);
        for(int x=1;x<mn;x++)
            total=total+days[x];
        total+=(dt-1);
        return total;
    }

    public static int diff(DATE obj, DATE obj1)
    {
        int diff_days= obj1.convert() - obj.convert();
        return diff_days;
    }

    public DATE addDays(int n)
    {
        int d=dt,m=mn,y=yr;
        while(n>days[m])
        {
            n-=days[m];
            m++;
            if(m==2 && y%4==0 && y%100!=0 || y%400==0)
              n-=1;     // subtract 1 more day if it is leap year
            if(m>12)
            {
                m=1;
                y++;
            }
        }//while
        d+=n;  // add the balance to n
        if(d>days[m])
        {
            m++;
            d-=days[m-1];
        }
        DATE tmp = new DATE(d,m,y);
        return tmp;
    }
    
    public DATE subDays(int n)
    {
        int d=dt,m=mn,y=yr;
        while(n>days[m])
        {
            n-=days[m];
            m--;
            if(m==2 && y%4==0 && y%100!=0 || y%400==0)
              n-=1;     // subtract 1 more day if it is leap year
            if(m<1)
            {
                m=12;
                y--;
            }
        }//while
        d-=n;  // add the balance to n
        if(d<1)
        {
            m--;
            d = days[m-1] + d;
        }
        DATE tmp = new DATE(d,m,y);
        return tmp;
    }
}

