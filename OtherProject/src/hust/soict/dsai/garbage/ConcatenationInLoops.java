package hust.soict.dsai.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);

        // Sử dụng toán tử "+"
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2); // Nối chuỗi bằng toán tử "+"
        }
        System.out.println("Time using + operator: " + (System.currentTimeMillis() - start) + " ms");

        // Sử dụng StringBuilder
        r = new Random(123); // Reset lại Random để kết quả tương tự
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2)); // Nối chuỗi bằng StringBuilder
        }
        s = sb.toString();
        System.out.println("Time using StringBuilder: " + (System.currentTimeMillis() - start) + " ms");
    }
}
