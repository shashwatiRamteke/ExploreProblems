package com.dsproblems;

public class SortArrays {

    public static int[] sortArryInPlace(int[] A, int[] B){


        int sizeOfA = 4;
        int sizeOfB = B.length - 1;
        int fillSize = 9;

        while(sizeOfA >= 0 || sizeOfB >= 0){
            if(sizeOfA >= 0 && A[sizeOfA] > B[sizeOfB]){
                A[fillSize] = A[sizeOfA];
                sizeOfA--;
                fillSize--;
            }
            else if(sizeOfB >= 0)
            {
                A[fillSize] = B[sizeOfB];
                sizeOfB--;
                fillSize--;
            }
        }

        return A;
    }
    public static void main(String[] args) {
        int[] A = new int[10];
        int[] B =  {1,2,3,11,17};
        //          5,6,7,8,12

        for(int i=0;i< 5 ; i++)
        {
            A[i] = i+5;
            if(i==2){
                A[i] = 7;
            }
            if(i ==4){
                A[i] = 12;
            }
        }

        A = sortArryInPlace(A,B);
        for(int i=0;i< 10 ;i++){
            System.out.println(A[i]);
        }
    }
}
