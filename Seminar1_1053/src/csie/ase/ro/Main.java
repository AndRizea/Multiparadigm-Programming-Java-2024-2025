package csie.ase.ro;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("Hello from group 1053");
		
		Carte fictiune = new Carte("Fictiune", 250);
		
		System.out.println("Titlu: " + fictiune.getTitlu() + ", Numar pagini: " + fictiune.getNrPagini());
		
		// shallow copy
		Carte fictiuneEdit = fictiune;
		
		fictiuneEdit.setNrPagini(300);
		
		System.out.println("Titlu: " + fictiune.getTitlu() + ", Numar pagini: " + fictiune.getNrPagini());
		System.out.println("Titlu: " + fictiuneEdit.getTitlu() + ", Numar pagini: " + fictiuneEdit.getNrPagini());
		
		// deep copy
		Carte fictiuneDeep = (Carte) fictiune.clone();
		fictiuneDeep.setNrPagini(350);
		System.out.println("Titlu: " + fictiune.getTitlu() + ", Numar pagini: " + fictiune.getNrPagini());
		System.out.println("Titlu: " + fictiuneEdit.getTitlu() + ", Numar pagini: " + fictiuneEdit.getNrPagini());
		System.out.println("Titlu: " + fictiuneDeep.getTitlu() + ", Numar pagini: " + fictiuneDeep.getNrPagini());

		
		

	}

}
