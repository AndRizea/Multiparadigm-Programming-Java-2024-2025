package csie.ase.ro.classes;

import java.util.Objects;

public class Car implements Comparable<Car> {
	private String color;
	private int capacity;
	private String manufacturer;

	public Car() {
		this.color = "white";
		this.capacity = 1000;
		this.manufacturer = "";
	}

	public Car(String manufacturer, String color, int capacity) {
		this.color = color;
		this.capacity = capacity;
		this.manufacturer = manufacturer;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", capacity=" + capacity + ", manufacturer=" + manufacturer + "]";
	}

	@Override
	public int compareTo(Car o) {

		if (capacity < o.capacity) {
			return -1;
		} else if (capacity == o.capacity) {
			return 0;
		} else {
			return 1;
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(manufacturer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(manufacturer, other.manufacturer);
	}

	/*
	 * @Override public int hashCode() { return manufacturer.hashCode(); }
	 * 
	 * @Override public boolean equals(Object obj) { if (obj instanceof Car) { Car c
	 * = (Car) obj; return manufacturer.equals(c.manufacturer); } else { return
	 * false; }
	 * 
	 * }
	 */
	
	
	
	

}
