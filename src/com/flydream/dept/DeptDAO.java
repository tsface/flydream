/*
 * @(#)DeptDAO 2015/10/11
 */
package com.flydream.dept;

import com.avatar.db.DBFactory;
import com.avatar.db.jdbc.JdbcHandler;
import com.flydream.common.Constant;
import com.flydream.common.Page;
import com.flydream.usr.UserBean;

import java.util.List;

/**
 * @author liyan
 * @version 2015/10/11
 * @see
 * @since 1.0
 */
public class DeptDAO {

    private JdbcHandler jdbcHandler = DBFactory.create(Constant.DATABASE_PLATFORM);

    private DeptDAO(){}

    public int getCount(DeptBean dept) {
        String sql = "SELECT count(*) FROM peak_user WHERE 1=1 "+sqlWhere(dept)+"order by username desc";
        return jdbcHandler.queryForInteger(sql);
    }

    /**
     * 根据删除用户
     * @param id
     * @return
     */
    public boolean deleteById(Integer... id){
        String sql = "DELETE FROM peak_auth_dept WHERE id in (?)";
        return jdbcHandler.execute(sql, id);
    }


    private static final class SingleHolder{
        static DeptDAO INSTANCE = new DeptDAO();
    }

    public static DeptDAO getInstance(){
        return SingleHolder.INSTANCE;
    }

    /**
     * 插入一条数据
     * @param dept
     * @return
     */
    public boolean insertOne(DeptBean dept){
        String sql = "INSERT INTO peak_auth_dept(id,parentdeptid,deptcode,deptname,deptdesc,flag,creator) VALUE (?,?,?,?,?,?,?)";
        return jdbcHandler.execute(sql, dept.getId(),dept.getParentdeptid(),dept.getDeptcode(),dept.getDeptname(),dept.getDeptdesc(),dept.getFlag(),dept.getCreator());
    }

    /**
     * 分页查询获取所有的user对象
     * @param page
     * @param dept
     * @return
     */
    public List<DeptBean> getDept(Page page, DeptBean dept) {
        String sql = "SELECT * FROM peak_auth_dept WHERE 1=1 order by id desc";
        if(null == page){
            return jdbcHandler.queryForList(DeptBean.class,sql);
        }
        return jdbcHandler.queryForPageList(DeptBean.class, sql, page.getPageNo(), page.getPageSize());
    }

    private String sqlWhere(DeptBean dept) {
        return " ";
    }
}
