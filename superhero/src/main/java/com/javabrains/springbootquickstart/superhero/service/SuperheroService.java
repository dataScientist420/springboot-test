package com.javabrains.springbootquickstart.superhero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import com.javabrains.springbootquickstart.superhero.Model.Superhero;
import java.sql.PreparedStatement;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class SuperheroService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insert(List<Superhero> superheroes) {
        for (Superhero hero: superheroes) {
            System.out.println("Inserting data for superhero name:" + hero.getName());

            jdbcTemplate.update("insert into superheroes(name, description, age) values (?, ?, ?)",
                    preparedStatement -> {
                        preparedStatement.setString(1, hero.getName());
                        preparedStatement.setString(2, hero.getDescription());
                        preparedStatement.setInt(3, hero.getAge());
                    });
        }
    }

    public List<Superhero> getSuperheroes() {
        System.out.println("Retrieve all superheroes ...");

        List<Superhero> heroes = jdbcTemplate.query("select name, description, age from superheroes",
                (resultSet, i) -> new Superhero(resultSet.getString("name"),
                                                resultSet.getString("description"),
                                                resultSet.getInt("age")));
        return heroes;
    }
}
