package hust.soict.dsai.lab01;

import java.util.Arrays;
import java.util.Scanner;
public class bai6_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        } Arrays.sort(arr);
        int sum = 0;
        for (int num : arr) {
            sum += num;
        } double ave = (double) sum / size;
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("average: " + ave);
        System.exit(0);
        scanner.close();
    }
}
