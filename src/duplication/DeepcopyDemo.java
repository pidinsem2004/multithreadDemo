package duplication;

import java.util.Arrays;
import java.util.List;

public class DeepcopyDemo implements Cloneable {

    private int entierLocal = 1;
    private EntierA entierA = new EntierA();
    private int[] tableau = {0, 100};
    private EntierB entierB = new EntierB();


    public DeepcopyDemo clone() throws CloneNotSupportedException {

        DeepcopyDemo copie = (DeepcopyDemo) super.clone();

        copie.entierA = (EntierA) entierA.clone();
        copie.entierB = (EntierB) entierB.clone();

        copie.tableau = new int[tableau.length];
        System.arraycopy(tableau, 0, copie.tableau, 0, tableau.length);

        return copie;


    }


    public int getEntierLocal() {
        return entierLocal;
    }

    public void setEntierLocal(int entierLocal) {
        this.entierLocal = entierLocal;
    }

    public EntierA getEntierA() {
        return entierA;
    }

    public void setEntierA(EntierA entierA) {
        this.entierA = entierA;
    }

    public int[] getTableau() {
        return tableau;
    }

    public void setTableau(int[] tableau) {
        this.tableau = tableau;
    }

    public EntierB getEntierB() {
        return entierB;
    }

    public void setEntierB(EntierB entierB) {
        this.entierB = entierB;
    }

    public static void main(String...args){
        DeepcopyDemo dc1 = new DeepcopyDemo() ;
        System.out.println("Dans l'original " + dc1.getEntierLocal() + " " +
        dc1.getEntierA().getEntier() + " " +
                dc1.getTableau()[1] + " " +
                dc1.getEntierB().getEntier());
        System.out.println("Dans la copie   " + dc1.getEntierLocal() + " " +
                dc1.getEntierA().getEntier() +  " "
                + dc1.getTableau()[1] + " " +
                dc1.getEntierB().getEntier());

        dc1.setEntierLocal(2);
        dc1.getEntierA().setEntier(20);
        dc1.getTableau()[1] = 200;
        dc1.getEntierB().setEntier(2000);


        System.out.println("\nApres changement de tout ce que contient l'original :");

        System.out.println("Dans l'original " + dc1.getEntierLocal() + " " +
                dc1.getEntierA().getEntier() + " " +
                dc1.getTableau()[1] +  " " +
                dc1.getEntierB().getEntier());

        System.out.println("Dans la copie   " +
                dc1.getEntierLocal() + " " +
                dc1.getEntierA().getEntier() +  " " +
                dc1.getTableau()[1] + " " +
                dc1.getEntierB().getEntier());

    }
}
