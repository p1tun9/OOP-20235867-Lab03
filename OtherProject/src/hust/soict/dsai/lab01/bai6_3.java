package hust.soict.dsai.lab01;
import java.util.Scanner;
public class bai6_3 {
	public static void main(String[] args) {
		Scanner a = new Scanner (System.in);
		System.out.print("Enter a number: ");
		int n = a.nextInt();
		a.close();
		int k = 0, i = 0, j = 0;
		for (k = 0; k < n; k++) {
			i = n - k - 1;
			j = 2*k + 1;
			while (i > 0) {
				System.out.print(" ");
				i--;
			} while (j > 0) {
				System.out.print("*");
				j--;
			} System.out.println();
		}
	}
}