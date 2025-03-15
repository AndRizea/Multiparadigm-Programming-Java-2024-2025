package csie.ase.ro.classes;

public abstract class Vehicle {

	private String manufacturer;
	private int noSeats;

	public Vehicle() {
		System.out.println("Vehicle default constructor");
		this.manufacturer = "";
		this.noSeats = 1;
	}

	public Vehicle(String manufacturer, int noSeats) {
		this.manufacturer = manufacturer;
		this.noSeats = noSeats;
		System.out.println("Vehicle constructor");
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public int getNoSeats() {
		return noSeats;
	}

	public void setNoSeats(int noSeats) {
		this.noSeats = noSeats;
	}

	public void startEngine() {
		System.out.println("Vehicle's engine started...");
	}

	@Override
	public String toString() {
		return "Vehicle [manufacturer=" + manufacturer + ", noSeats=" + noSeats + "]";
	}

	public abstract void open();

}