package oops_practice.Thread;


class Mythread2 extends Thread
{

    public void run()//this is long process of inherit Thread class
            //and oveeride the run method
    {
        for(int i=0;i<10;i++)
            System.out.println(i+" "+Thread.currentThread().getName());
    }

}

public class IntroThread3 {
    public static void main(String[] args) {
        Mythread2 th=new Mythread2();
        th.start();
        for(int i=0;i<10;i++)
            System.out.println(i+" "+Thread.currentThread().getName());

    }
}
