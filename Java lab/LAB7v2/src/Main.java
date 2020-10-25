/** В тексте найти и напечатать все слова максимальной и все слова минимальной длины.
 */

import java.util.Scanner;

public class Main {
    void poisk(String str)
    {
        if (str == null)
            return;
        String sw="",lw="";
        int s=str.length(),l=0;
        String words[]=str.split(" ");
        for(String word:words)
        {
            if(word.length()<s)
            {
                sw=word;
                s = word.length();
            }
            if(word.length()>l)
            {
                lw=word;
                l = word.length();
            }
        }
        System.out.println("Самое длинное слово : "+lw);
        System.out.println("Самое короткое слово : "+sw);
    }
    public static void main(String[] args) {
        Scanner scr=new Scanner(System.in);
        Main obj=new Main();
        System.out.printf("Нам нужен ваш текст. Напишите фразу, чтобы получить самое длинное и самое короткое " +
                        "слово: \n");
        String str=scr.nextLine();
        str+=" ";
        obj.poisk(str);
    }
}