package csie.ase.ro.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import csie.ase.ro.classes.Car;

public class Main {

	public static void main(String[] args) {
		Car car = new Car("Honda", "black", 1900);
		Car car2 = new Car("Ford", "green", 1600);
		Car car3 = new Car("Honda", "black", 2200);
		Car car4 = new Car("Kia", "red", 1600);

		System.out.println("List:");
		List<Car> carsList = new ArrayList<Car>();
		carsList.add(car3);
		carsList.add(car2);
		carsList.add(car);
		carsList.add(car4);

		for (Car c : carsList) {
			System.out.println(c);
		}

		System.out.println("Set:");
		Set<Car> carSet = new TreeSet<Car>();
		carSet.add(car3);
		carSet.add(car2);
		carSet.add(car);
		//carSet.add(car4); //-> duplicates are not allowed

		for (Car c : carSet) {
			System.out.println(c);
		}
		
		System.out.println("Map");
		Map<Car, Integer> map = new HashMap<Car, Integer>();
		// Manufacture : number
		for(Car c : carSet) {
			if(!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				Integer value = map.get(c);
				map.put(c, ++value);
			}
		}
		
		for(Map.Entry<Car, Integer> e : map.entrySet()) {
			System.out.print(e.getKey());
			System.out.print(" : ");
			System.out.println(e.getValue());
		}
	}

}
