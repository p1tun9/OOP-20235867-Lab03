package hust.soict.dsai.aims;
import java.util.Scanner;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AdminInterface {
	private static Store store = new Store();
	public AdminInterface (Store mainStore) {
		store = mainStore;
	}
	
	public void Admin(Scanner scanner) {
        boolean exit = false;
        while (!exit) {
            System.out.println("1. Add DVD to Store");
            System.out.println("2. Remove DVD from Store");
            System.out.println("3. Search DVD");
            System.out.println("4. View Store");
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
                store.addDVDtoStore(dvd);
                break;

            case 2:
                System.out.print("Enter DVD Title or DVD ID to remove: ");
                if (scanner.hasNextInt()) {
                	int id = scanner.nextInt();
                	store.removeDVDinStore(id);
                } else {
                	String temp = scanner.nextLine();
                	store.removeDVDinStore(temp);
                }
                break;

            case 3:
                System.out.print("Search dvd (by ID or title): ");
                if (scanner.hasNextInt()) {
                	int id = scanner.nextInt();
                	DigitalVideoDisc tempDVD = store.searchInStore(id);
                	if (tempDVD == null) {
                        System.out.println("No matching DVD found.\n");
                	} else {
                		tempDVD.displayDVD();
                	}
                } else {
                	String temp = scanner.nextLine();
                	DigitalVideoDisc tempDVD = store.searchInStore(temp);
                	if (tempDVD == null) {
                        System.out.println("No matching DVD found.\n");
                	} else {
                		tempDVD.displayDVD();
                	}
                }
                break;

            case 4:
                store.displayStore();
                break;
                
            case 5:
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
