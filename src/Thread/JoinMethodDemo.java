package Thread;

class Printer {

    // instead of putting the calling the join method in each created thread,
    // just mark your method as synchronized
    // synchronized
    public void printDocument(String documentName, int nbOfPages) {

        for (int i = 1; i <= nbOfPages; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Printing " + documentName + " page " + i);
        }
    }

}

//GM Printer Thread
class GMPrinterThread extends Thread {
    private Printer pRef;

    public GMPrinterThread(Printer pRef, String threadName) {
        super(threadName);
        this.pRef = pRef;
    }


    @Override
    public void run() {
        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Started ====");


        // instead on synchronizing our print method, we can just synchronize the
        // critical section : block where the printer object is shared amount the thread
        synchronized (pRef) {
            pRef.printDocument("GM.pdf", 5);
        }
        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Stopped ====");

    }
}

//Deputy GM printer Thread
class DGMPrinterThread extends Thread {
    Printer pRef;

    public DGMPrinterThread(Printer pRef, String threadName) {
        super(threadName);
        this.pRef = pRef;
    }

    @Override
    public void run() {

        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Started ====");

        // instead on synchronizing our print method, we can just synchronize the
        // critical section : block where the printer object is shared amount the thread
        synchronized (pRef) {
            pRef.printDocument("DGM.pdf", 5);
        }
        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Stopped ====");


    }
}

//HR PrinterThread
class HRPrinterThread implements Runnable {
    Printer pRef;

    public HRPrinterThread(Printer pRef) {
        this.pRef = pRef;
    }

    @Override
    public void run() {
        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Started ====");

        // instead on synchronizing our print method, we can just synchronize the
        // critical section : block where the printer object is shared amount the thread
        synchronized (pRef) {
            pRef.printDocument("hrDocument.pdf", 5);
        }
        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Stopped ====");

    }

}

//IT PrinterThread
class ITPrinterThread implements Runnable {
    Printer pRef;

    public ITPrinterThread(Printer pRef) {
        this.pRef = pRef;
    }

    @Override
    public void run() {
        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Started ====");

        // instead on synchronizing our print method, we can just synchronize the
        // critical section : block where the printer object is shared amount the thread
        synchronized (pRef) {
            pRef.printDocument("ITDocument.pdf", 5);
        }

        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Stopped ====");

    }

}


public class JoinMethodDemo {

    public static void main(String... args) {


        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Started ====");

        Printer printer = new Printer();
        //printer.printDocument("Java", 30);

        GMPrinterThread gmPrinterThread = new GMPrinterThread(printer, "gm");
        Thread hrPrinterThread = new Thread(new HRPrinterThread(printer), "hr");
        DGMPrinterThread dgmPrinterThread = new DGMPrinterThread(printer, "dgm");
        Thread itPrinterThread = new Thread(new ITPrinterThread(printer), "it");

        //not Acceptable in the real life = the printing is mixed up
        /*gmPrinterThread.start();
        hrPrinterThread.start();*/

        //We need to synchronise job in the printer= we use  join method
        gmPrinterThread.start();
        //gmPrinterThread.join();


        //join my job and execute it in batch
        dgmPrinterThread.start();
        //dgmPrinterThread.join();

        hrPrinterThread.start();
        itPrinterThread.start();


        System.out.println("==== Thread  " + Thread.currentThread().getName() + " Stopped ====");
    }
}
