package Thread;

/**
 *
 * A daemon thread is a thread whose execution state is not evaluated when the JVM decides if it should stop or not. The JVM
 stops when all user threads (in contrast to the daemon threads) are terminated. Hence daemon threads can be used to implement
 for example monitoring functionality as the thread is stopped by the JVM as soon as all user threads have stopped:
 *
 *The example application above terminates even though the
 * daemon thread is still running in its endless while loop.
 * */

public class DaemonThreadDemo extends  Thread {

    public DaemonThreadDemo (){
        setDaemon(true);
    }

    @Override
    public void run(){

        while (true)

        {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String...args){
        DaemonThreadDemo daemonThreadDemo = new DaemonThreadDemo();
        daemonThreadDemo.start();

    }

}
