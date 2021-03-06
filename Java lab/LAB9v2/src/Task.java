/** Задание 13.	Задана коллекция строк:
*Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1"); Убрать первый символ и вернуть числа.
*/

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Task {
    public static void main(String[] args) {

        Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        List<Integer> number = collection.stream().map((s) -> Integer.parseInt(s.substring(1))).collect(Collectors.toList());
        System.out.println("числа = " + number);
    }
}



