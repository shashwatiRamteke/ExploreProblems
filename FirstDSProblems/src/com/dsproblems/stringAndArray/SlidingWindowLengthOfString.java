package com.dsproblems.stringAndArray;

import java.util.HashSet;

public class SlidingWindowLengthOfString {
    //Input: s = "abcefnhekjfjkerte;erjgtkojorjyo45yjo425ytjojtwrkldjfdjfjdfdjfhdjfjfhjdjfhjdfhjdhfjdhfjdhfdhfdjhgjrgjrtgjrgjfhgjkhfdjkghfjdkghjkfhk"
    // abcdbb" "cbb"
    //Output: 3
    //Explanation: The answer is "abc", with the length of 3.
    // SLidingWindowExample
    public static int lengthOfLongestSubstring(String s) {
        char[] charArray = s.toCharArray();
        String CurrlongestString = "";
        String finalLongestString = "";
        int longestlength = 0;
        int Currlongestlength = 0;
        int startofslidingwindow = 0;
        int endofslidingwindow = 0;
        HashSet<Character> setofchar = new HashSet<Character>();

        for(int i=0;i< s.length();i++){

            if(setofchar.contains(charArray[i])){
                if(Currlongestlength > longestlength)
                {
                    finalLongestString = CurrlongestString;
                    longestlength = Currlongestlength;
                }
                CurrlongestString = "";
                Currlongestlength = 0;
                endofslidingwindow = i;
                while(startofslidingwindow < endofslidingwindow){
                    if(setofchar.contains(charArray[startofslidingwindow])){
                        setofchar.remove(charArray[startofslidingwindow]);
                    }
                    startofslidingwindow++;
                }

                startofslidingwindow = i;
            }
            setofchar.add(charArray[i]);
            CurrlongestString = CurrlongestString + charArray[i];
            Currlongestlength++;
        }
        if(Currlongestlength > longestlength)
        {
            longestlength = Currlongestlength;
        }
        return longestlength;
    }
}
