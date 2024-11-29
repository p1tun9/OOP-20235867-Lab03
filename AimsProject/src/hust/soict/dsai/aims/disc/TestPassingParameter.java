package hust.soict.dsai.aims.disc;

public class TestPassingParameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
//swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
		System.out.println("Cinderella DVD title: " + cinderellaDVD.getTitle());

		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle DVD title: " + jungleDVD.getTitle());
	}
	
	public static void swap(Object a, Object b) {
		Object temp = a;
		a = b;
		b = temp;
	}
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String temp = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(temp);
	}
}
