package hust.soict.dsai.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadFileUsingPlus {
    public static void main(String[] args) {
        try {
            byte[] inputBytes = Files.readAllBytes(Paths.get("test.txt")); // Đọc tệp
            long startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char) b; // Nối chuỗi bằng "+"
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Time taken using + operator: " + (endTime - startTime) + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
