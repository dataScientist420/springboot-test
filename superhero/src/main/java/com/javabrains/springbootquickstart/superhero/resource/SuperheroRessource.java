package com.javabrains.springbootquickstart.superhero.resource;

import java.util.*;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/rest/superheroes")
public class SuperheroRessource {

    private List<Superhero> superheroes;

    @GetMapping("/all")
    public List<Superhero> getSuperheroes() {
        return this.superheroes;
    }

    @GetMapping("/add")
    public void addSuperhero(Superhero hero) {
        this.superheroes.add(hero);
    }

    @GetMapping("/{superhero}")
    public Superhero getSuperhero(@PathVariable("superhero name") final String name,
                                  @PathVariable("superhero description") final String description,
                                  @PathVariable("superhero age") final int age,
                                  @PathVariable("superhero height") final int height,
                                  @PathVariable("superhero weight") final int weight) {
        return new Superhero(name, description, age, height, weight);
    }

    private class Superhero {

        @ApiModelProperty(notes = "name of the superhero")
        private String name;

        @ApiModelProperty(notes = "description of the superhero")
        private String description;

        @ApiModelProperty(notes = "age of the superhero")
        private int age;

        @ApiModelProperty(notes = "height of the superhero")
        private int height;

        @ApiModelProperty(notes = "weight of the superhero")
        private int weight;

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
