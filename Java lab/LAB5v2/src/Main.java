/** Реализовать абстрактные классы или интерфейсы, а также наследование и полиморфизм для следующих классов
 * interface Врач <- class Хирург <- class Нейрохирург.
 */


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Neurosurgeon neurosurgeon = new Neurosurgeon("Ringo Star");

        List<Surgeon> surgeons = new ArrayList<>();
        surgeons.add(neurosurgeon);

        for (Surgeon surgeon: surgeons){
            surgeon.setDiagnos("Ann", 11);
            surgeon.treat();//добавим исключение
                ((Neurosurgeon)surgeon).sayName();
            try {
                System.out.println("---------------------------------");
            }catch(IndexOutOfBoundsException e1){
                System.out.println("произошла ошибка");
            }

        }

    }

}