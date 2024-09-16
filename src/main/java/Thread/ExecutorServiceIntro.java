package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

//Executor service provide more functionality and its extending the Excecutor interface


public class ExecutorServiceIntro {
    public static void main(String[] args) {
        Runnable task=()->{
            List<Integer> list=new ArrayList<>(List.of(23,65,78,11,33,99));
            list.stream().map(x->x+10).forEach((x)-> System.out.println(x+" "+Thread.currentThread().getName()));
        };

        //Executor executor = Executors.newCachedThreadPool();
        ExecutorService executorService=Executors.newCachedThreadPool();

        ExecutorService executorService1=Executors.newFixedThreadPool(5);

        executorService.execute(task);//similar to Thread.start()

        executorService1.execute(task);

        executorService.shutdown();//not using this will not finish process
        executorService1.shutdown();

        Stream.iterate(0,x->x+1).limit(1000)
                .forEach((x)-> System.out.println(x+" "+Thread.currentThread().getName()));




    }
}
