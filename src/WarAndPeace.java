
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WarAndPeace {
    public static void main(String[] args) {
        Scan scan = new Scan();
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        String file = "C:\\Users\\New\\IdeaProjects\\WarAndPeace\\Война и мир_книга.txt";
        System.out.println("Выберите топ слов");
        int top = scanner.nextInt();
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
            String clearFile = fileContent.replaceAll("\\n+", " ");
            clearFile = clearFile.replaceAll("[-!:()+?,.;\"\\n]", "");
            String[] words = clearFile.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (map.containsKey(words[i])) {
                    map.put(words[i], map.remove(words[i]) + 1);
                } else
                    map.put(words[i], 1);
            }
            List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, Comparator.<Map.Entry<String, Integer>, Integer>comparing(Map.Entry::getValue).reversed());
            for (int i = 0; i < top; i++)
                System.out.println(list.get(i));
            System.out.println("Введите слово которое ищем");
            String word= scanner.next();
            System.out.println(scan.search(clearFile,word));
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}

