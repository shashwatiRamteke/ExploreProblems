package com.dsproblems;

import java.util.ArrayList;

public class NumOfPathsToXY {

    public static int numOfPathsToXY(int x,int y, int n){
        if(x == n && y ==n){
            return 1;
        }
       if(x > y)
       {
           return 0;
       }
       int count1 = 0;
        int count2 = 0;
       if(y < n){
            System.out.println("prinitng x & y " + x + " " +  y);
              count1 = numOfPathsToXY(x,y +1,n);

       }
       if(x <= y){
           System.out.println("prinitng x & y " + x + " " +  y);
           count2 = numOfPathsToXY(x +1,y,n );
       }

        return count1 + count2;
    }

    static class Point{
        int x;
        int y;
        public Point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean numOfPathsWithArray(int x , int y, int n, ArrayList<Point> path){

        if(x > n || y > n || x > y){
            return false;
        }
        boolean isAtFinal = x==n && y ==n;
        boolean incX = numOfPathsWithArray(x,y+1,n,path);
        boolean incy = false;
        if(x <= y){
            incy = numOfPathsWithArray(x+1,y,n,path);
        }
        if(isAtFinal ||  incX || incy)
        {
            Point newPoint = new Point(x,y);
            path.add(newPoint);
            return true;

        }
        return false;
    }

    public static int numOfPAthsToN(int n){
       int finalCount = numOfPathsToXY(0,0,n);
       return finalCount;
      // ArrayList temppath = new ArrayList<Point>();
       //boolean finalBoolean = numOfPathsWithArray(0,0,n,temppath);
     //  return temppath.size();
    }

    public static void main(String[] args) {
        System.out.println("priniting final count " + numOfPAthsToN(4));
    }
}
