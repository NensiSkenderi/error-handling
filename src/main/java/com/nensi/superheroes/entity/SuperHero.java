package com.nensi.superheroes.entity;

import javax.validation.constraints.NotBlank;

public class SuperHero {

    @NotBlank
    private String firstName;
    private String lastName;
    @NotBlank
    private String heroName;

    // Empty constructor is needed for Jackson to recreate the object from JSON
    public SuperHero() {
    }

    public SuperHero(String firstName, String lastName, String heroName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heroName = heroName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHeroName() {
        return heroName;
    }
}
