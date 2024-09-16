package SyncMultiThreading;

public class SyncIntro2 {
    public static int count=0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->
        {
            for(int i=0;i<5;i++)
            {
                count=count+i;
            }
        }).start();

        new Thread(()->
        {
            for(int i=0;i<115;i++)
            {
                count=count-i;
            }
        }).start();

//        for(int i=0;i<10;i++)
//            System.out.println(i+" "+Thread.currentThread().);
        //Thread.currentThread().sleep();

        System.out.println(count+" "+Thread.currentThread().getName());
    }
}
