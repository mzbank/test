package job.PageHelper.service;

import com.github.pagehelper.PageHelper;
import job.PageHelper.PageBean;
import job.dao.UserMapper;
import job.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageHelperServ implements PageSerV {

    @Autowired
    private UserMapper mapper;

    @Override
    public List<User> findByName(int currentPage, int pageSize) {

        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);

        List<User> users = mapper.findByName();//所有用户信息
        int userNum = mapper.countUsers();//总用户数
        PageBean<User> pageDate = new PageBean<>(currentPage, pageSize, userNum);
        pageDate.setItems(users);
        return pageDate.getItems();
    }
}
