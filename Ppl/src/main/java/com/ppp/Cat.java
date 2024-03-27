package com.ppp;
public class Cat extends Pet{
	private String catColor;

    public Cat(String name, int age, String breed, String catColor) {
        super(name, age, breed, "CAT");
        this.catColor = catColor;
    }

}
