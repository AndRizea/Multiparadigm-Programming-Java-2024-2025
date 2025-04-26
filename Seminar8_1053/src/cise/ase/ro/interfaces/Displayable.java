package cise.ase.ro.interfaces;

@FunctionalInterface
public interface Displayable {
	
	public void display();
	
	default public void display2() {
		System.out.println("Hi, I am a default method");
	}
}
