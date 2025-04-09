package csie.ase.ro.classes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private float average;

	public Student() {
		name = "";
		average = 1.0f;
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

	public void serialize() throws IOException {
		FileOutputStream fileOutputStream = new FileOutputStream("student.data");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(this);
		objectOutputStream.close();
	}

	public void deserialize() throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream = new FileInputStream("student.data");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Student s = (Student) objectInputStream.readObject();
		this.name = s.name;
		this.average = s.average;
		objectInputStream.close();
	}

}
