package Thread;

/*
*
* Busy waiting means implementations that wait for an event by performing some active computations that let the thread/process
occupy the processor although it could be removed from it by the scheduler. An example for busy waiting would be to spend the
waiting time within a loop that determines the current time again and again until a certain point in time is reached:
*
* */
public class BusyWaitingDemo extends  Thread  {


    @Override
    public void run(){
        long timeOut = System.currentTimeMillis() + 5000;
        long currentTimeMillis = System.currentTimeMillis();

        while (currentTimeMillis< timeOut) {
            // you can add condition to the while
            currentTimeMillis = System.currentTimeMillis();
            System.out.println("...Still waiting");
        }
        System.out.println("It's time now");
    }

    public static void main(String[]args){
        BusyWaitingDemo busyWaitingDemo = new BusyWaitingDemo();
        busyWaitingDemo.start();

    }

}
