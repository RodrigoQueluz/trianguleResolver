package com.triangule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.triangule.model.Triangule;
import com.triangule.model.TrianguleTypes;

@Controller
public class TrianguleController {

	@RequestMapping("/home")
	public String form() {
		return "home";
	}

	@RequestMapping(value = "/triangule", method = RequestMethod.POST)
	public void calculateType(Triangule triangule) {
		double size1 = triangule.getSides().get(0);
		double size2 = triangule.getSides().get(1);
		double size3 = triangule.getSides().get(2);

		if (size1 == size2 && size1 == size3) {
			triangule.setType(TrianguleTypes.EQUILATERAL);
		} else if (size1 == size2 || size1 == size3) {
			triangule.setType(TrianguleTypes.ISOSCELES);
		} else
			triangule.setType(TrianguleTypes.SCALENE);
	}

}
