package csie.ase.ro.classes;

import csie.ase.ro.interfaces.Moveable;

public class Car extends Vehicle implements Moveable {

	private String color;
	private float capacity;

	public Car() {
		super();
		this.color = "white";
		this.capacity = 1.0f;
		System.out.println("Car default constructor");
	}

	public Car(String manufacturer, int noSeats, String color, float capacity) {
		super(manufacturer, noSeats);
		this.color = color;
		this.capacity = capacity;
		System.out.println("Car constructor");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getCapacity() {
		return capacity;
	}

	public void setCapacity(float capacity) {
		this.capacity = capacity;
	}

	public float computeTax(int quantum, float capacity) {
		return (float) quantum * capacity;
	}

	public int computeTax(int quantum, int noSeats) {
		return quantum * noSeats;
	}

	@Override
	public void open() {
		System.out.println("The car is opened");

	}

	@Override
	public void move() {
		System.out.println("The car is moving below " + Moveable.MAX_SPEED + "km/h.");

	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", capacity=" + capacity + ", manufacturer=" + super.getManufacturer()
				+ ", no of seats=" + super.getNoSeats() + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		Car clone = (Car) super.clone();
		clone.color = color;
		clone.capacity = capacity;
		return clone;
	}

}
