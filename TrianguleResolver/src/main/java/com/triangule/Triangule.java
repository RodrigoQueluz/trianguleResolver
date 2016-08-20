package com.triangule;

import java.util.List;

import com.triangule.exception.TrianguleException;

public class Triangule {

	private List<Double> sides;
	private TrianguleTypes type;

	public void setSides(List<Double> sides) throws Exception {
		if (sides.size() == 3)
			this.sides = sides;
		else
			throw new TrianguleException("A triangule should have only 3 sides");
	}

	public List<Double> getSides() {
		return sides;
	}
	
	public TrianguleTypes getType() {
		return type;
	}

	public void setType(TrianguleTypes type) {
		this.type = type;
	}
}
