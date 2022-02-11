package Thread;
/**
 * The method interrupt() of java.lang.Thread interrupts a sleeping thread.
 * The interrupted thread that has been put to
 sleep by calling Thread.sleep() is woken up by an InterruptedException:
 *
 * */

public class InterrupMethodDemo implements  Runnable {

    public InterrupMethodDemo (){
        super();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch (InterruptedException e) {
            System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
        }
    }


    public static void main(String...args){

        Thread interrupMethodDemo = new Thread(new InterrupMethodDemo());
        interrupMethodDemo.start();
        System.out.println("Thread " + Thread.currentThread().getName()+" sleeping in the Main branch");
        try {
            Thread.sleep(5000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println( "Thread "  +interrupMethodDemo.getName() + " interruption");
        interrupMethodDemo.interrupt();
    }



}
