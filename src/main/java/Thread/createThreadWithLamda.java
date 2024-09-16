package Thread;

import java.util.stream.Stream;

public class createThreadWithLamda {
    public static void main(String[] args) {

        Thread th=new Thread(()->{
            for(int i=0;i<5;i++)
                System.out.println(i+" "+Thread.currentThread().getName());
        });

        //this is as of now best way ti craete thread and pass the method to be ride
        //and run on thread through lamda expreassion
        Thread th2=new Thread(()->
                Stream.of(1,2,3,4,5).forEach(x-> System.out.println(x+" "+Thread.currentThread().getName())));

        th.start();
        th2.start();

        //can also define runnable task lamda expression and pass on to new Thread class
        Runnable task=()->
                Stream.of(1,2,3,4,5).forEach(x-> System.out.println(x+" "+Thread.currentThread().getName()));
        Thread th3 =new Thread(task);
        th3.start();


        for(int i=0;i<5;i++)
            System.out.println(i+" "+Thread.currentThread().getName());





        //usless different thread are not working on any shared data
        //its work amazing to devide work into smaller chunk of process
        //and pass on to corresponding thread and so we coude use our cpu
        //processing power in most efficient way



    }
}
