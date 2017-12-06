package com.dsproblems.productofthreeintegers;

//Given an array of integers, find the highest product you can get from three of the integers
//The input arrayOfInts will always have at least three integers.

public class ProductOfIntegers {
    public static int findHighestProduct(int[] arrayOfIns){
        int max1= 0;
        int max2 = 0;
        int max3 = 0;
        int maxProfit = 1;
        int maxProfittemp = 1;
        for(int i=0;i<arrayOfIns.length;i++){
            if(max1 < arrayOfIns[i])
                max1 = arrayOfIns[i];
            if(max2 < arrayOfIns[i] && arrayOfIns[i] < max1)
                max2 = arrayOfIns[i];
           if(max2!=arrayOfIns[i])
           {
               maxProfittemp =   max1 * max2 * arrayOfIns[i];
           }
           if(maxProfit < maxProfittemp)
           {
               maxProfit = maxProfittemp;
           }


        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int[] arrayOfInts = {10,2,5,11,15,6,7,18};

        System.out.print(findHighestProduct(arrayOfInts));
    }
}
