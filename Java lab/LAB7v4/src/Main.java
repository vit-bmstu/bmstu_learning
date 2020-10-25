/** 7.	Подсчитать, сколько слов в заданном тексте начинается с прописной буквы.
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String s1;
        Scanner scan = new Scanner(System.in);
        System.out.println("Нам нужны выши буквы! Введите строку из строчных и прописных букв... ");
        s1 = scan.nextLine();
        int count=0,i=0,n;
        n = s1.length();
        System.out.println("Количество символов в строке... " + n );
        if ( null == s1 || s1.isEmpty())
        {
            System.out.println("Text empty");
        }
        else
        {
            if( Character.isUpperCase(s1.charAt(0) ))
            {
                count++;
            }
            for (i=1 ; i<n ; i++)
            {
                if (  Character.isWhitespace(s1.charAt(i-1)) && Character.isUpperCase(s1.charAt(i) ) )
                {
                    count++;
                }
            }
        }

        System.out.println("Количество слов, которые начинаются с прописной буквы... " + count );
            }
        }
