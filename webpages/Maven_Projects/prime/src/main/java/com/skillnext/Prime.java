package com.skillnext;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class Prime
{
    public static void main( String[] args )
    {
        int n=5;
        prime(n);
    }
    static void prime(int n)
    {
        boolean[] arr=new boolean[n+1];
        Arrays.fill(arr, true);
        arr[0]=false;
        arr[1]=false;
        for (int p=2;p*p<=n;p++)
        {
            if (arr[p])
            {
                for (int j=p*p;j<=n;j+=p) arr[j]=false;
            }
        }
        for(int i=2;i<arr.length;i++) if(arr[i]) System.out.print(i+" ");
        
    }
}