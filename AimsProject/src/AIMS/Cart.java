package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;
    private static Store store = new Store();
    
    public Cart(Store mainStore) {
    	store = mainStore;
    }
    public Cart() {
    	super();
    }

    public void addDVDfromStore(String title) {
    	DigitalVideoDisc dvd = store.searchInStore(title);
    	if (dvd == null) {
            System.out.println("No matching DVD found.\n");
            return;
    	}
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
        	itemsOrdered[qtyOrdered] = dvd;
        	qtyOrdered++;
            System.out.println("DVD " + dvd.getTitle() + " added to cart.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void addDVDfromStore(int id) {
    	DigitalVideoDisc dvd = store.searchInStore(id);
    	if (dvd == null) {
            System.out.println("No matching DVD found.\n");
            return;
    	}
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
        	itemsOrdered[qtyOrdered] = dvd;
        	qtyOrdered++;
            System.out.println("DVD " + dvd.getTitle() + " added to cart.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    //bài 2:
    public void addDVD(DigitalVideoDisc[] dvdList) {
        if (qtyOrdered + dvdList.length <= MAX_NUMBERS_ORDERED) {
        	for (DigitalVideoDisc dvd : dvdList) {
        		itemsOrdered[qtyOrdered] = dvd;
        	}
        	qtyOrdered += dvdList.length;
            System.out.println("List of DVDs added to cart.");
        } else {
            System.out.println("The cart is only " + (MAX_NUMBERS_ORDERED - qtyOrdered)
            												+ " places left.");
        }
    }
    public void addDVD(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
    	if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
        	itemsOrdered[qtyOrdered++] = dvd1;
        	itemsOrdered[qtyOrdered++] = dvd2;        	
            System.out.println("2 DVDs added to cart.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void addDVD(DigitalVideoDisc dvd){
    	if (qtyOrdered < MAX_NUMBERS_ORDERED) {
        	itemsOrdered[qtyOrdered++] = dvd;
            System.out.println("DVD added to cart.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }
    public void removeDVD(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getTitle().equals(title)) {
                itemsOrdered[i] = null;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; 
                qtyOrdered--; 
                System.out.println("DVD removed from cart.");
                return;
            }
        }
        System.out.println("DVD not found.");
    }
    public void removeDVD(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].toString().equals(String.valueOf(id))) {
                itemsOrdered[i] = null;
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered - 1] = null; 
                qtyOrdered--; 
                System.out.println("DVD removed from cart.");
                return;
            }
        }
        System.out.println("DVD not found.");
    }

    public float calculateTotalCost() {
        float total = 0;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd != null) {
            	total += dvd.getCost();
            }
        }
        return total;
    }
//bai6
    public void displayCart() {
        if (qtyOrdered == 0) {
            System.out.println("Cart is empty.\n");
        } else {
        	StringBuilder stars = new StringBuilder();
        	for (int i = 0; i < ((80 - 4)/2); i++) {
        	    stars.append("*");
        	}
        	System.out.println(stars + "CART" + stars);
            System.out.println("Ordered Items:");
            System.out.println("[ID]. DVD - [Title] - [category] - [Director] - [Length]: [Price] $");
            for (DigitalVideoDisc dvd : itemsOrdered) {
            	if(dvd == null) {
            		break;
            	}
            	dvd.displayDVD();
            }
        	System.out.println("Total cost: " + this.calculateTotalCost() + "$.");
        	System.out.println(stars + "****" + stars + "\n");
        }
    }
    
    public void search(int id) {
    	boolean isDisplay = false;
    	for (DigitalVideoDisc dvd : itemsOrdered) {
    		if (dvd == null) break;
    		if((dvd.toString()).equals(String.valueOf(id))) {
    			dvd.displayDVD();
    			isDisplay = true;
    			break;
    		}
    	}
    	if (!isDisplay) {
        	System.out.println("No matching DVD found.\n");
    	}
    }
    public void search(String title) {
    	boolean isDisplay = false;
    	for (DigitalVideoDisc dvd : itemsOrdered) {
    		if (dvd == null) break;
    		if((dvd.getTitle()).equals(title)) {
    			dvd.displayDVD();
    			isDisplay = true;
    		}
    	}
    	if (!isDisplay) {
        	System.out.println("No matching DVD found.\n");
    	}
    }
}
