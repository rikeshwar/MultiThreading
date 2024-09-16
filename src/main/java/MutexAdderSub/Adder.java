package MutexAdderSub;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{
    private Lock lock;
   private Count count;

    public Adder(Count count,Lock lock) {
        this.count = count;
        this.lock=lock;
    }

    @Override
    public void run() {
        //taking lock here is not adviced and one lock aquired here thread will get
        //lock for entire iteration and will jeopardized the multithreading
        for(int i=0;i<1000000;i++)
        {
            lock.lock();//now syncronization is gurranted as only one Thred is allowed
            //to enter in critical region
            int changedValue=count.getValue()+i;
            count.setValue(changedValue);
            //System.out.println(changedValue+ "  "+Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
