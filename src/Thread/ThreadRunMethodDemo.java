package Thread;
/**
 * As can be seen in line two of the main() method, we invoke
 * by mistake the method run() instead of start(). Hence, no new
 * thread is started, but the method run() gets executed
 * within the main thread.
 *
 */

public class ThreadRunMethodDemo extends  Thread {

    public ThreadRunMethodDemo (String threadName){
        super(threadName);
    }

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }


    public static void main (String...args){
        ThreadRunMethodDemo threadRunMethodDemo  = new ThreadRunMethodDemo("Thread 1");
        threadRunMethodDemo.run();
        threadRunMethodDemo.start();

    }

}
