package me.xiaoyuu.datastructure.service;

import me.xiaoyuu.datastructure.dao.AttractionDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class DataBaseServiceTest {

    @Autowired
    AttractionDao attractionDao;

    @Test
    public void test(){
        System.out.println(attractionDao.getAll());
    }
}