package com.triangule;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.triangule.controller.TrianguleController;
import com.triangule.exception.InvalidTrianguleException;
import com.triangule.exception.TrianguleException;
import com.triangule.model.Triangule;
import com.triangule.model.TrianguleTypes;

import junit.framework.Assert;

public class TrianguleTest {

	Triangule triangule;
	TrianguleController controller;
	List<BigDecimal> sides;

	@Before
	public void prepare(){
		triangule = new Triangule();
		controller = new TrianguleController();
		sides = new ArrayList<BigDecimal>();
	}
	
	@Test
	public void shouldBeScalene() throws Exception {

		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("14"));
		sides.add(new BigDecimal("12"));

		triangule.setSides(sides);

		this.controller.calculateType(triangule);

		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.SCALENE));
	}

	@Test
	public void shouldBeIsosceles() throws Exception {

		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("10"));

		triangule.setSides(sides);

		this.controller.calculateType(triangule);

		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.ISOSCELES));
		
		sides.clear();
		
		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("10"));
		sides.add(new BigDecimal("15"));

		triangule.setSides(sides);

		this.controller.calculateType(triangule);

		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.ISOSCELES));
		
		sides.clear();
		
		sides.add(new BigDecimal("10"));
		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));

		triangule.setSides(sides);

		this.controller.calculateType(triangule);

		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.ISOSCELES));
	}

	@Test
	public void shouldBeEquilateral() throws Exception {

		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));

		triangule.setSides(sides);

		this.controller.calculateType(triangule);

		Assert.assertTrue(triangule.getType().equals(TrianguleTypes.EQUILATERAL));

	}

	@Test(expected = TrianguleException.class)
	public void shouldNotBeFourSides() throws Exception {

		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));

		triangule.setSides(sides);

	}
	
	@Test(expected = TrianguleException.class)
	public void shouldNotBeTwoSides() throws Exception {

		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));

		triangule.setSides(sides);

	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldBePositive() throws Exception {
		
		sides.add(new BigDecimal("-15"));
		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));

		triangule.setSides(sides);

	}
	
	@Test(expected = IllegalStateException.class)
	public void shouldNotBeZero() throws Exception {
		
		sides.add(new BigDecimal("0"));
		sides.add(new BigDecimal("15"));
		sides.add(new BigDecimal("15"));

		triangule.setSides(sides);

	}
	
	@Test
	public void shouldBeDefault() throws Exception {
		
		List<BigDecimal> sides2 = triangule.getSides();
		TrianguleTypes type = triangule.getType();

		this.controller.calculateType(triangule);
		
		Assert.assertTrue(type.equals(TrianguleTypes.DEFAULT));
		Assert.assertTrue(onlyZero(sides2));

	}
	
	@Test(expected = InvalidTrianguleException.class)
	public void shouldBeNotValid() throws Exception {
		
		sides.add(new BigDecimal("1"));
		sides.add(new BigDecimal("1"));
		sides.add(new BigDecimal("10"));

		triangule.setSides(sides);

	}
	
	private Boolean onlyZero(List<BigDecimal> sides) {
		for(BigDecimal side : sides){
			if(side.compareTo(BigDecimal.ZERO) != 0)
				return false;
		}
		return true;
	}
}