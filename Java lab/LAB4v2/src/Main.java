import java.util.ArrayList;
import java.util.List;

/** Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 * interface Врач <- class Хирург <- class Нейрохирург.  */

public class Main {

    public static void main(String[] args) {

        Neurosurgeon neurosurgeon = new Neurosurgeon("Ringo Star");

        List<Surgeon> surgeons = new ArrayList<>();
        surgeons.add(neurosurgeon);

        for (Surgeon surgeon: surgeons){
            surgeon.setDiagnos("Ann", 11);
            surgeon.treat();
            ((Neurosurgeon)surgeon).sayName();
            System.out.println("---------------------------------");
        }

    }

}