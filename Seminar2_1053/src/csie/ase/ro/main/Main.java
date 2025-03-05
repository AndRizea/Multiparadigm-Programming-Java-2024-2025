package csie.ase.ro.main;

import csie.ase.ro.classes.Book;

public class Main {

	public static void main(String[] args) {
		Book book1 = new Book();
		book1.setTitle("Book1");
		book1.setNoPages(250);
		
		System.out.println("Title: " + book1.getTitle() + ", No pages: " + book1.getNoPages() + ", genre: " + book1.getGenre());
		System.out.print("Ratings: ");
		book1.showRatings();
		
		Book book2 = (Book) book1.clone();
		book2.setRatings(new int[]{3, 3, 5});
		book2.setTitle("Book2");

		System.out.println("Title: " + book2.getTitle() + ", No pages: " + book2.getNoPages() + ", genre: " + book2.getGenre());
		System.out.print("Ratings: ");
		book2.showRatings();
		System.out.println("Average rating: " + book2.getAverageRating());
	}

}
