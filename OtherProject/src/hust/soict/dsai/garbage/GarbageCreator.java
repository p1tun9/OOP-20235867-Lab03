package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        try {
            String filePath = "large_text_file.txt";
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            String result = "";
            long startTime = System.nanoTime();
            for (char c : content.toCharArray()) {
                result += c;
            }
            long endTime = System.nanoTime();

            System.out.println("Time taken with String (+): " + (endTime - startTime) / 1e6 + " ms");
        } catch (IOException e) {
            System.err.println("File not found or cannot be read.");
        }
    }
}
