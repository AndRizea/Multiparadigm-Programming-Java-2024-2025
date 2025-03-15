package csie.ase.ro.main;

import csie.ase.ro.classes.Car;
import csie.ase.ro.classes.Vehicle;

public class Main {

	public static void main(String[] args) {
		
		/*
		 * 
		// --------------------	INHERITENCE --------------------
		Vehicle vehicle = new Vehicle("BMW", 5);
		System.out.println(vehicle);

		Car car = new Car(vehicle.getManufacturer(), vehicle.getNoSeats(), "black", 2.0f);
		System.out.println(car);

		Vehicle v = new Car(); // upcasting (implicit) 
		v.startEngine();

		*
		*/
		
		// --------------------	ABSTRACTION --------------------
		Vehicle v = new Car();
		v.open();
		System.out.println(v);
		
		Car c = new Car();
		c.open(); // -> because it is a vehicle; all vehicles shall be able to be opened -> method implemented as abstract
		c.startEngine(); // -> main characteristic of a vehicle; inherited
		c.honk(); // -> main characteristic of a car
		c.drive(); // -> mandatory/ required characteristic of a moveable car
		
	}
		
}


