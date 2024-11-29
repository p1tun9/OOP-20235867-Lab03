package hust.soict.dsai.aims.cart;

import java.util.Scanner;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", 18.99f);
        cart.addDVD(dvd3);

        // Test the print method
        cart.displayCart();
        // To-do: Test the search methods here
		Scanner scanner = new Scanner(System.in);
        System.out.print("Search dvd (by id or title) (enter e to exit): ");
        while (scanner.hasNext()) {
        	if (scanner.hasNextInt()) {
            	int id = scanner.nextInt();
            	cart.search(id);
                System.out.print("Search dvd (by id or title) (enter e to exit): ");
            } else {
            	String temp = scanner.nextLine();
            	if (temp.equals("e")) break;
            	else if (temp.equals("E")) break;
            	cart.search(temp);
                System.out.print("Search dvd (by id or title) (enter e to exit): ");
            }
        }
        scanner.close();
        System.out.print("Exiting.");

    }
}
