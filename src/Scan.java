import java.util.Locale;

public class Scan {
    public long search(String text, String word){
      int num1=0;
        int index = text.toLowerCase().indexOf(word.toLowerCase(), 0);
        while (index != -1) {
            num1++;
            index = text.toLowerCase().indexOf(word.toLowerCase(), index + 1);
        }
        return num1;
    }
}



