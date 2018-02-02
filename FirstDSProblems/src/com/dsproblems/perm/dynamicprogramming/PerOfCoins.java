package com.dsproblems.perm.dynamicprogramming;

import java.util.Arrays;

public class PerOfCoins {

    public static int changePossibilitiesTopDown(int amount, int[] denominations) {
        return changePossibilitiesTopDown(amount, denominations, 0);
    }

    public static  int changePossibilitiesTopDown(int amount, int[] denominations, int currentIndex){

        if(amount < 0 ){
            return 0;
        }

        if(amount == 0){
            return 1;
        }
        if(currentIndex == denominations.length){
            return 0;
        }

        int currentCoin = denominations[currentIndex];

        int numPossibilities = 0;
        while (amount >= 0) {
            numPossibilities += changePossibilitiesTopDown(amount, denominations,
                    currentIndex + 1);
            amount -= currentCoin;
        }

        return numPossibilities;

    }

    public static void main(String[] args) {

        int[] denom = {1,2,3};
        System.out.println(changePossibilitiesTopDown(4,denom ));
    }

}
