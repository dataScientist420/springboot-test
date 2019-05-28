package com.javabrains.springbootquickstart.superhero.runner;

import com.javabrains.springbootquickstart.superhero.Model.Superhero;
import com.javabrains.springbootquickstart.superhero.service.SuperheroService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Component
public class SuperheroRunner implements CommandLineRunner {

    @Autowired
    private SuperheroService heroService;

    @Transactional
    @Override
    public void run(String ... strings) throws Exception {

        try {
            Superhero hero1 = new Superhero("Vlad", "Dracula", 1000);
            Superhero hero2 = new Superhero("Batman", "Bruce Wayne", 32);
            heroService.insert(Arrays.asList(hero1, hero2));
            heroService.getSuperheroes();
        } catch (RuntimeException e) {
            System.out.println("Transaction exception: " + e.getMessage());
        }
        System.out.println(heroService.getSuperheroes());
    }
}
