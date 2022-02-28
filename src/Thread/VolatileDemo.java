package Thread;

public class VolatileDemo {
/*
 * Beaucoup peuvent s'attendre à ce que ce programme imprime simplement 42
 * après un court délai. Cependant, en réalité, le délai peut être beaucoup
 * plus long. Il peut même se bloquer pour toujours, ou même imprimer zéro !*
 *
 * Cause : La cause de ces anomalies est le manque de visibilité et de
 * réorganisation de la mémoire. Évaluons-les plus en détail.
 *
 */


    private static volatile int number =10;
    private volatile static boolean ready;

    private static class ReaderThread extends Thread {

        @Override
        public void run() {
            while (!ready) {
                System.out.println("dans le run....");
                Thread.yield();
            }

            System.out.println(number);
        }
    }



    public static void main (String...args){

        System.out.println("Initial value of number = " + number);

        new ReaderThread().start();

        number = 42;
        ready = true;

    }

}
