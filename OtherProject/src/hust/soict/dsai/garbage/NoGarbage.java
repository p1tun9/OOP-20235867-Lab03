package hust.soict.dsai.garbage;

public class NoGarbage {
    public static void main(String[] args) {
        StringBuilder noGarbage = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            noGarbage.append("This is garbage number: ").append(i); // Xử lý bằng StringBuilder
        }
        System.out.println("No garbage created. Task completed!");
    }
}
