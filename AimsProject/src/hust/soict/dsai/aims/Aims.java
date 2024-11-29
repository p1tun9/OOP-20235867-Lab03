package hust.soict.dsai.aims;
import java.util.Scanner;

import hust.soict.dsai.aims.store.Store;

public class Aims {
	public static void main(String[] args) {
		Store mainStore = new Store();
		mainStore.test(mainStore);
		Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
        	System.out.println("You are admin or user ?");
    		System.out.println("1.User (Create your cart and add or remove DVD in your cart)");
    		System.out.println("2.Admin (Add or remove DVD in store)");
    		System.out.println("3.Exit");
    		System.out.print("Enter: ");
            int choice = scanner.nextInt();
        	switch (choice) {
        		case 1: 
        			UserInterface user = new UserInterface();
        			user.UI(mainStore, scanner);
        			break;
        		
        		case 2:
        			AdminInterface admin = new AdminInterface(mainStore);
        			admin.Admin(scanner);
        			break;
        		
        		case 3:
        			exit = true;
        			System.out.println("Exiting.");
        			break;
                
        		default: 
        			System.out.println("Invalid choice.");
        			break;
                
        	}    
        }
        scanner.close();
    }
}

