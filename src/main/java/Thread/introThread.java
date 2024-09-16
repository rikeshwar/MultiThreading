package oops_practice.Thread;




public class introThread {
    public static void main(String[] args) {

        Thread th=new Thread();//in thread class there is
        //start methos which call run method which is kept
        //emtpy for programmer to define its own process that he wann to ride
        //on thread and run since here we are not define any run method so thread
        //will start and do nothing and terminate

        th.start();//created thread object and start will shift it
        //in thraed pool and os will sedule it on cpu once available

        //this main thread continue to exist with new thraed in threadpool
        //and now its on mercy of os to get cpu
        int a=5;
        System.out.println(a/0);//will say exception
        //in main thread


    }

}
