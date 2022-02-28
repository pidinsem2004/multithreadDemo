package Thread;

/**
 *
 * The output of the above code is "false". Although the instance of MyDaemonThread is a daemon thread, the invocation of
 * join() causes the main thread to wait until the execution of the daemon thread has finished. Hence calling isAlive() on
 * the thread instance reveals that the daemon thread is no longer running.
 *
 */

public   class JoinDemo2 extends  Thread  {

    public JoinDemo2(){
        setDaemon(true);
    }

    @Override
    public void run(){
        try {
            while (true) {
                Thread.sleep(500);
                System.out.println("Bonjour");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static  void main (String[] args ){

        try {
        JoinDemo2 joinDemo2 = new JoinDemo2();
        joinDemo2.start();

            joinDemo2.join();
            System.out.println(joinDemo2.isAlive());


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
