package com.ppp;

public class Pet {
	private int id;
    private String name;
    private int age;
    private String breed;
    private String type;

    public Pet(String name, int age, String breed, String type) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.type = type;
    }
    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", breed='" + breed + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
