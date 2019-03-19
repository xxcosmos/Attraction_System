package me.xiaoyuu.datastructure.serviceImpl;

import me.xiaoyuu.datastructure.service.FileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class FileServiceImplTest {

    @Autowired
    FileService fileService;
    @Test
    public void uploadFile() {
    }


}