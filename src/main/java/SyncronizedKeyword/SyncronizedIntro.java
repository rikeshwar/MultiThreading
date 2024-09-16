package SyncronizedKeyword;


public class SyncronizedIntro {
    public static void main(String[] args) throws InterruptedException {
        AdderSubtractor adderSubtractor=new AdderSubtractor();
        Thread t1=new Thread(()->{
            for(int i=0;i<1000;i++)
                adderSubtractor.adder(i);
        });
        Thread t2=new Thread(()->
        {
            for(int i=0;i<1000;i++)
            adderSubtractor.subtracter(i);
        });

        t1.start();
        t2.start();
        Thread.currentThread().sleep(200);
        adderSubtractor.display();
    }
}
