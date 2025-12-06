package com.skillnext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String str="markram";
        System.out.println(pal(str));
    }
    static boolean pal(String str)
    {
        int len=str.length()-1,i=0;
        while(i<len)
        {
            if(str.charAt(i)!=str.charAt(len)) return false;
            i++;
            len--;
        }
        return true;
    }
}
