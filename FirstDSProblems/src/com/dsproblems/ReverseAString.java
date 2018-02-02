package com.dsproblems;

public class ReverseAString {

    public static String reverseAsString(String[] words, int i){
        if(i == words.length){
            return "";
        }
        return reverseAsString(words,i+1) + " " + words[i]  ;
    }

    public static String reverseAsString(String[] words, int i, String newString){
        if(i == words.length){
            return "";
        }
        newString += reverseAsString(words,i+1, newString) + " " +  words[i];
        return newString;
    }

    public static void main(String[] args) {
        String str = "I am trying to reverse a string";
        String[] words = str.split(" ");
        System.out.println(reverseAsString(words,0,""));
    }
}
