package me.xiaoyuu.datastructure.serviceImpl;

import me.xiaoyuu.datastructure.service.AlgorithmService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class AlgorithmServiceImplTest {
    @Autowired
    AlgorithmService algorithmService;

    @Test
    public void getNavigationMethods() {
       algorithmService.getNavigationMethods(0);
    }

    @Test
    public void prim() {
       algorithmService.prim();
    }

    @Test
    public void getGraph() {
    }

    @Test
    public void getShortestPath() {
        System.out.println(algorithmService.getShortestPath(0,4));
    }

    @Test
    public void getShortestPath1() {
    }

    @Test
    public void prim1() {
    }
}