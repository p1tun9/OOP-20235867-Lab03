package hust.soict.dsai.lab01;

import java.util.Scanner;
public class bai6_6 {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrice1 = new int[n][m];
        int[][] matrice2 = new int[n][m];
        System.out.println("Enter the first matrice:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	matrice1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Enter the second matrice:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	matrice2[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Result:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
            	int temp = matrice1[i][j] + matrice2[i][j];
                System.out.print(temp + " ");
            } System.out.println();
        }
        System.exit(0);
        scanner.close();
    }
}