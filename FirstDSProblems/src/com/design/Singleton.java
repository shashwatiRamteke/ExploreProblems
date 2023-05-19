package com.design;

class SingletonClass {

    private static SingletonClass single_instance;

    public static String s;
    // Constructor
    // Here we will be creating private constructor
    // restricted to this class itself
    private SingletonClass()
    {
        s = "Hello I am a string part of Singleton class";
    }
    public static SingletonClass gt_instance(){
        if(single_instance == null){
            single_instance = new SingletonClass();
            return single_instance;
        }
        else
        {
            return single_instance;
        }
    }
}

public class Singleton{
    public static void main(String args[])
    {
        // Instantiating Singleton class with variable x
        SingletonClass x = SingletonClass.gt_instance();

        // Instantiating Singleton class with variable y
        SingletonClass y = SingletonClass.gt_instance();

        // Instantiating Singleton class with variable z
        SingletonClass z = SingletonClass.gt_instance();

        // Printing the hash code for above variable as
        // declared
        System.out.println("Hashcode of x is "
                + x.hashCode());
        System.out.println("Hashcode of y is "
                + y.hashCode());
        System.out.println("Hashcode of z is "
                + z.hashCode());

        // Condition check
        if (x == y && y == z) {

            // Print statement
            System.out.println(
                    "Three objects point to the same memory location on the heap i.e, to the same object");
        }

        else {
            // Print statement
            System.out.println(
                    "Three objects DO NOT point to the same memory location on the heap");
        }
    }
}
