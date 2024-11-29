package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private static final int MAX = 1000;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX];
	int number = 0;
	public void addDVDtoStore(DigitalVideoDisc dvd) {
        if (number < MAX) {
        	itemsInStore[number++] = dvd;
            System.out.println("DVD added to store.");
        } else {
            System.out.println("The store is almost full.");
        }
    }
	
	public void removeDVDinStore(String title) {
        for (int i = 0; i < number; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].getTitle().equals(title)) {
                itemsInStore[i] = null;
                for (int j = i; j < number - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[number - 1] = null; 
                number--; 
                System.out.println("DVD removed from store.");
                return;
            }
        }
        System.out.println("DVD not found.");
    }
	public void removeDVDinStore(int id) {
        for (int i = 0; i < number; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].toString().equals(String.valueOf(id))) {
                itemsInStore[i] = null;
                for (int j = i; j < number - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[number - 1] = null; 
                number--; 
                System.out.println("DVD removed from store.");
                return;
            }
        }
        System.out.println("DVD not found.");
    }
	
	public DigitalVideoDisc searchInStore(int id) {
    	for (DigitalVideoDisc dvd : itemsInStore) {
    		if (dvd == null) break;
    		if((dvd.toString()).equals(String.valueOf(id))) {
    			return dvd;
    		}
    	}
        return null;
    }
    public DigitalVideoDisc searchInStore(String title) {
    	for (DigitalVideoDisc dvd : itemsInStore) {
    		if (dvd == null) break;
    		if((dvd.getTitle()).equals(title)) {
    			return dvd;
    		}
    	}
        return null;
    }
    
    public void displayStore() {
        if (number == 0) {
            System.out.println("Store is empty.\n");
        } else {
        	StringBuilder stars = new StringBuilder();
        	for (int i = 0; i < ((80 - 4)/2); i++) {
        	    stars.append("*");
        	}
        	System.out.println(stars + "STORE" + stars);
            System.out.println("Items in store:");
            System.out.println("[ID]. DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
            for (DigitalVideoDisc dvd : itemsInStore) {
            	if(dvd == null) {
            		break;
            	}
            	dvd.displayDVD();
            }
        	System.out.println(stars + "****" + stars + "\n");
        }
    }
    
    public void test(Store store) {
        // Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 175, 22.50f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 154, 15.99f);

        // Thêm các DVD vào Store
        store.addDVDtoStore(dvd1);
        store.addDVDtoStore(dvd2);
        store.addDVDtoStore(dvd3);
        store.addDVDtoStore(dvd4);
        store.addDVDtoStore(dvd5);
    }
}
