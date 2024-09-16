package oops_practice.Thread;

//callable is the altername of Runnable where it can return any generic
//and will be usefull if we wann tHread to execute the task and return the value

//Since we are not sure if Thread will return output now or later or when

//java provide Future<> container and let main Thread or calling Thread continue its task

import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

class Mycallable implements Callable<List<Double>> {
    List<Double> list=List.of(2.0,4.0,6d,11d,88d,45d);
    @Override
    public List<Double> call() throws Exception {
        List<Double> returnValue=list.stream().map(x->(Math.sqrt(x))).collect(Collectors.toList());
        return returnValue;
    }

}



public class CallableIntro {
    public static void main(String[] args) throws Exception {

        ExecutorService executorService= Executors.newFixedThreadPool(5);

        Future<List<Double>> future=executorService.submit(new Mycallable());

        //executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(future.isDone());//will not blo

        for(int i=0;i<1;i++) {//keeping i<2 is enough time for executor to finish task
            if(future.isDone())
                future.get().forEach(x-> System.out.println(x+" "+Thread.currentThread().getName()));
            System.out.println(i + " " + Thread.currentThread().getName());
        }

        //System.out.println(future.isDone());


        executorService.shutdown();


    }
}
