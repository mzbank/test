package job.service.impl;

import job.JobApplication;
import job.PageHelper.service.PageSerV;
import job.dao.UserMapper;
import job.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JobApplication.class)
public class UserServiceImplTest {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private PageSerV service;

    @Test
    public void findByName() {

        List<User> users = service.findByName(2,3);
        System.out.println(users);
    }

    @Test
    public void findByName1() {


    }
}