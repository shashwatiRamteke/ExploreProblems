package com.dsproblems.stringAndArray;

import java.util.HashMap;
import java.util.HashSet;

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

    //Input: s = "abcabcbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.
    public static int lengthOfSubstring(String s) {
        char[] charArray = s.toCharArray();
        int longestlength = 0;
        String CurrlongestString = "";
        String finalLongestString = "";
        int Currlongestlength = 0;
        HashMap<String,Integer> setofchar = new HashMap<String,Integer>();
        for(int i=0; i< charArray.length;i++) {


            if (setofchar.containsKey(CurrlongestString))
            {
                if(i+1 < charArray.length && !setofchar.containsKey(CurrlongestString + charArray[i+1])) {
                    CurrlongestString = "";
                    Currlongestlength = 0;
                }
            }
            else
            {
                setofchar.put(CurrlongestString,Currlongestlength);
            }

            if (Currlongestlength > longestlength) {
                finalLongestString = CurrlongestString;
                longestlength = Currlongestlength;
            }
        }
        return longestlength;
    }


}
