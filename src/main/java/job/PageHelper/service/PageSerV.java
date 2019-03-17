package job.PageHelper.service;

import job.pojo.User;

import java.util.List;

public interface PageSerV {

    List<User> findByName(int currentPage, int pageSize);
}
