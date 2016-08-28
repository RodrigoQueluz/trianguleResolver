package com.triangule.model;

import java.util.ArrayList;
import java.util.List;

import com.triangule.exception.TrianguleException;

public class Triangule {

	private double size1, size2, size3;
	private TrianguleTypes type;

	public void setSides(List<Double> sides) throws Exception {
		if (sides.size() == 3) {
			size1 = getSide(sides,0);
			size2 = getSide(sides,1);
			size3 = getSide(sides,2);
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

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append( System.getProperty( "line.separator" ) );
		strBuilder.append( "Triangule sides:" );
		strBuilder.append( System.getProperty( "line.separator" ) );
		strBuilder.append("Side 1: " + size1);
		strBuilder.append( System.getProperty( "line.separator" ) );
		strBuilder.append("Side 2: " + size2);
		strBuilder.append( System.getProperty( "line.separator" ) );
		strBuilder.append("Side 3: " + size3);
		strBuilder.append( System.getProperty( "line.separator" ) );

		strBuilder.append( System.getProperty( "line.separator" ) );
		strBuilder.append( "Triangule Type:" );
		strBuilder.append( System.getProperty( "line.separator" ) );
		strBuilder.append( this.type );
		
		return strBuilder.toString();

	}
	
	private Double getSide(List<Double> sides, int index){
		if(sides.get(index) < 0){
			throw new IllegalStateException("A side must be greater than zero");
		} else {
			return sides.get(index);
		}
	}
	
	static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
