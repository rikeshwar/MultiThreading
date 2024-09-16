package oops_practice.Thread;


//now we will inherit the Thread class and ovveride run method
class MyThread extends Thread
{
    int a=5;
    int b=7;

    @Override
    public void run()
    {
        System.out.println(a+b+" "+Thread.currentThread().getName());
        //this will print by thread-0 and order is not sure which will print first

    }
}


public class introThread2 {
    public static void main(String[] args) {
        int a=10;
        int b=14;
        MyThread th=new MyThread();
        th.start();
        System.out.println(a+b+" "+Thread.currentThread().getName());
        //this will print by main thread

    }
}
