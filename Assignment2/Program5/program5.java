import java.io.*;
import java.util.*;

public class WordCountDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("hello.txt");
        Scanner sc = new Scanner(file);

        Map<String, Integer> wordCount = new HashMap<>();

        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        sc.close();
        System.out.println("Word Occurrences: " + wordCount);
    }
}
