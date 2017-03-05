package ru.javawebinar.votingsystem.model;

import javax.persistence.*;
import java.util.Set;
import java.util.TimeZone;

/**
 * Created by smac on 10.01.17.
 */
@Table(name = "restaurants")
public class Restaurant extends NamedEntity {

    @Column(name = "time_zone")
    TimeZone timeZone;

    @CollectionTable(name = "dishes", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "menu_of_the_day")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Dish> menuOfTheDay;

    public Restaurant(Integer id, String name, TimeZone timeZone, Set<Dish> menuOfTheDay) {
        super(id, name);
        this.timeZone = timeZone;
        this.menuOfTheDay = menuOfTheDay;
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

