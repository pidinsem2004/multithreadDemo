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
        long timeToStop = System.currentTimeMillis() + 5000;
        long currentTimemillis = System.currentTimeMillis();

        while (currentTimemillis< timeToStop)
            // you can add condition to the while
              currentTimemillis = System.currentTimeMillis();


    }

}
