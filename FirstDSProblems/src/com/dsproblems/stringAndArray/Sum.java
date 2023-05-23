package com.dsproblems.stringAndArray;

import java.util.ArrayList;
import java.util.HashMap;

public class Sum {

    public static void runningSum(int[] arr){
        int length = arr.length;
        int[] newRunnningArray = new int[length];

        for(int i=0; i< arr.length; i++){
            if(i==0){
                newRunnningArray[i] = arr[i];
            }
            else {
                newRunnningArray[i] = newRunnningArray[i-1] + arr[i];
            }
        }

        for(int i =0; i<newRunnningArray.length;i++){
            System.out.println(newRunnningArray[i]);
        }
   }
   public static void pivotIndex(int[] nums) {
        HashMap<Integer, int[]> newMap = new HashMap<>();
        int leftsum =0,rightsum = 0;
        for(int i=0; i< nums.length;i++)
        {
          leftsum = leftsum + nums[i];
          if(newMap.containsKey(i)){
              int[] arr = newMap.get(i);
              arr[1] = leftsum;
              if(i+1 != nums.length)
                arr[2] = arr[2] + nums[i+1];
              newMap.put(i,arr);
          }else{
              int[] newArr = {leftsum,nums[i+1]};
              newMap.put(i,newArr);
          }
        }
    }

}
