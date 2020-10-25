/** Задана коллекция строк. Получить массив уникальных значений.
* Использовать ТОЛЬКО методы Stream API. Циклов и условий быть не должно.
*/

import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public List<String> strings;

    public Main(List<String> strings) {
        this.strings = strings;
    }

    public List<String> task() {
        return strings.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
