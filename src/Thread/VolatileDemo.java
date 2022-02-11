package Thread;

public class VolatileDemo {
/**
 * Beaucoup peuvent s'attendre à ce que ce programme imprime simplement 42
 * après un court délai. Cependant, en réalité, le délai peut être beaucoup
 * plus long. Il peut même se bloquer pour toujours, ou même imprimer zéro !*
 *
 * Caause : La cause de ces anomalies est le manque de visibilité et de
 * réorganisation de la mémoire. Évaluons-les plus en détail.
 *
 */


    private static volatile int number;
    private volatile static boolean ready;

    private static class Reader extends Thread {

        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }

            System.out.println(number);
        }
    }



    public static void main (String...args){

        new Reader().start();
        number = 42;
        ready = true;

    }

}
