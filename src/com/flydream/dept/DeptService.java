/*
 * @(#)DeptService 2015/10/11
 */
package com.flydream.dept;

import com.avatar.gdk.util.DateUtils;
import com.flydream.common.Page;

import java.util.List;

/**
 * @author liyan
 * @version 2015/10/11
 * @since 1.0
 */
public class DeptService {

    private DeptDAO dao = DeptDAO.getInstance();

    /**
     * @param dept
     * @return
     */
    public boolean save(DeptBean dept) {
        if(null!=dept){
            dept.setId(Integer.valueOf(String.valueOf(DateUtils.getCurrentLongTime())));
            return dao.insertOne(dept);
        }
        return false;
    }

    public Page getAllCount(DeptBean dept){
        Page page =new Page();
        page.setPageSize(10);
        page.setTotalRows(dao.getCount(dept));
        return page;
    }


    /**
     * @param page
     * @param dept
     * @return
     */
    public List<DeptBean> getDeptList(Page page,DeptBean dept){
        return dao.getDept(page, dept);
    }


    /**
     * 根据ids批量删除数据
     * @param ids
     * @return
     */
    public boolean deleteById(Integer... ids) {
        return dao.deleteById(ids);
    }
}
