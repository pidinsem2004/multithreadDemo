import Thread.ThreadDemo;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class Main {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {

        List<String> list = Arrays.asList("1","2","3");

        final int val;
        final List<String> stringList ;



        {
            val = 10;
            stringList = new ArrayList<>();


        }




        stringList.add("bonjour");
        stringList.add("toto");
        System.out.println(stringList);

        final Person person ;
        person = new Person();
       // person = new person();





         /* Runnable r1 = () ->{
                           for (int i=0; i<8000; i++)
                          counter++;
              System.out.println(counter + " steps " + Thread.currentThread().getName());
          };

          new Thread(r1).start();

          while (counter<500) {
           System.out.println(Thread.currentThread().getName());
              System.out.println("Not Yet Reached");
              Thread.sleep(1000);
          }
          System.out.println("Reached");
          System.out.println(counter);
    }*/
        ThreadDemo runnableDemo = new ThreadDemo("Thread-1");
        Logger logger = Logger.getLogger("com.api.jar");
        logger.info("Starting the Thread");
        Supplier<String> s = () -> "this message";
        logger.severe(s.get());
        runnableDemo.start();


        /*ThreadDemo runnableDemo2 = new ThreadDemo("Thread-2");
        runnableDemo2.start();*/




    }


}



class Person {
    private String name;
    private int age ;

    final  boolean isValid (){
        return true;
    }

}

/*class Etudiant extends Person{

    @Override
    boolean isValid(){
        return true;
    }

}*/

