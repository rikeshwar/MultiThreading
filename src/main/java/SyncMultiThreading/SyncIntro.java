package oops_practice.SyncMultiThreading;

//when multiple Thread try to work on shared resources could end up in some trouble



public class SyncIntro {
    public static int count=0;

    public static void main(String[] args) {



         Thread t1=new Thread(()->count=count+1);
         Thread t2=new Thread(()->count=count-1);
         t1.start();
         t2.start();

        System.out.println("ndkhui");
        System.out.println(count+" "+Thread.currentThread().getName());
        System.out.println(count+" "+Thread.currentThread().getName());
        System.out.println(count+" "+Thread.currentThread().getName());




    }

}
