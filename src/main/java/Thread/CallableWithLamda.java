package Thread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CallableWithLamda {
    public static void main(String[] args) throws ExecutionException, InterruptedException {


        ExecutorService executorService= Executors.newSingleThreadExecutor();
        Future<Integer> result=executorService.submit(()->3+5);

        System.out.println(3);
        System.out.println(result.isDone());


        for(int i=0;i<5;i++)
            System.out.println(i+" "+Thread.currentThread().getName());
        System.out.println(result.isDone());
        System.out.println(result.get()+" "+Thread.currentThread().getName());
        System.out.println(result.isDone());

        Future<List<Integer>> listFuture=executorService.submit(()->{
            return Stream.of(1,3,4,5,6).filter((x)->x<5).collect(Collectors.toList());
        });
        //Here return is not highlighrtd as its redundant here
        Future<List<Integer>> listFuture2=executorService.submit(()->Stream.of(1,3,4,5,6).filter((x)->x<3).collect(Collectors.toList()));

        executorService.submit(()->Stream.of(1,3,4,5,6).filter((x)->x<3).collect(Collectors.toList()));
        System.out.println(listFuture.isDone());
        for(int i=0;i<5;i++)
            System.out.println(i+" "+Thread.currentThread().getName());
        System.out.println(listFuture.get());
        System.out.println(listFuture2.get());
        System.out.println((executorService.submit(()->Stream.of(1,3,4,5,6).filter((x)->x<10).collect(Collectors.toList()))).get());

        System.out.println((executorService.submit(()->{
            int a=5;
            return Math.sqrt(a);
        })).get());


    }
}
