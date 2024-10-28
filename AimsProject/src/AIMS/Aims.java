package AIMS;
import java.util.Scanner;

public class Aims {
	public static void main(String[] args) {
		Cart anOrder = new Cart();
		Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add DVD to Cart");
            System.out.println("2. Remove DVD from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Calculate Total Cost");
            System.out.println("5. Exit");
            System.out.print("Enter: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter DVD Title: ");
                    String title = scanner.nextLine();
                    if (title.isEmpty()) {
                        System.out.println("Title can't be empty.");
                        break;
                    }
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    category = category.isEmpty() ? null : category;

                    System.out.print("Enter Director: ");
                    String director = scanner.nextLine();
                    director = director.isEmpty() ? null : director;

                    System.out.print("Enter Length (enter 0 to skip): ");
                    int length = scanner.nextInt();
                    length = (length < 0) ? 0 : length;

                    System.out.print("Enter Cost (enter 0 to skip): ");
                    float cost = scanner.nextFloat();
                    scanner.nextLine();
                    cost = (cost < 0) ? 0 : cost;
                    
                    DigitalVideoDisc dvd = null;
                    if (length != 0) {
                    	dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    } else {
                    	if (director != null) {
                    		dvd = new DigitalVideoDisc(title, category, director, cost);
                    	} else {
                    		if (category == null && cost == 0) {
                    			dvd = new DigitalVideoDisc(title);
                    		} else if (category != null && cost != 0) {
                    			dvd = new DigitalVideoDisc(title, category, cost);
                    		} else {
                    			System.out.println("Error");
                    			break;
                    		}
                    	}
                    }
                    anOrder.addDVD(dvd);
                    break;

                case 2:
                    System.out.print("Enter DVD Title to remove: ");
                    String removeTitle = scanner.nextLine();
                    anOrder.removeDVD(removeTitle);
                    break;

                case 3:
                    anOrder.displayCart();
                    break;

                case 4:
                    System.out.println("Total Cost: " + anOrder.calculateTotalCost() + " VND");
                    break;

                case 5:
                    exit = true;
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }
}

