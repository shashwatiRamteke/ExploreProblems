package com.dsproblems.stringAndArray;

public class PermutationString {
    public static boolean permutationOfEachOther(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        return sort(str1).equals(sort(str2));

    }

    static String sort(String str){
        char[] content = str.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }
}
