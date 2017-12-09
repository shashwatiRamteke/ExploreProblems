package com.dsproblems.perm.dynamicprogramming;

import java.util.Arrays;

public class permOfCoins {


    public static int changePossibilities(int amount,int[] denom) {
        int[] waysOfDoingNCents = new int[amount + 1];
        waysOfDoingNCents[0] = 1;
        for (int coin : denom) {
            for (int highAmount = coin;highAmount <= amount; highAmount++){
                int higherAmountRem = highAmount - coin;
                waysOfDoingNCents[highAmount] += waysOfDoingNCents[higherAmountRem];
            }
        }
        return waysOfDoingNCents[amount];
    }

    public static int noOfPos(int amount, int[] denom){
        for(int denom1 : denom) {
            int count = countOfdenomToReachamouont(denom1,amount);
            for(int i=1;i <count-1;i++){
                noOfPos(amount - i*denom1, Arrays.copyOfRange(denom,i,denom.length));
            }

        }
        return 1;
    }

    public static int countOfdenomToReachamouont(int denom1, int amount){
        int count = 0;
        int no =0;
        while(count >= amount){
            count = count + denom1;
            no++;
        }

        return 1;
    }

    public static void main(String[] args) {
        int amount = 4;
        int[] denom = {1,2,3};
        System.out.print(changePossibilities(amount,denom));
    }
}
