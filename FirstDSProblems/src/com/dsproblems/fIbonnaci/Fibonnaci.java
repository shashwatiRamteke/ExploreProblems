package com.dsproblems.fIbonnaci;

import java.util.Scanner;

public class Fibonnaci {

    public static int calcualteFibRecursive(int n){
        if(n == 0)
            return 0;
        if(n == 1 || n ==2)
            return 1;

        return calcualteFibRecursive(n-2) + calcualteFibRecursive(n-1);
    }

    public static int calcualteFibIterative(int n)
    {
        int fibNthValue = 0;
        int prev1Value = 0;
        int prev2Value = 1;

        for(int i =1; i < n ; i++){
                fibNthValue = prev1Value + prev2Value;
                prev1Value = prev2Value;
                prev2Value = fibNthValue;

        }
        return  fibNthValue;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(calcualteFibRecursive(n));
        System.out.println(calcualteFibIterative(n));
    }
}
