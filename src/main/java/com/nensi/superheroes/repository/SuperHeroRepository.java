package com.nensi.superheroes.repository;

import com.nensi.superheroes.entity.SuperHero;

import java.util.Optional;

public interface SuperHeroRepository {

    /**
     * Retrieves a super hero by the id.
     * If the id does not exist, a {NonExistingHeroException} will be thrown.
     *
     * @param id the unique id of the super hero
     * @return the SuperHero details
     */
    SuperHero getSuperHero(int id);

    /**
     * Retrieves a super hero given his super hero alias.
     *
     * @param heroName the super hero name
     * @return the SuperHero details
     */
    Optional<SuperHero> getSuperHero(String heroName);

    /**
     * Saves the super hero.
     *
     * @param superHero the details of the super hero
     */
    void saveSuperHero(SuperHero superHero);
}
