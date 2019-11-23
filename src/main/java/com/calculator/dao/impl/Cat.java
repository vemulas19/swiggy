package com.calculator.dao.impl;

public class Cat implements IAnimal {// assume this is jdbc implementation

	public void getNoice() {
		System.out.println("Meaw!! Meaw!!");
	}

	public void getLegs() {
		System.out.println("4 Legs!!");
	}

	public void database() {
		System.out.println("jdbc flow");
	}
}
