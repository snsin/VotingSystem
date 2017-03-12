package ru.javawebinar.votingsystem.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javawebinar.votingsystem.model.Restaurant;

import java.util.List;

/**
 * Created by smac on 12.03.17.
 */
public interface CrudRestaurantRepo extends JpaRepository<Restaurant, Integer> {
    public List<Restaurant> findRestaurantsById(Integer id);
}

