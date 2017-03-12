package ru.javawebinar.votingsystem.model;

import javax.persistence.*;
import java.util.Set;
import java.util.TimeZone;

/**
 * Created by smac on 10.01.17.
 */
@Entity
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {

    @Column(name = "time_zone")
    TimeZone timeZone;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
    private Set<Dish> menuOfTheDay;

    public Restaurant(Integer id, String name, TimeZone timeZone, Set<Dish> menuOfTheDay) {
        super(id, name);
        this.timeZone = timeZone;
        this.menuOfTheDay = menuOfTheDay;
    }

    public Restaurant(TimeZone timeZone, Set<Dish> menuOfTheDay) {
        this.timeZone = timeZone;
        this.menuOfTheDay = menuOfTheDay;
    }

    public Restaurant() {
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Set<Dish> getMenuOfTheDay() {
        return menuOfTheDay;
    }

    public void setMenuOfTheDay(Set<Dish> menuOfTheDay) {
        this.menuOfTheDay = menuOfTheDay;
    }


}

