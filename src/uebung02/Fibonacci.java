package uebung02;
import static gdi.MakeItSimple.*;

public class Fibonacci 
{
    static int aufrufe1 = 0;
    static int aufrufe2 = 0;
    
    public static void main(String[] args) 
    {
        println(fib1(5) + " Aufrufe: " + aufrufe1);
        println(fib2(5) + " Aufrufe: " + aufrufe2);   
    }    
    
    public static int fib1(int n)
    {
        aufrufe1++;
        
        if (n == 0 || n == 1)
        {
            return 1;
        }
        else
        {
            println("fib1("+(n-1)+") + fib1("+(n-2)+")");
            return fib1(n-1)+fib1(n-2);
        }
    }
    
    public static int fib2(int n)
    {
        return h(n, 1, 1);
    }
    
    public static int h(int n, int a, int b)
    {
        aufrufe2++;
        
        if (n == 0)
        {
            return a;
        }
        else
        {
            return h(n-1, b, a + b);
        }
    }
    
}

