package com.calculator.dao.impl;

public class Dog implements IAnimal {//assume this is hibernate implementation

	public void getNoice() {
		System.out.println("Bow!! Bow!!");
	}
	
	public void getLegs() {
		System.out.println("4 Legs!!");
	}

	public void database() {
		System.out.println("Hibernate");
	}
	
}
