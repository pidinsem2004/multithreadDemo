package duplication;

public class EntierA  implements  Cloneable{
    private  int entier = 10;

    public EntierA clone() throws CloneNotSupportedException {

        return  (EntierA) super.clone();
    }


    public int getEntier() {
        return entier;
    }

    public void setEntier(int entier) {
        this.entier = entier;
    }
}
