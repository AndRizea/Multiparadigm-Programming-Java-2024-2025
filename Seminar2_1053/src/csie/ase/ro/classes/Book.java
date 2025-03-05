package csie.ase.ro.classes;

public class Book {
	private String title;
	private int noPages;
	private int[] ratings;

	public enum Genre {
		SF, Drama, Comedy
	};

	private Genre genre;

	public Book() {
		title = "";
		noPages = 0;
		ratings = new int[1];
		ratings[0] = 0;
		genre = Genre.SF;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNoPages() {
		return noPages;
	}

	public void setNoPages(int noPages) {
		this.noPages = noPages;
	}

	public int[] getRatings() {
		int[] copy = new int[ratings.length];

		/*
		 * for(int i=0;i<ratings.length;i++) { copy[i] = ratings[i]; }
		 */

		System.arraycopy(ratings, 0, copy, 0, ratings.length);
		return copy;
	}

	public void setRatings(int[] ratings) {
		this.ratings = new int[ratings.length];
		for (int i = 0; i < ratings.length; i++) {
			this.ratings[i] = ratings[i];
		}

	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public void showRatings() {
		for (int i = 0; i < ratings.length; i++) {
			System.out.print(ratings[i] + " ");
		}
		System.out.println();
	}

	public float getAverageRating() {
		float average = 0;
		int sum = 0;

		for (int i = 0; i < ratings.length; i++) {
			sum += ratings[i];
		}

		average = (float) sum / ratings.length;

		return average;

	}

	@Override
	public Object clone() /* throws CloneNotSupportedException */ {
		Book clone = new Book();
		clone.title = new String(title);
		clone.noPages = this.noPages;
		clone.genre = this.genre;
		clone.ratings = getRatings();
		return clone;
	}

}
