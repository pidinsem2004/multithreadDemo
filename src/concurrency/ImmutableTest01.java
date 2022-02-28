package concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Dans cette exemple, on voit comment il est possible
 * de modifier depuis un appel les données membre d'une classe
 * malgré l'encapsulation
 *
 * Pour éviter toute modification depuis l'exterieur, il faut
 * mettre en oeuvre l'immutabilité par
 * - renvoi de copie de la référence de l'objet et non la référence de l'objet elle-meme
 * - sur une collection
 * */

public class ImmutableTest01 {

    List<String> list = new ArrayList<>();

    public void add(String val){
         list.add(val);

    }

    public List<String> get (){
         return list;

    }

    public List<String> unmodifiableGet (){
        return  Collections.unmodifiableList(list);
    }


    public static  void main(String...args) {


        ImmutableTest01 immutableTest01 = new ImmutableTest01();
        immutableTest01.add("one");
        immutableTest01.add("two");
        //+ Arrays.deepToString(immutableTest01.get().toArray())
        System.out.println("Liste : " + immutableTest01.get());

        //Cas de la modification malgré l'encapsulation
        List<String> uneListe = immutableTest01.get();
        uneListe.add("three");
        System.out.println("Nouvelle Liste " + immutableTest01.get());

        //mise en oeuvre de l'immutabilité
        System.out.println("Récupération de la nouvelle liste et ajout d'un élément four");
        uneListe = immutableTest01.unmodifiableGet();
        uneListe.add("four");
        System.out.println("Nouvelle Liste après immutabilité " + immutableTest01.get());


    }
}
