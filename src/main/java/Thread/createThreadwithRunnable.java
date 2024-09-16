package Thread;

//here we intead onherit Thread class which is implementing runnable
//interface with contract of method run


//we will use our own class to implement runnable interface
//and define run method and craete Thread with contructor which take run method
//as parameter

class customRun implements Runnable
{

    @Override
    public void run() {
        for(int i=0;i<5;i++)
            System.out.println(i+" "+Thread.currentThread().getName());
    }
}

public class createThreadwithRunnable {
    public static void main(String[] args) {
        customRun run=new customRun();
        Thread th=new Thread(run);//so here we craeted thread with cour run method
        //still this could be betther as runnable is functioanl interface so
        //we can use lamda
        th.start();
        for(int i=0;i<5;i++)
            System.out.println(i+" "+Thread.currentThread().getName());

    }

}
