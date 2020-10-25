/**В зависимости от признака (0 или 1) в каждой строке текста удалить указанный символ везде,
 * где он встречается, или вставить его после k-гo символа.
 *
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // В зависимости от признака (0 или 1) в каждой строке текста удалить указанный
        // символ везде, где он встречается, или вставить его после K-го символа.
        String a = "а";// 0
        String b = "с";// 1
        String text = "Шла Саша по шоссе и сосала сушку";
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите число 0, если хотите удалить символы из строки  или 1 - если хотите вставить " +
                "символ после определенного символа");

        while (!scan.hasNextInt()) {

            scan.next();

        }
        int inputScanner = scan.nextInt();

        if (inputScanner == 0) {

            Arrays.asList(text).stream().forEach(textNew -> System.out.println("Вы удалили все символы а из предложен" +
                    "ия " +"\"" +text.replace(a, "") + "\""));

        }
        else if (inputScanner == 1) {

            System.out.println("Введите число от 1 до " + text.length() + " чтобы мы знали в какое место строки вставл" +
                    "ять символ $");
            int inputScanner2 = scan.nextInt();
            if (inputScanner2 <= text.length()) {
                StringBuffer t = new StringBuffer (text);
                System.out.println(t.insert((inputScanner2),"$"));
            }
            else {
                System.out.println("Вы ввели неверное число, запустите программу сначала!");
            }


        }

    }

}