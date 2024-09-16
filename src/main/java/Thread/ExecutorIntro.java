package Thread;


import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

//create Thread and managing it byourself is many time not efficient as control also envolve
//Os cpu so to use Thread multiple time we have abstracted environment of Executor class
public class ExecutorIntro {
    public static void main(String[] args) {
        Runnable numberPrinter=()->{
            for(int i=0;i<10;i++)
            {
                System.out.println(i +" "+Thread.currentThread().getName());
            }
        };
        Executor executor= Executors.newSingleThreadExecutor();
        executor.execute(numberPrinter);//executor interface has method execute take
        //runnable but if you wann more option use its extended interface Ececutor Service


        numberPrinter.run();
        Runnable taskMain=()->{
            Stream.of(2,5,1,8,9).map((x)->x+5).filter(x->x>9).forEach(System.out::println);
        };
        taskMain.run();

    }
}
