/**7.	Прочитать текст Java-программы и удалить из него все “лишние” пробелы и табуляции, оставив только
 * необходимые для разделения операторов.
**/
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main{
    public static void main (String[] args){
        File fileIN = new File("/Users/vitaly/Desktop/testFile.txt");
        File fileOUT = new File("/Users/vitaly/Desktop/testFile1.txt");
        int b;
        char[] tempChar = new char[10000];
        try{
            FileReader fileReader = new FileReader(fileIN);
            FileWriter fileWriter = new FileWriter(fileOUT);
            for(int i = 0;(b = fileReader.read()) != -1; i++){tempChar[i] = (char)b;}
            String tempString = new String(tempChar);
            System.out.println("Программа перед редактированием: \n" + tempString);
            tempString =(tempString.replaceAll("[\\s&&[^\r?\n]]{2,}", " ")
                    .replaceAll("( ?(\r\n)){2,}", "\r\n").replaceAll("( ?\n){2,}", "\n")
                    .replaceAll("\n ", "\n").trim());;
            System.out.println("Программа после редактирования: \n" + tempString);
            char[] resultText = tempString.toCharArray();
            fileWriter.write(resultText);
            fileReader.close();
            fileWriter.close();
        }catch (IOException e) {
            System.err.println("Ошибка файла: " + e);
        }
    }
}
