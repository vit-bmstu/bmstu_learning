package com.company;

import java.util.*;

public class Main {
    private static List<Integer> divider(int divider, Integer[] array) {
        List<Integer> divided = new LinkedList<Integer>();
        for (Integer anArray : array) {
            if (anArray % divider == 0)
                divided.add(anArray);
        }
        return divided;
    }
    private static long gcd(long a, long b) // NOD
    {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static long gcd(Integer[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++)
            result = gcd(result, input[i]);
        return result;
    }

    private static long lcm(long a, long b) // NOK
    {
        return a * (b / gcd(a, b));
    }

    private static long lcm(Integer[] input) {
        long result = input[0];
        for (int i = 1; i < input.length; i++) {
            if ((input[i] == 0 || input[0] == 0)
                    || (input[i] < 0 || input[0] < 0))
                break;
            result = lcm(result, input[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.print("Сколько целых чисел вы собираетесь ввести? ");
        Scanner in = new Scanner(System.in);
        int size = in.nextInt();
        if (size == 0) {
            System.out.print("Программа завершена.");
            System.exit(0);
        }
        Integer[] numbers = new Integer[size];
        System.out.print("Введите целые числа через пробел "
                + "и нажмите <Enter>: ");
        for (int i = 0; i < size; i++)
            numbers[i] = in.nextInt();

        // NOD NOK
        System.out.println("Наибольший общий делитель: " + gcd(numbers));
        System.out.println("Наименьшее общее кратное: " + lcm(numbers));
    }
}