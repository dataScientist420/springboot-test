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
                                  @PathVariable("superhero age") final int age) {
        return new Superhero(name, description, age);
    }

    private class Superhero {

        @ApiModelProperty(notes = "name of the superhero")
        private String name;

        @ApiModelProperty(notes = "description of the superhero")
        private String description;

        @ApiModelProperty(notes = "age of the superhero")
        private int age;

        public Superhero(String name, String description, int age) {
            this.name = name;
            this.description = description;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
