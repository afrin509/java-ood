package com.company;

import java.util.Scanner;

class MyThread1 extends Thread
{
    @Override
    public void run()
    {
        while(true)
        {
            System.out.println("thread 1 is running ...");
        }
    }
}
class MyThread2 extends Thread
{
    public void run()
    {
        while(true)
        {
            System.out.println("thread 2 is running ...");
        }
    }
}
class CustomError extends Exception
{
    @Override
    public String getMessage(){
//        System.out.println("I am exception message");

         return "I am exception message";
       }

}
class customRuntimeError extends RuntimeException
{
    @Override
    public String getMessage(){
//        System.out.println("I am exception message");

        return "I am run time exception message";
    }
}
public class Mthreading {
    public static void main(String args[])
    {
//        MyThread1 t1=new MyThread1();
//        MyThread2 t2=new MyThread2();
//
//        t1.start();
//        t2.start();
 Scanner sc=new Scanner(System.in);
  int a;
  a=sc.nextInt();
    if(a<4)
    {
         try{
             try {
                 throw new CustomError();
             }
             catch (RuntimeException r)
             {

                 System.out.println(r.getMessage());
                 System.out.println("inside catch of runtime exception block at inside");
             }

             catch (Exception e) {
             System.out.println(e.getMessage());
             System.out.println("inside catch of generic exception  inside");
         }

         }
         catch (RuntimeException r)
         {

             System.out.println(r.getMessage());
             System.out.println("inside catch of runtime exception block outside");
         }
         catch (Exception e) {
             System.out.println(e.getMessage());
             System.out.println("inside catch of generic exception block");
         }
         int i=0;
   while(i<4)
   {
       System.out.println("value of i"+ ++i);
   }

    }
        System.out.println("code got finished successfully");
    }
}
