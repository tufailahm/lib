package com.training.cms;

public class Calculator {

	public Calculator() {
	}
	public int addNumbers(int num1,int num2) {
		return num1+num2;
	}
	public int addNumbers(int num1,String num2) {
		return num1+Integer.parseInt(num2);		//eight 	 - NumberFormatException
	}
	public int div(int num1,int num2) {
		return num1/num2;		//10/0 	 - ArithmeticException
	}
}
