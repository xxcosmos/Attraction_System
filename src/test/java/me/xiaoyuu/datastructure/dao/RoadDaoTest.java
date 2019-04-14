package me.xiaoyuu.datastructure.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class RoadDaoTest {
    @Autowired
    RoadDao roadDao;
    @Test
    public void test1(){
        System.out.println(roadDao.getRoadByAttractionId(1,0));
    }
}