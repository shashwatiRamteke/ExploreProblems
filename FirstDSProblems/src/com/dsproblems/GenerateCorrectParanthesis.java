package com.dsproblems;

import java.util.ArrayList;
import java.util.Scanner;

public class GenerateCorrectParanthesis {

    public static void addParen(ArrayList<String> list, int leftParm, int rightParm, char[] str, int count){
        if(leftParm == 0 && rightParm ==0){
            String s = String.copyValueOf(str);
            list.add(s);
            return;
        }
        if(leftParm > 0){
            str[count] = '(';
            addParen(list,leftParm -1 , rightParm, str, count + 1);
        }
        if(rightParm > leftParm){
            str[count] = ')';
            addParen(list, leftParm,rightParm -1, str,count + 1);
        }
    }

    public static ArrayList<String> generateParen(int count){
        char[] str = new char[count*2];
        ArrayList<String> list = new ArrayList<String>();
        addParen(list,count,count,str,0);
        return list;
    }

    public static void main(String[] args) {
        System.out.println("Enter the no of parn check");
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        ArrayList<String> list = generateParen(count);
    }

}
