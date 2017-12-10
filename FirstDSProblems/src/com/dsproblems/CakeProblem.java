package com.dsproblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static sun.swing.MenuItemLayoutHelper.max;

public class CakeProblem {

    static class CakeType {

        int weight;
        int value;

        public CakeType(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<CakeType> cakeList = new ArrayList<CakeType>();
        CakeType cakeType = new CakeType(1, 30);
        cakeList.add(cakeType);
        cakeType = new CakeType(100, 4000);
        cakeList.add(cakeType);
        cakeType = new CakeType(6, 50);
        cakeList.add(cakeType);
        cakeType = new CakeType(7, 60);
        cakeList.add(cakeType);
        cakeType = new CakeType(2, 20);
        cakeList.add(cakeType);
        cakeType = new CakeType(3, 100);
        cakeList.add(cakeType);


        HashMap<Integer, Integer> cakeMap = new HashMap<Integer, Integer>();
        cakeMap.put(1, 30);
        cakeMap.put(6, 50);
        cakeMap.put(7, 60);
        cakeMap.put(2, 20);
        cakeMap.put(3, 100);


        for (CakeType cakeType1 : cakeList) {
            System.out.println(cakeType1.value + " " + cakeType1.weight);
        }
        CakeType cakeTypeOfmaxValue = new CakeType(0, 0);

        int maxCakeValue = findValue(cakeTypeOfmaxValue, cakeList);

        System.out.println("print max value " + maxCakeValue);

        int maxCakevalue = maxDuffelBagValue(cakeList,100);

        System.out.println(" print max value after real code "+  maxCakeValue);
    }


    public static int findValue(CakeType cakeTypeOfmaxValue, List<CakeType> cakeList) {
        int duffleSize = 100;
        int maxCakeValue = 0;
        for (CakeType cakeType1 : cakeList) {
            if ((Math.abs(duffleSize / cakeType1.weight) * cakeType1.value) > maxCakeValue) {
                maxCakeValue = Math.abs(duffleSize / cakeType1.weight) * cakeType1.value;
                cakeTypeOfmaxValue = cakeType1;
            }
        }
        return maxCakeValue;

    }

//    public static int cakeWeightRec(HashMap<Integer,Integer> cakeMap, int duffleSize){
//      if(duffleSize == 1){
//          return cakeMap.get(1);
//      }
//      if(duffleSize == 0){
//            return 0;
//      }
//      else {
//          int maxValue= 0;
//          for (int i = 0; i < duffleSize; i++) {
//               maxValue = max(cakeWeightRec(cakeMap, duffleSize - 1), cakeWeightRec(cakeMap, duffleSize - 2));
//          }
//          return maxValue;
//      }
//    }


    public static int maxDuffelBagValue(List<CakeType> cakeList, int duffleSize) {
        int[] maxValuesAtCapacities = new int[duffleSize + 1];

        for (int currentCapacity = 0; currentCapacity < duffleSize; currentCapacity++) {
            int currentMasValue = 0;
            for (CakeType cakeType : cakeList) {
                if (cakeType.weight < currentCapacity) {
                    int maxValueUsingThisCake = (int) (cakeType.value + maxValuesAtCapacities[currentCapacity - cakeType.weight]);
                    if (currentMasValue < maxValueUsingThisCake) {
                        currentMasValue = maxValueUsingThisCake;
                    }
                }
            }

        }
        return maxValuesAtCapacities[duffleSize];
    }
}
