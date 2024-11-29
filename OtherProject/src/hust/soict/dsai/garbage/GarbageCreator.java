package hust.soict.dsai.garbage;
import java.util.ArrayList;
import java.util.List;

public class GarbageCreator {
    public static void main(String[] args) {
        List<String> garbage = new ArrayList<>();
        try {
            for (int i = 0; i < 1000000; i++) {
                garbage.add("This is garbage number: " + i); // Tạo "rác" liên tục
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory! Too much garbage created.");
        }
    }
}
