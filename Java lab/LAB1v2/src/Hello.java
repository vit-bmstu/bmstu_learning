import java.util.Scanner;

public class Hello {

    public static void main(String[] args) {
        System.out.print("Ведите свое имя и нажмите Enter:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
    }
}
