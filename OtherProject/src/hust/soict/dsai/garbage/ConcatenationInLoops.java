package hust.soict.dsai.garbage;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        int iterations = 10000;

        long startTime = System.nanoTime();
        String result = "";
        for (int i = 0; i < iterations; i++) {
            result += i;
        }
        long endTime = System.nanoTime();
        System.out.println("Time taken with String (+): " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken with StringBuilder: " + (endTime - startTime) / 1e6 + " ms");

        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(i);
        }
        endTime = System.nanoTime();
        System.out.println("Time taken with StringBuffer: " + (endTime - startTime) / 1e6 + " ms");
    }
}
