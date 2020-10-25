/* ввести n слов с консоли; найти слово состоящее только из различных символов,
	если таких слов несколько, то первое из них */
package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan;

        String text;
        String[] textArray;

        System.out.println("Введите текст:");

        scan = new Scanner(System.in);
        text = scan.nextLine();

        textArray = text.split(" ");

        for(int i = 0; i < textArray.length; i++) {
            textArray[i] = textArray[i].replaceAll("[“:”,\"'`;()?_-]", "");
            if(uniqueSymbolsChecker(textArray[i])) {
                System.out.print("Cлово, состоящее только из различных символов:" + textArray[i]);
                break;
            }
        }
    }
    private static boolean uniqueSymbolsChecker(String word) {
        boolean result = false;

        ArrayList<Character> list = new ArrayList<>();
        char[] chars = word.toCharArray();

        for(char c : chars) {
            if (list.contains(c)) {
                result = false;
                return result;
            }
            else {
                list.add(c);
                result = true;
            }
        }

        return result;
    }
}
