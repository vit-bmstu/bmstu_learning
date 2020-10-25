import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> outputList;
        Facultet faculty = new Facultet();

        System.out.print("Введите вашу фамилию: ");
        String surname = reader.readLine();
        System.out.print("Введите ваше имя: ");
        String name = reader.readLine();

        Student student = new Student(surname, name);
        System.out.println("\nВы можете записаться на факультативный курс, " + student.getSurname()+ " " + student.getName() + "!");

        System.out.println("\nВыберите курс, который вы планируете посещать: (цифра от 1 до 3)");
        outputList = faculty.getListOfCourse();
        for (int i = 0; i < outputList.size(); i++) {
            System.out.println((i+1) + ") " + outputList.get(i));
        }

        int switchCourse = Integer.parseInt(reader.readLine());
        System.out.println("Вы выбрали " + outputList.get(switchCourse-1));

        System.out.println("\nВыберите преподавателя: (цифра от 1 до 3)");
        outputList = faculty.getListOfTeacher();
        for (int i = 0; i < outputList.size(); i++) {
            System.out.println((i+1) + ") " + outputList.get(i));
        }

        int switchTeacher = Integer.parseInt(reader.readLine());
        System.out.println("Вы выбрали " + outputList.get(switchTeacher-1));

        System.out.println("\nКурс закончился.");
        Thread.sleep(2000);
        System.out.println("Пора оценить ваши знания.");
        Thread.sleep(2000);
        int mark = (int) (Math.random()*11);
        if (mark < 4) {
            System.out.println("Ваша оценка: " + mark);
        }  else {
            System.out.println("Ваша оценка: " + mark);
        }

        Thread.sleep(4000);

        System.out.println("\nСписок однокурсников: ");
        outputList = faculty.getListOfStudent();
        outputList.add(student.getSurname() + " " + student.getName() + " " + mark);
        for (int i = 0; i < outputList.size()-1; i++) {
            mark = (int) (Math.random()*5);
            System.out.println((i+1) + ") " + outputList.get(i) + " " + mark);
        }
        System.out.print("4) " + outputList.get(3));
    }
}