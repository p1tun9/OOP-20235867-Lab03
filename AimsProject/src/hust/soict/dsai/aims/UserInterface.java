package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class UserInterface {
    public void UI(Store mainStore, Scanner scan) {
        Cart user = new Cart(mainStore);
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add DVD to Cart");
            System.out.println("2. Remove DVD from Cart");
            System.out.println("3. Search DVD");
            System.out.println("4. Calculate Total Cost");
            System.out.println("5. View Cart");
            System.out.println("6. View Store");
            System.out.println("7. Exit");
            System.out.print("Enter: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter DVD Title or DVD ID: ");
                    if (scan.hasNextInt()) {
                        int id = scan.nextInt();
                        user.addDVDfromStore(id);
                    } else {
                        String temp = scan.nextLine();
                        user.addDVDfromStore(temp);
                    }
                    break;

                case 2:
                    System.out.print("Enter DVD Title or DVD ID to remove: ");
                    if (scan.hasNextInt()) {
                        int id = scan.nextInt();
                        user.removeDVD(id);
                    } else {
                        String temp = scan.nextLine();
                        user.removeDVD(temp);
                    }
                    break;

                case 3:
                    boolean exit2 = false;
                    while (!exit2) {
                        System.out.println("You want to search DVD in cart or store?");
                        System.out.println("1. In cart");
                        System.out.println("2. In store");
                        System.out.println("3. Exit");
                        System.out.print("Enter: ");
                        int choice2 = scan.nextInt();
                        scan.nextLine();
                        switch (choice2) {
                            case 1:
                                System.out.print("Search DVD in cart (by ID or title): ");
                                if (scan.hasNextInt()) {
                                    int id = scan.nextInt();
                                    user.search(id);
                                } else {
                                    String temp = scan.nextLine();
                                    user.search(temp);
                                }
                                break;

                            case 2:
                                System.out.print("Search DVD in store (by ID or title): ");
                                if (scan.hasNextInt()) {
                                    int id = scan.nextInt();
                                    DigitalVideoDisc tempDVD = mainStore.searchInStore(id);
                                    if (tempDVD == null) {
                                        System.out.println("No matching DVD found.\n");
                                    } else {
                                        tempDVD.displayDVD();
                                    }
                                } else {
                                    String temp = scan.nextLine();
                                    DigitalVideoDisc tempDVD = mainStore.searchInStore(temp);
                                    if (tempDVD == null) {
                                        System.out.println("No matching DVD found.\n");
                                    } else {
                                        tempDVD.displayDVD();
                                    }
                                }
                                break;

                            case 3:
                                exit2 = true;
                                System.out.println("Exiting search menu.");
                                break;

                            default:
                                System.out.println("Invalid choice.");
                                break;
                        }
                    }
                    break;

                case 4:
                    System.out.println("Total Cost: " + user.calculateTotalCost() + " VND");
                    break;

                case 5:
                    user.displayCart();
                    break;

                case 6:
                    mainStore.displayStore();
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}
