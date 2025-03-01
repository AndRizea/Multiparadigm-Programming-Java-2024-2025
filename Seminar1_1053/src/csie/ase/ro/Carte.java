package csie.ase.ro;

public class Carte {
	
	String titlu;
	int nrPagini;
	
	
	public String getTitlu() {
		return titlu;
	}
	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}
	public int getNrPagini() {
		return nrPagini;
	}
	public void setNrPagini(int nrPagini) {
		this.nrPagini = nrPagini;
	}
	
	public Carte(String titlu, int nrPagini) {
		super();
		this.titlu = titlu;
		this.nrPagini = nrPagini;
	}
	
	public Carte() {
		this.nrPagini=0;
		this.titlu = new String("Titlu");
	}
	
	@Override
	protected Object clone() {
		Carte copie = new Carte();
		copie.titlu = new String(this.titlu);
		copie.nrPagini = this.nrPagini;
		return copie;
	}
	
	
	

}
