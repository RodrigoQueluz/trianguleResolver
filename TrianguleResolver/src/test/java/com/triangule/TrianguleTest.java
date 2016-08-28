package com.triangule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.triangule.controller.TrianguleController;
import com.triangule.exception.TrianguleException;
import com.triangule.model.Triangule;
import com.triangule.model.TrianguleTypes;

import junit.framework.Assert;

public class TrianguleTest {

	Triangule triangule= new Triangule();
	TrianguleController controller = new TrianguleController();

	@Test
	public void shouldBeScalene() throws Exception {
		List<Double> sides = new ArrayList<Double>();
		sides.add(15D);
		sides.add(14D);
		sides.add(12D);

		triangule.setSides(sides);
		
		this.controller.calculateType(triangule);
		
		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.SCALENE));
	}

	@Test
	public void shouldBeIsosceles() throws Exception {
		List<Double> sides = new ArrayList<Double>();
		sides.add(15D);
		sides.add(15D);
		sides.add(10D);

		triangule.setSides(sides);
		
		this.controller.calculateType(triangule);
		
		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.ISOSCELES));
	}

	@Test
	public void shouldBeEquilateral() throws Exception {
		List<Double> sides = new ArrayList<Double>();
		sides.add(15d);
		sides.add(15d);
		sides.add(15d);

		triangule.setSides(sides);
		
		this.controller.calculateType(triangule);
		
		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.EQUILATERAL));

	}
	
	@Test
	public void shouldBeSides(){
		List<Double> sides = new ArrayList<Double>();
		sides.add(15d);
		sides.add(15d);
		sides.add(15d);
		sides.add(15d);

		try {
			triangule.setSides(sides);
		} catch (Exception e) {
			Assert.assertEquals(e.getClass(), TrianguleException.class);
		}
		
	}
	
	public static boolean contains(String test) {

		for (TrianguleTypes c : TrianguleTypes.values()) {
			if (c.name().equals(test)) {
				return true;
			}
		}

		return false;
	}

}