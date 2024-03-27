package com.ppp;
public class Dog extends Pet {
	private String dogBreed;

    public Dog(String name, int age, String breed, String dogBreed) {
        super(name, age, breed, "DOG");
        this.dogBreed = dogBreed;
    }

}
