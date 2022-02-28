package duplication;

public class EntierB implements  Cloneable{

    private  int entier = 10;

    public EntierB  clone() throws  CloneNotSupportedException {

        return  (EntierB) super.clone();
    }

    public int getEntier() {
        return entier;
    }

    public void setEntier(int entier) {
        this.entier = entier;
    }
}
