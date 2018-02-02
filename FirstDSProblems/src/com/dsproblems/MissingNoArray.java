package com.dsproblems;


// Array given is 1 <= a[i] <= n

public class MissingNoArray {
    public static void main(String[] args) {
        int[] A = {4,3,2,7,8,2,3,1};
        //output = [5,6]
        int[] B = {-1,-1,-1,-1,-1,-1,-1,-1};

        //Algorithm
        // maxtill now which is less than n
        // 4  once found insert 1 -4 into array
        // keep chekcing elements if elm > max set them to max and insert not existing element into array
        // keep checking element if elm is les than the max and if exist in array remove from output array

        int maxElement = 1;
        for(int i=0;i < A.length;i++){
            if(maxElement < A[i]){
                for(int j=maxElement + 1;j<A[i];j++){
                    if(B[j-1] == -1){
                        B[j-1] = j;
                    }
                }
                maxElement = A[i];

            }else if(A[i] < maxElement ){
                if(B[A[i]-1] == A[i] && B[A[i]-1] != -1){
                    B[A[i]-1] = -1;
                }
            }
        }


        for (int k=0;k<B.length;k++)
        {
            System.out.println(B[k]);
        }
    }
}
