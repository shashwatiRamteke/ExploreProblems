package com.dsproblems;

import java.util.HashSet;
import java.util.Scanner;

import static com.dsproblems.PermutationOfString.permute;

public class PermutationOfString {

    public static HashSet<String> permute(String str)
    {
        if(str.length() == 0){
            return null;
        }
        if(str.length() == 1)
        {
            HashSet<String> permutsOfStringWoLastChar = new HashSet<>();
            permutsOfStringWoLastChar.add(str);
            return permutsOfStringWoLastChar;
        }
        else
        {
            String strWOlastChar = str.substring(0,str.length() -1);
            String lastChar = str.substring(str.length()-1,str.length());
            HashSet<String> permutsOfStringWoLastChar  = permute(strWOlastChar);
            HashSet<String> finalStrings = new HashSet<>();
            for(String permOfStringWOLastChar : permutsOfStringWoLastChar){
                for(int i=0; i<=permOfStringWOLastChar.length();i++){
                    String startOfStr = permOfStringWOLastChar.substring(0,i);
                    String endOfStr = permOfStringWOLastChar.substring(i,permOfStringWOLastChar.length());
                    String addedPerm = startOfStr + lastChar + endOfStr;
                    finalStrings.add(addedPerm);
                }
            }
            return finalStrings;

        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        int size = str.length() -1 ;
        HashSet permuteSetOfString = permute(str);
        final int[] count = {0};
        permuteSetOfString.forEach(str1-> {System.out.println(str1);
        count[0]++;});
        System.out.println(count[0]);
    }
}
