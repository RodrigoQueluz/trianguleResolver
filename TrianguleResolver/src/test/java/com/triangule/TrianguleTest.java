package com.triangule;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.triangule.controller.TrianguleController;
import com.triangule.exception.TrianguleException;
import com.triangule.model.Triangule;
import com.triangule.model.TrianguleTypes;

import junit.framework.Assert;

public class TrianguleTest {

	Triangule triangule;
	TrianguleController controller;
	List<Double> sides;

	@Before
	public void prepare(){
		triangule = new Triangule();
		controller = new TrianguleController();
		sides = new ArrayList<Double>();
	}
	@Test
	public void shouldBeScalene() throws Exception {

		sides.add(15D);
		sides.add(14D);
		sides.add(12D);

		triangule.setSides(sides);

		this.controller.calculateType(triangule);

		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.SCALENE));
	}

	@Test
	public void shouldBeIsosceles() throws Exception {

		sides.add(15D);
		sides.add(15D);
		sides.add(10D);

		triangule.setSides(sides);

		this.controller.calculateType(triangule);

		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.ISOSCELES));
	}

	@Test
	public void shouldBeEquilateral() throws Exception {

		sides.add(15d);
		sides.add(15d);
		sides.add(15d);

		triangule.setSides(sides);

		this.controller.calculateType(triangule);

		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.EQUILATERAL));

	}

	@Test(expected = TrianguleException.class)
	public void shouldBeThreeSides() throws Exception {

		sides.add(15d);
		sides.add(15d);
		sides.add(15d);
		sides.add(15d);

		triangule.setSides(sides);

	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldBePositive() throws Exception {
		
		sides.add(-15d);
		sides.add(15d);
		sides.add(15d);

		triangule.setSides(sides);

	}
}