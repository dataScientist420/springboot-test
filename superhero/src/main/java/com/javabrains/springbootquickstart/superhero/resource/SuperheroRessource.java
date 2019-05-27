package com.javabrains.springbootquickstart.superhero.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/rest/superhero")
public class SuperheroRessource {

    /*
    @GetMapping
    public List<Superhero> getSuperheroes() {
        return Arrays.asList(
                new Superhero("test", "test", 0, 0, 0),
                new Superhero("test", "test", 0, 0, 0));
    }*/

    @GetMapping("/{superhero}")
    public Superhero getSuperhero(@PathVariable("superhero") final String shero) {
        return new Superhero("test", "test", 0,0, 0);
    }

    private class Superhero {
        private String name, description;
        private int age, height, weight;

        public Superhero(String name, String description, int age, int height, int weight) {
            this.name = name;
            this.description = description;
            this.age = age;
            this.height = height;
            this.weight = weight;
        }

        public String getName() { return this.name; }
        public String getDescription() { return this.description; }
        public int getAge() { return this.age; }
        public int getHeight() { return this.height; }
        public int getWeight() { return this.weight; }

        public void setName(String name) { this.name = name; }
        public void setDescription(String description) { this.description = description; }
        public void setAge(int age) { this.age = age; }
        public void setHeight(int height) { this.height = height; }
        public void setWeight(int weight) { this.weight = weight; }
    }
}
