package hust.soict.dsai.aims.store;

import java.util.Scanner;

import hust.soict.dsai.aims.AdminInterface;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store mainStore = new Store();
		mainStore.test(mainStore);
		Scanner scanner = new Scanner(System.in);
		AdminInterface admin = new AdminInterface(mainStore);
		admin.Admin(scanner);
		scanner.close();
	}

}
