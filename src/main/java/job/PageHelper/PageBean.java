package job.PageHelper;

import lombok.Data;

import java.util.List;

//分页实体
@Data
public class PageBean<T> {

    private Integer currentPage;//当前页

    private Integer pageSize;//每页显示总条数

    private Integer totalNum ;//总条数

    private Integer isMore;//是否有下一页

    private Integer totalPage;//总页数

    private Integer startIndex;//索引起始页

    private List<T> items;//分页结果

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum, Integer isMore, Integer totalPage, Integer startIndex) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.isMore = isMore;
        this.totalPage = totalPage;
        this.startIndex = startIndex;
    }

    public PageBean(Integer currentPage, Integer pageSize, Integer totalNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
    }
}
