package com.method;

import org.springframework.stereotype.Component;

@Component("mathutil")
public class MathUtil {

	public MathUtil() {
		// TODO Auto-generated constructor stub
	}
	public int getLength() {
		return 666;
	}
	public double getArea(int r) {
		return Math.PI*r*r;
	}

}
