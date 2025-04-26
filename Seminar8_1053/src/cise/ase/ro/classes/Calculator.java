package cise.ase.ro.classes;

import cise.ase.ro.interfaces.Operatable;

public class Calculator implements Operatable {

	@Override
	public double operate(double o1, double o2) {
		return o1 + o2;
	}

}
