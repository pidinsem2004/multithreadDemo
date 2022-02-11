package Thread;
import java.util.logging.Logger;
public class ThreadDemo {

   private Thread t ;
   private String threadName ;
   private Runnable runnable;




   public ThreadDemo(String threadName) {
        this.threadName = threadName;
        this.setRunnable();
        System.out.println("creating Thread " + threadName);


   }

    public void start () {
     System.out.println("Starting " +  getThreadName() );
        if (t == null) {
            t = new Thread (getRunnable());
            t.start ();
            System.out.println("Thread group is " + t.getThreadGroup());
        }
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable() {
        runnable = () ->{
            System.out.println("Running Thread " + getThreadName());
            for(int i = 10; i>0; i--){
                System.out.println("Thread " + getThreadName() +", "+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Thread " +  threadName + " exiting.");
        };

    }

    public Thread getT() {
        return t;
    }

    public void setT(Thread t) {
        this.t = t;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }




}
