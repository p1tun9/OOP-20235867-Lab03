package hust.soict.dsai.lab01;

import java.util.Scanner;

public class bai6_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month: ");
        String month = scanner.nextLine();
        int year = 0;
        while (true) {
            System.out.print("Enter the year: ");
            String stryear = scanner.nextLine();
            if (stryear.matches("\\d{4}")) {
                year = Integer.parseInt(stryear);
                break;
            } else {
                System.out.println("Invalid input.");
            }
        } boolean lyear = lyear(year);
        int daysInMonth = getDaysInMonth(month, lyear);
        if (daysInMonth == -1) {
            System.out.println("Invalid input.");
        } else {
            System.out.println("The month has " + daysInMonth + " days.");
        } System.exit(0);
        scanner.close();
    }
    public static boolean lyear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } return true;
        } return false;
    }
    public static int getDaysInMonth(String month, boolean lyear) {
        month = month.toLowerCase(); 
        switch (month) {
            case "january": case "jan.": case "jan": case "1":
            case "march": case "mar.": case "mar": case "3":
            case "may": case "may.": case "5":
            case "july": case "jul.": case "jul": case "7":
            case "august": case "aug.": case "aug": case "8":
            case "october": case "oct.": case "oct": case "10":
            case "december": case "dec.": case "dec": case "12":
                return 31;
            case "april":case "apr.":case "apr":case "4":
            case "june":case "jun.":case "jun":case "6":
            case "september":case "sep.":case "sep":case "9":
            case "november": case "nov.": case "nov": case "11":
            	return 30;
            case "february":case "feb.":case "feb":case "2":
                return lyear ? 29 : 28;
            default:
            	return -1;
        }
    }
}
