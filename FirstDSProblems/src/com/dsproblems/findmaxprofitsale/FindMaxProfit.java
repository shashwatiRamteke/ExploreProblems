package com.dsproblems.findmaxprofitsale;
//Suppose we could access yesterday's stock prices as an array, where:
//The indices are the time in minutes past trade opening time, which was 9:30am local time
//he values are the price in dollars of Apple stock at that time.
//So if the stock cost $500 at 10:30am, stockPricesYesterday[60] = 500.
//Write an efficient method that takes stockPricesYesterday and returns the best profit
//I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.

//Algorithm
//A greedy algorithm iterates through the problem space taking the optimal solution "so far," until it reaches the end.
//The greedy approach is only optimal if the problem has "optimal substructure,"
//which means stitching together optimal solutions to subproblems yields an optimal solution.

//for every price, we’ll need to:
//keep track of the lowest price we’ve seen so far
//see if we can get a better profit

public class FindMaxProfit {

    public static int getMaxProfit(int[] stockPrices)
    {

        int minPrice = stockPrices[0];
        int maxPrice = stockPrices[0];
        int maxProfitTillNow = 0;
        for(int i=0;i < stockPrices.length;i++)
        {
            if(minPrice > stockPrices[i]) {
                int tempProfit = maxPrice - minPrice;
                if(tempProfit >= maxProfitTillNow){
                    maxProfitTillNow = tempProfit;
                }
                minPrice = stockPrices[i];
                maxPrice = stockPrices[i];
            }
            if(maxPrice < stockPrices[i]) {
                maxPrice = stockPrices[i];
                int tempProfit = maxPrice - minPrice;
                if(tempProfit >= maxProfitTillNow){
                    maxProfitTillNow = tempProfit;
                }
            }
        }
        return maxProfitTillNow;
    }

    public static void main(String[] args) {
        int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
        System.out.print("Max profti till now " + getMaxProfit(stockPricesYesterday));
    }


}
