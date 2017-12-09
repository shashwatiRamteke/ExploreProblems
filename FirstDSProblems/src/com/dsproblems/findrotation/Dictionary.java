package com.dsproblems.findrotation;

import java.util.Scanner;

//Find rotation in given set or words
//  String[] words = new String[]{
//          "ptolemaic",
//          "retrograde",
//          "supplant",
//          "undulate",
//          "xenoepist",
//          "asymptote",  // <-- rotates here!
//          "babka",
//          "banoffee",
//          "engender",
//          "karpatka",
//          "othellolagkage",
//          };

public class Dictionary {

    public static String findRotation(String[] words){
        char firstLetterOfWord = words[0].charAt(0);
        int floor = 0;
        int ceiliing = words.length;
        while(floor < ceiliing){
            firstLetterOfWord = words[floor].charAt(0);
            int midIndex = (floor + ceiliing)/2;
            if(firstLetterOfWord > words[midIndex].charAt(0)){
                ceiliing = midIndex;
            }else{
                floor = midIndex;
            }

            if(floor + 1 == ceiliing){
                break;
            }

        }
        return words[ceiliing];
    }
    public static void main(String[] args) {
        String[] words = new String[5];

        Scanner in = new Scanner(System.in);
        int i =0;
        while(i < 5){
            words[i] = in.next();
            i++;
        }

        System.out.println(findRotation(words));

    }
}
