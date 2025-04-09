package csie.ase.ro.main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

import csie.ase.ro.classes.Student;

public class Main {

	public static void main(String[] args) {
		Student student = new Student("John", 9.7f);
		System.out.println(student);

		// write binary
		try (FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
				DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream)) {
			dataOutputStream.writeUTF(student.getName());
			dataOutputStream.writeFloat(student.getAverage());
		} catch (IOException e) {
			e.printStackTrace();
		}

		// read binary
		try (FileInputStream fileInputStream = new FileInputStream("student.bin");
				DataInputStream dataInputStream = new DataInputStream(fileInputStream)) {
			Student s = new Student();
			s.setName(dataInputStream.readUTF());
			s.setAverage(dataInputStream.readFloat());
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// serialize
		try {
			student.serialize();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// deserialize
		Student student2 = new Student();
		try {
			student2.deserialize();
			System.out.println(student2);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

		try (RandomAccessFile randomAccessFile = new RandomAccessFile("student.bin", "r")) {
			System.out.println("Pointer position: " + randomAccessFile.getFilePointer());
			randomAccessFile.seek(randomAccessFile.length() - Float.BYTES);
			System.out.println("Pointer position: " + randomAccessFile.getFilePointer());
			float value = randomAccessFile.readFloat();
			System.out.println(value);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
