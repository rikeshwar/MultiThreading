package Thread;

import java.util.stream.Stream;

public class ThreadSleep {
    //here we will see sleep method od thread

    public static void main(String[] args) {
        Thread t1=new Thread(()-> Stream.of(1,2,3,4,5)
                .forEach(x->{
                    try {
                        Thread.currentThread().sleep(200);//sleep make thread to
                        //sleep for given time and cpu scheduler take away from core
                        //and put it back as per avaibility of core once thread sleep time
                        //over
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(x+" "+Thread.currentThread().getName());
                }));

        t1.start();

        Stream.of(1,2,3,4,5)
                .forEach(x-> {
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(x+" "+Thread.currentThread().getName());

                });

    }
}
