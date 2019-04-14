package me.xiaoyuu.datastructure.dao;

import me.xiaoyuu.datastructure.entity.Attraction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class AttractionDaoTest {

    @Autowired
    AttractionDao attractionDao;
    @Test
    public void insertTest(){
        Attraction attraction = new Attraction(0,"A","this is a introduction");
        attractionDao.addAttraction(attraction);
    }


}