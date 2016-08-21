package com.triangule.model;

import java.util.ArrayList;
import java.util.List;

import com.triangule.exception.TrianguleException;

public class Triangule {

	private double size1, size2, size3;
	private TrianguleTypes type;

	public void setSides(List<Double> sides) throws Exception {
		if (sides.size() == 3) {
			size1 = sides.get(0);
			size2 = sides.get(1);
			size3 = sides.get(2);
		} else
			throw new TrianguleException("A triangule should have only 3 sides");
	}

	public List<Double> getSides() {
		
		List<Double> sides = new ArrayList<Double>();
		sides.add(size1);
		sides.add(size2);
		sides.add(size3);

		return sides;
	}

	public TrianguleTypes getType() {
		return type;
	}

	public void setType(TrianguleTypes type) {
		this.type = type;
	}
}
