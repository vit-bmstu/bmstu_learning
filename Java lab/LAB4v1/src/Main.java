public class Main {
        public static void main(String[] args){
                //'Cinema' class testing.
                Cinema cinema = new Cinema();
                showAddStatus(cinema.add("Фильм1", 2001, "Жанр1",
                        "Директор1", 100, 5000000));
                showAddStatus(cinema.add("Фильм2", 2002, "Жанр2",
                        "Директор2", 50, 1000000));
                showAddStatus(cinema.add("Фильм3", 2003, "Жанр3",
                        "Директор3", 75, 3000000));

                showDeleteStatus(cinema.delete());
                cinema.printAll();
                showDeleteStatus(cinema.delete());
                cinema.printAll();
                showDeleteStatus(cinema.delete());
                cinema.printAll();

                showAddStatus(cinema.add("Фильм4", 2004, "Жанр4",
                        "Директор4", 90, 3000000));
                showAddStatus(cinema.add("Фильм5", 2005, "Жанр5",
                        "Директор5", 120, 7000000));

                cinema.printAll();
        }

        //Instead of writing "sout" each time.
        static void showAddStatus(boolean value){
                System.out.println("Adding operation status: "  + value);
        }

        //The same as in the previous comment.
        static void showDeleteStatus(boolean value){
                System.out.println("Deleting operation status: " + value);
        }
}