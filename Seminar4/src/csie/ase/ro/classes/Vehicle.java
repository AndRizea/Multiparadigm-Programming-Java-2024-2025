package csie.ase.ro.classes;

public abstract class Vehicle implements Cloneable {

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

	public abstract void open();

	@Override
	public String toString() {
		return "Vehicle [manufacturer=" + manufacturer + ", noSeats=" + noSeats + "]";
	}

	// the proper implementation of clone
	// the base object super is used because the class is abstract
	// it will be called from the derived/super class
	@Override
	public Object clone() throws CloneNotSupportedException {
		Vehicle clone = (Vehicle) super.clone();
		clone.manufacturer = manufacturer;
		clone.noSeats = noSeats;
		return clone;
	}

}
