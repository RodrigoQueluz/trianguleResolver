package com.triangule;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.triangule.controller.TrianguleController;
import com.triangule.exception.TrianguleException;

import junit.framework.Assert;

public class TrianguleTest {

	Triangule triangule;
	TrianguleController controller;

	@Before
	public void setUp() throws Exception {
		this.triangule = new Triangule();
		this.controller = new TrianguleController();

	}

	@Test
	public void test() throws Exception {
	
		testEquilateral();
		testIsosceles();
		testScalene();
		testSizeSides();

	}

	@After
	public void tearDown() {
		Assert.assertNotNull(triangule);
		Assert.assertEquals(triangule.getSides().size(), 3);
		Assert.assertTrue(contains(triangule.getType().toString()));
	}

	public static boolean contains(String test) {

		for (TrianguleTypes c : TrianguleTypes.values()) {
			if (c.name().equals(test)) {
				return true;
			}
		}

		return false;
	}
	
	private void testScalene() throws Exception {
		List<Double> sides = new ArrayList<Double>();
		sides.add(15D);
		sides.add(14D);
		sides.add(12D);

		triangule.setSides(sides);
		
		this.controller.calculateType(triangule);
		
		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.SCALENE));
	}

	private void testIsosceles() throws Exception {
		List<Double> sides = new ArrayList<Double>();
		sides.add(15D);
		sides.add(15D);
		sides.add(10D);

		triangule.setSides(sides);
		
		this.controller.calculateType(triangule);
		
		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.ISOSCELES));
	}

	private void testEquilateral() throws Exception {
		List<Double> sides = new ArrayList<Double>();
		sides.add(15d);
		sides.add(15d);
		sides.add(15d);

		triangule.setSides(sides);
		
		this.controller.calculateType(triangule);
		
		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.EQUILATERAL));

	}
	
	private void testSizeSides(){
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

}