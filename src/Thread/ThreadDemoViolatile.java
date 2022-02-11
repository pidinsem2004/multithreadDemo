package Thread;


public class ThreadDemoViolatile extends Thread{

    private volatile Thread t ;

    public void startThread (){
        t = new Thread();
        t.start();
    }

   public void stopThread(){
        t= null;
    }

    @Override
    public void run(){
        System.out.print("We are in the Run method");
        Thread thisThread = Thread.currentThread();
       while  (thisThread == t){
            try {
                System.out.print("We are in the Run method");
                Thread.sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }


    public static void main (String...args){
        ThreadDemoViolatile threadDemoViolatile = new ThreadDemoViolatile();
        threadDemoViolatile.startThread();


    }



}
