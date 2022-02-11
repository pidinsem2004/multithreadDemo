package Thread;
/**
 * A user thread cannot be converted into a daemon thread once it has been started.
 * Invoking the method thread.setDaemon(true)
 * on an already running thread instance causes a IllegalThreadStateException.
 * */

public class ThreadConvertDemo extends Thread {


    @Override
    public void run() {

        System.out.println(Thread.currentThread().isDaemon());
    }


    public static void main(String... args) {

        ThreadConvertDemo threadConvertDemo = new ThreadConvertDemo();
        System.out.println(threadConvertDemo.getState());
        threadConvertDemo.start();
        System.out.println(threadConvertDemo.getState());
        threadConvertDemo.setDaemon(true);



    }

}
