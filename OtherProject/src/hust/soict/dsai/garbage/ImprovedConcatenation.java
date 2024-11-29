package hust.soict.dsai.garbage;

import java.util.Random;

public class ImprovedConcatenation {
    public static void main(String[] args) {
        Random r = new Random(123);

        // Sử dụng toán tử +
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Time using + operator: " + (System.currentTimeMillis() - start) + "ms");

        // Sử dụng StringBuffer
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        System.out.println("Time using StringBuffer: " + (System.currentTimeMillis() - start) + "ms");

        // Sử dụng StringBuilder
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb2.append(r.nextInt(2));
        }
        System.out.println("Time using StringBuilder: " + (System.currentTimeMillis() - start) + "ms");
    }
}
