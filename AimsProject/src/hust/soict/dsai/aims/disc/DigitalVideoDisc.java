package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.length = 0;		
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = "Unknown";
		this.cost = cost;
		this.length = 0;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.category = "Unknown";
		this.director = "Unknown";
		this.cost = 0;
		this.length = 0;
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	@Override
    public String toString() {
    	return String.valueOf(id);
    }
	
	public void displayDVD() {
		if (this.getLength() == 0 && this.getCost() == 0) {
    		System.out.println(this.toString() + ". DVD - " + this.getTitle() + " - "
    				+ this.getCategory() + " - " + this.getDirector()
    				+ " - Unknown: Unknown.");
    	} else if (this.getLength() == 0) {
    		System.out.println(this.toString() + ". DVD - " + this.getTitle() + " - "
    				+ this.getCategory() + " - " + this.getDirector()
    				+ " - Unknown: " + this.getCost() + "$.");
    	} else if (this.getCost() == 0) {
    		System.out.println(this.toString() + ". DVD - " + this.getTitle() + " - "
    				+ this.getCategory() + " - " + this.getDirector()
    				+ " - " + this.getLength() + ": Unknown.");
    	} else {
    		System.out.println(this.toString() + ". DVD - " + this.getTitle() + " - "
    				+ this.getCategory() + " - " + this.getDirector()
    				+ " - " + this.getLength() + ": " + this.getCost() + "$.");
    	}
    }
}
