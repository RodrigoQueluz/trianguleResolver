package com.triangule.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.triangule.exception.InvalidTrianguleException;
import com.triangule.exception.TrianguleException;

public class Triangule {

	private BigDecimal size1, size2, size3;
	private TrianguleTypes type;

	public Triangule() {
		size1 = new BigDecimal("0");
		size2 = new BigDecimal("0");
		size3 = new BigDecimal("0");
		type = TrianguleTypes.DEFAULT;
	}

	public void setSides(List<BigDecimal> sides) throws Exception {
		if (sides.size() == 3) {
			size1 = verifySide(sides, 0);
			size2 = verifySide(sides, 1);
			size3 = verifySide(sides, 2);

			if (!verifyValidTriangule())
				throw new InvalidTrianguleException("The sides doesn't build a triangule!");
		} else
			throw new TrianguleException("A triangule should have only 3 sides");
	}

	public List<BigDecimal> getSides() {

		List<BigDecimal> sides = new ArrayList<BigDecimal>();
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

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(System.getProperty("line.separator"));
		strBuilder.append("Triangule sides:");
		strBuilder.append(System.getProperty("line.separator"));
		strBuilder.append("Side 1: " + size1);
		strBuilder.append(System.getProperty("line.separator"));
		strBuilder.append("Side 2: " + size2);
		strBuilder.append(System.getProperty("line.separator"));
		strBuilder.append("Side 3: " + size3);
		strBuilder.append(System.getProperty("line.separator"));

		strBuilder.append(System.getProperty("line.separator"));
		strBuilder.append("Triangule Type:");
		strBuilder.append(System.getProperty("line.separator"));
		strBuilder.append(this.type);

		return strBuilder.toString();

	}

	private BigDecimal verifySide(List<BigDecimal> sides, int index) {

		if (sides.get(index).compareTo(BigDecimal.ZERO) < 1) {
			throw new IllegalStateException("A side must be greater than zero");
		} else {
			return sides.get(index);
		}
	}
	

	private boolean verifyValidTriangule() {
		if (size1.compareTo(size3.subtract(size2)) == 1 && size1.compareTo(size2.subtract(size3)) == 1
				&& size2.compareTo(size1.subtract(size3)) == 1)
			return true;
		else
			return false;
	}
}
