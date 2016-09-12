package com.triangule.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.triangule.model.Triangule;


public class App {

	public static void main(String[] args) {
		Triangule triangule = new Triangule();
		TrianguleController controller = new TrianguleController();
		String input;
		List<BigDecimal> sides = new ArrayList<BigDecimal>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the first side: ");
		input = sc.nextLine();
		
		while (!isBigDecimal(input) || new BigDecimal(input).compareTo(BigDecimal.ZERO) < 1) {
			System.out.println("Please enter a valid first side: ");
			input = sc.nextLine();

		}
		sides.add(new BigDecimal(input));

		System.out.println("Enter the second side: ");
		input = sc.nextLine();
		
		while (!isBigDecimal(input) || new BigDecimal(input).compareTo(BigDecimal.ZERO) < 1 ) {
			System.out.println("Please enter a valid second side: ");
			input = sc.nextLine();
		}
		sides.add(new BigDecimal(input));

		System.out.println("Enter the third side: ");
		input = sc.nextLine();
		
		while (!isBigDecimal(input) || new BigDecimal(input).compareTo(BigDecimal.ZERO) < 1) {
			System.out.println("Please enter a valid second side: ");
			input = sc.nextLine();
		}
		sides.add(new BigDecimal(input));

		try {
			triangule.setSides(sides);
			controller.calculateType(triangule);
			System.out.println(triangule.toString());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		sc.close();
	}
	
	  static boolean isBigDecimal(String str) {
	        try {
	            new BigDecimal(str);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }

}
