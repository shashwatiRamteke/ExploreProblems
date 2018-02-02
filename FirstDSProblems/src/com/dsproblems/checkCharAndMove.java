package com.dsproblems;

import java.util.ArrayList;
import java.util.List;


public class checkCharAndMove {

    public static void iterateLang(ArrayList<String> listLang,int i, int j, int k, String direction) {
        if (listLang.get(i).charAt(j) == '@') {
            return;
        }
        if (listLang.get(i).charAt(j) == '<') {
            direction = "left";
            j = j--;
            iterateLang(listLang, i, j, k, direction);
        }
        if (listLang.get(i).charAt(j) == '>') {
            direction = "right";
            j = j++;
            iterateLang(listLang, i, j, k, direction);
        }
        if (listLang.get(i).charAt(j) == '^') {
            if (i > 0) {
                i = i--;
                iterateLang(listLang, i, j, k,direction);
            }
        }
        if (listLang.get(i).charAt(j) == 'v') {
            i = i++;
            iterateLang(listLang, i, j, k,direction);
        }
        if (listLang.get(i).charAt(j) == ',') {
            System.out.print(listLang.get(i).charAt(j - 1));
            int tempj = j;
            if (direction.equals("right")){
                tempj++;
            } else if (direction.equals("left")) {
                tempj--;
            }
            iterateLang(listLang, i, tempj, k,direction);
        }
        if (listLang.get(i).charAt(j) > 0 && listLang.get(i).charAt(j) < 9) {
            int n = Character.getNumericValue(listLang.get(i).charAt(j));
            for (int k1 = k; k1 < n; k1++) {
                int tempj = j;
                if (direction.equals("right"))
                    tempj++;
                else if (direction.equals("left"))
                {
                    tempj--;
                }
                iterateLang(listLang, i, tempj, k1,direction);
            }
        } else if(!(listLang.get(i).charAt(j) > 0 && listLang.get(i).charAt(j) < 9) && listLang.get(i).charAt(j) != ',' &&  listLang.get(i).charAt(j) != '<' && listLang.get(i).charAt(j) != '>' && listLang.get(i).charAt(j) != '^' && listLang.get(i).charAt(j) != 'v' && listLang.get(i).charAt(j) != '@' ){
            //if (k == 0) {
                if (j == listLang.get(i).length() - 1) {
                    i++;
                    j = 0;
                } else {
                    if (direction.equals("right"))
                        j++;
                    else if (direction.equals("left"))
                    {
                        j--;
                    }
                }
                iterateLang(listLang, i, j, k,direction);

        }
    }




    public static void main(String[] args) {
        ArrayList<String> listLang = new ArrayList<String>();
        listLang.add("H,e,l,l,o, W,o,r,l,d,!");
        listLang.add("Hello World,9@");

        //listLang.add("Hello World!");

        iterateLang(listLang,0,0,0,"right");

    }


}
