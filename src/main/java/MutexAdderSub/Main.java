package MutexAdderSub;


//when running adder and sub loop same time on completion of all thread
//count=0 seems to be no sync problem but there is a race condition due to shared
//resources and sync problem has very good chance to happen

//if you wann to check go with different loop cycle

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //craete A lock
        Lock lock=new ReentrantLock();//Lock has many implementation here we use one of them
        //update your Adder and Subtractor to inject look object
        Count count=new Count(0);
        Adder adder=new Adder(count,lock);
        Subtractor subtractor=new Subtractor(count,lock);
        //ExecutorService executorService= Executors.newCachedThreadPool();
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        executorService.execute(adder);
        executorService.execute(subtractor);
        //Before await its adviced to shotdown executorServiec
        //which will stop accepting any new task and will completed accepted task
        //and we can't restart same ExecutorService and need to craete new instance if
        //you wish to give new task
        executorService.shutdown();
        boolean finished=executorService.awaitTermination(1, TimeUnit.SECONDS);
        //its observed that if less time given like 1 or 2 sec here then the main thread
        //did nit run line 39-44 but not sure why????

        //Thread.currentThread().sleep(1000);
        for(int i=0;i<10;i++)
            System.out.println(i+" "+Thread.currentThread().getName());
        if(finished)
        System.out.println(count.getValue()+"  "+Thread.currentThread().getName());
        else
            System.out.println("executor still working");
    }
}
