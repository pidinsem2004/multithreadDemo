package Thread;

public class Singleton {
    private static  volatile  Singleton instance = null;
    public Singleton(){}

    public static  Singleton getInstance(){

        synchronized (instance){
            if (instance==null)
                instance = new Singleton();
        }
        return  instance;
    }
}
