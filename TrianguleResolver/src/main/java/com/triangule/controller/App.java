package com.triangule.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.triangule.model.Triangule;


public class App {

	public static void main(String[] args) {
		Triangule triangule = new Triangule();
		TrianguleController controller = new TrianguleController();
		String input;
		List<Double> sides = new ArrayList<Double>();
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter the first side: ");
		input = sc.nextLine();
		
		while (!isDouble(input) || Double.parseDouble(input) < 0) {
			System.out.println("Please enter a valid first side: ");
			input = sc.nextLine();

		}
		sides.add(Double.parseDouble(input));

		System.out.println("Enter the second side: ");
		input = sc.nextLine();
		
		while (!isDouble(input) || Double.parseDouble(input) < 0) {
			System.out.println("Please enter a valid second side: ");
			input = sc.nextLine();
		}
		sides.add(Double.parseDouble(input));

		System.out.println("Enter the third side: ");
		input = sc.nextLine();
		
		while (!isDouble(input) || Double.parseDouble(input) < 0) {
			System.out.println("Please enter a valid second side: ");
			input = sc.nextLine();
		}
		sides.add(Double.parseDouble(input));

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
	
	  static boolean isDouble(String str) {
	        try {
	            Double.parseDouble(str);
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }

}
