package csie.ase.ro.classes;

public class Student {

	private String name;
	private float average;

	public Student() {

	}

	public Student(String name, float average) {
		super();
		this.name = name;
		this.average = average;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(name);
		builder.append(", average=");
		builder.append(average);
		builder.append("]");
		return builder.toString();
	}

}
