package AIMS;

public class Cart {
    private static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    int qtyOrdered = 0;

    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
        	itemsOrdered[qtyOrdered] = dvd;
        	qtyOrdered++;
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

    public float calculateTotalCost() {
        float total = 0;
        for (DigitalVideoDisc dvd : itemsOrdered) {
            if (dvd != null) {
            	total += dvd.getCost();
            }
        }
        return total;
    }

    public void displayCart() {
        if (itemsOrdered == null) {
            System.out.println("Cart is empty.");
        } else {
            for (DigitalVideoDisc dvd : itemsOrdered) {
            	if (dvd != null) {
            		if (dvd.getLength() != 0) {
                		System.out.println("Title: " + dvd.getTitle());
                        System.out.println("Category: " + dvd.getCategory());
                        System.out.println("Director: " + dvd.getDirector());
                        System.out.println("Length: " + dvd.getLength());
                        System.out.println("Cost: " + dvd.getCost() + " VND");
                        System.out.println();
                    } else {
                    	if (dvd.getDirector() != null) {
                    		System.out.println("Title: " + dvd.getTitle());
                            System.out.println("Category: " + dvd.getCategory());
                            System.out.println("Director: " + dvd.getDirector());
                            System.out.println("Cost: " + dvd.getCost() + " VND");
                            System.out.println();
                    	} else {
                    		if (dvd.getCategory() == null && dvd.getCost() == 0) {
                    			System.out.println("Title: " + dvd.getTitle());
                    		} else {
                    			System.out.println("Title: " + dvd.getTitle());
                                System.out.println("Category: " + dvd.getCategory());
                                System.out.println("Cost: " + dvd.getCost() + " VND");
                                System.out.println();
                    		} 
                    	}
                    }
                } else {
                	break;
                }
            }
        }
    }
}
