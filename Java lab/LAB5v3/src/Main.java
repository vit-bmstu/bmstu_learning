/** В каждом слове стихотворения Николая Заболоцкого заменить первую букву слова на прописную.
*/

import java.io.*;
public class Main {
    public static void main(String[] args){
        try {
            File f = new File("/Users/vitaly/Desktop/BadFile.txt");
            FileInputStream fis=new FileInputStream(f);//читающий поток
            DataInputStream ods = new DataInputStream(fis);
            int size=fis.available();

            char Array[]=new char[size];
            for(int i=0;i<size;i++){
                if(fis.read()!=-1){
                    Array[i]=ods.readChar();
                    System.out.println(Array[i]);
                }}
            fis.close();

            FileOutputStream os = new FileOutputStream("/Users/vitaly/Desktop/NewFile.txt");
            DataOutputStream od = new DataOutputStream(os);
            for(int i=0;i<size;i++){
                if(Array[i]==' '){
                    Array[i+1]=Character.toUpperCase(Array[i+1]);
                }
                od.writeChar(Array[i]);
            }

            os.close();
            //закрытие потока
        }

        catch (IOException e){
            System.out.println("ошибка файла: " + e);
        }
    }
}