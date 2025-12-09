package com.skillnext;

/**
 * Hello world!
 *
 */
public class Reverse
{
    public static void main( String[] args )
    {
        int n=1234;
        System.out.println(reverse(n));
    }
    public static int reverse(int n)
    {

        int a=0;
        while(n>0)
        {
            a=(a*10)+(n%10);
            n/=10;
        }
        return a;
    }
}
