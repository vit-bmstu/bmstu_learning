/**
 * 5.  В каждом предложении текста поменять местами первое слово с последним не изменяя длины предложения.
 */
public class Str5 {
    public static void main(String[] args) {
        String str = "У нас есть три предложения. Поменяем местами местами первое и последнее слово. Надеюсь у нас все получится. Оно создано специально для этой программы.";
        Replacement replacement = new Replacement();
        System.out.print((str)+ '\n');
        System.out.print(replacement.replaceWord(str));
    }
}
class Replacement {
    public StringBuilder replaceWord(String str) {
        StringBuilder newStr = new StringBuilder();
        String strSentences[] = str.split("[.!?]");
        char[] arrayCharStr = str.toCharArray();
        char punctuationMark[] = new char[strSentences.length];
        int numberPunctuationMark = 0;
        for (int i = 0; i < arrayCharStr.length; ++i) {
            if (arrayCharStr[i] == '.' || arrayCharStr[i] == '!' || arrayCharStr[i] == '?') {
                punctuationMark[numberPunctuationMark] = arrayCharStr[i];
                numberPunctuationMark++;
            }
        }
        for (int i = 0; i < strSentences.length; ++i) {
            String[] strWord = strSentences[i].split(" ");
            String temp = strWord[0];
            strWord[0] = strWord[strWord.length - 1];
            strWord[strWord.length - 1] = temp;
            for (int j = 0; j < strWord.length; ++j) {
                if (j == strWord.length - 1) {
                    newStr.append(strWord[j]).append(punctuationMark[i]);
                } else {
                    newStr.append(strWord[j]).append(" ");
                }
            }
        }
        return newStr;
    }
}