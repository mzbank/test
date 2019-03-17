package job.dao;

import job.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> findByName();

    void addUser(@Param("users") List<User> users);

    Integer countUsers();
}
