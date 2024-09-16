package AdderNSubtractor;


//when running adder and sub loop same time on completion of all thread
//count=0 seems to be no sync problem but there is a race condition due to shared
//resources and sync problem has very good chance to happen

//if you wann to check go with different loop cycle

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count=new Count(0);
        Adder adder=new Adder(count);
        Subtractor subtractor=new Subtractor(count);
        //Thread t1=new Thread(adder);
        //Thread t2=new Thread(subtractor);
//        t1.start();
//        t2.start();
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.execute(adder);
        executorService.execute(subtractor);
        //Before await its adviced to shotdown executorServiec
        //which will stop accepting any new task and will completed accepted task
        //and we can't restart same ExecutorService and need to craete new instance if
        //you wish to give new task
        executorService.shutdown();
        executorService.awaitTermination(2, TimeUnit.SECONDS);

        //Thread.currentThread().sleep(1000);
//        for(int i=0;i<10;i++)
//            System.out.println(i+" "+Thread.currentThread().getName());
        System.out.println(count.getValue());
    }
}
