package com.nensi.superheroes.repository;

import com.nensi.superheroes.entity.SuperHero;
import com.nensi.superheroes.exception.NonExistingHeroException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SuperHeroRepositoryImpl implements SuperHeroRepository{

    private List<SuperHero> superHeroList;

    public SuperHeroRepositoryImpl() {
        superHeroList = new ArrayList<>();
        superHeroList.add(new SuperHero("Jean", "Grey", "Phoenix"));
        superHeroList.add(new SuperHero("Bruce", "Wayne", "Batman"));
        superHeroList.add(new SuperHero("Susan", "Storm", "Invisible woman"));
        superHeroList.add(new SuperHero("Peter", "Parker", "Spiderman"));
    }

    @Override
    public SuperHero getSuperHero(int id) {
        if (id > superHeroList.size()) throw new
                NonExistingHeroException("Sorry, there are only 4 superheroes...");
        return superHeroList.get(id - 1);
    }

    @Override
    public Optional<SuperHero> getSuperHero(String heroName) {
        return superHeroList.stream().filter(h -> h.getHeroName().equals(heroName)).findAny();
    }

    @Override
    public void saveSuperHero(SuperHero superHero) {
        superHeroList.add(superHero);
    }
}
