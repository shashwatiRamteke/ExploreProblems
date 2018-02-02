package com.dsproblems;

import java.util.ArrayList;

public class UnderstandRecursizeReturn {

    public static int count;


    public static boolean returnCountofElm(int[] temp ,int i, ArrayList<Integer> tempArray){
        if(i >= temp.length){
            return true ;
        }

        tempArray.add(temp[i]);
        returnCountofElm(temp,i+1,tempArray);
        return true;
    }

    public static void main(String[] args) {
        int[] tempArra = {1,2,3,4,5,6,7,8,9,10};
        count = 0;
        ArrayList<Integer> tempArray = new ArrayList<Integer>();
        boolean end = returnCountofElm(tempArra, 0,tempArray) ;
        System.out.println(tempArray.size());

    }
}
