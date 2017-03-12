package ru.javawebinar.votingsystem.repository.datajpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.javawebinar.votingsystem.model.Restaurant;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by smac on 12.03.17.
 */
@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring-db.xml"
})
@RunWith(SpringJUnit4ClassRunner.class)
/*@ActiveProfiles(resolver = ActiveDbProfileResolver.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))*/
//@Sql(config = @SqlConfig(encoding = "UTF-8"))
public class CrudRestaurantRepoTest {

    private static final Logger LOG = LoggerFactory.getLogger(CrudRestaurantRepoTest.class);

    @Autowired
    private CrudRestaurantRepo restaurantRepo;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testAny() {
        List<Restaurant> lr = restaurantRepo.findAll();
        restaurantRepo.findRestaurantsById(1);
        lr.forEach(restaurant -> LOG.info(restaurant.toString()));
    }

}