package com.triangule.controller;

import java.math.BigDecimal;

import com.triangule.model.Triangule;
import com.triangule.model.TrianguleTypes;

public class TrianguleController {

	public void calculateType(Triangule triangule) {
		BigDecimal size1 = triangule.getSides().get(0);
		BigDecimal size2 = triangule.getSides().get(1);
		BigDecimal size3 = triangule.getSides().get(2);

		if (onlyPositiveSides(triangule)) {
			if (size1.compareTo(size2) == 0 && size1.compareTo(size3) == 0) {
				triangule.setType(TrianguleTypes.EQUILATERAL);
			} else if (size1.compareTo(size2) == 0 || size1.compareTo(size3) == 0 || size2.compareTo(size3) == 0) {
				triangule.setType(TrianguleTypes.ISOSCELES);
			} else
				triangule.setType(TrianguleTypes.SCALENE);
		} else {
			triangule.setType(TrianguleTypes.DEFAULT);
		}

	}

	private boolean onlyPositiveSides(Triangule triangule) {
		for (BigDecimal side : triangule.getSides()) {
			if (side.compareTo(BigDecimal.ZERO) < 1)
				return false;
		}
		return true;
	}
}
