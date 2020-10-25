/**10.	Создать класс Cinema (кино) с внутренним классом, с помощью объектов которого можно хранить
 * информацию об адресах кинотеатров, фильмах и времени сеансов.
 */
public class Main {
    public static void main(String[] args) {
        //'Cinema' class testing.

        Cinema cinema = new Cinema();
        showAddStatus(cinema.add("Фильм", 2001, "Жанр1",
                "проспект Мира, 17", 100, 5000000));
        showAddStatus(cinema.add("Фильм2", 2002, "Жанр2",
                "улица Строителей, 3", 50, 1000000));
        showAddStatus(cinema.add("Фильм3", 2003, "Жанр3",
                "улица Новая, 15", 75, 3000000));
        showDeleteStatus(cinema.delete());
        cinema.printAll();
        showDeleteStatus(cinema.delete());
        cinema.printAll();
        showDeleteStatus(cinema.delete());
        cinema.printAll();

        showAddStatus(cinema.add("Фильм4", 2004, "Жанр4",
                "улица Белинского, 16", 90, 3000000));
        showAddStatus(cinema.add("Фильм5", 2005, "Жанр5",
                "проспект Руставелли, 1", 120, 7000000));

        cinema.printAll();
    }


    static void showAddStatus(boolean value) {
        System.out.println("Adding operation status: " + value);
    }


    static void showDeleteStatus(boolean value) {
        try {                                                              //добавим исключение - проверку
            System.out.println("Deleting operation status: " + value);
        } catch (IndexOutOfBoundsException e1) {
            System.out.println("неверное значение");
        }
    }
}