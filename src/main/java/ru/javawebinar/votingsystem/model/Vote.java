package ru.javawebinar.votingsystem.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by smac on 05.03.17.
 */
@Entity
@Table(name = "votes",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"user", "date"}, name = "votes_unique_date_user_idx")})
public class Vote extends BaseEntity {

    @Column(name = "date")
    @NotNull
    private Date date;

    @CollectionTable(name = "users", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "user")
    @ElementCollection(fetch = FetchType.EAGER)
    private User user;

    @CollectionTable(name = "restaurant", joinColumns = @JoinColumn(name = "restaurant_id"))
    @Column(name = "restaurant")
    @ElementCollection(fetch = FetchType.EAGER)
    private Restaurant restaurant;

    public Vote(Integer id, Date date, User user, Restaurant restaurant) {
        super(id);
        this.date = date;
        this.user = user;
        this.restaurant = restaurant;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
