package com.javabrains.springbootquickstart.superhero.Model;

public class Superhero {

    private String name;
    private String description;
    private int age;

    public Superhero(String name, String description, int age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Superhero{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", age=" + age +
                '}';
    }
}
