package job.dao.mapper;

import job.JobApplication;
import job.dao.UserMapper;
import job.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JobApplication.class)
public class InsertBatchSave {

    @Autowired
    private UserMapper mapper;

    @Test
    public void insertBatchSave(){
        List<User> users = new ArrayList<User>();
        users.add(new User(6,"zs","232kldjf"));
        users.add(new User(7,"zss","232kldjf"));
        users.add(new User(8,"zsss","232kldjf"));
        users.add(new User(9,"zssss","232kldjf"));
        mapper.addUser(users);
    }
    @Test
    public void findUser(){
        List<User> users = mapper.findByName();
        System.out.println(users);
    }
}
