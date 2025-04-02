package csie.ase.ro.main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import csie.ase.ro.classes.Student;

public class Main {

	public static void main(String[] args) {
		Student s = new Student("John", 9.6f);
		
		System.out.println(s);
		
		/*
		Scanner scanner = new Scanner(System.in);
		Student stud = new Student();
		System.out.println("Student name: ");
		stud.setName(scanner.nextLine());
		System.out.println("Average: ");
		stud.setAverage(scanner.nextFloat());
		System.out.println(stud);
		*/
		
		// wrtie to txt file
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("student.txt");
			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			bufferedWriter.write(s.getName());
			bufferedWriter.write(System.lineSeparator());
			bufferedWriter.write(String.valueOf(s.getAverage()));
			bufferedWriter.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// read from txt file
		BufferedReader bufferedReader = null;
		try {
			FileInputStream fileInputStream = new FileInputStream("student.txt");
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			bufferedReader = new BufferedReader(inputStreamReader);
			Student student = new Student();
			String name = bufferedReader.readLine();
			student.setName(name);
			student.setAverage(Float.parseFloat(bufferedReader.readLine()));
			System.out.println(student);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File file = new File("student.txt");
		try (Scanner scanner = new Scanner(file)) {
			Student s1 = new Student();
			s1.setName(scanner.next());
			s1.setAverage(scanner.nextFloat());
			System.out.println(s1);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

}
