/*
 * @(#)AuthResourceDAO 2015/10/17
 */
package com.flydream.catalog;

import com.avatar.db.DBFactory;
import com.avatar.db.jdbc.JdbcHandler;
import com.flydream.common.Constant;
import com.flydream.common.Page;

import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @version 2015/10/17
 * @see
 * @since 1.0
 */
public class AuthResourceDAO {

    /**
     * jdbc handler
     */
    private JdbcHandler jdbcHandler = DBFactory.create(Constant.DATABASE_PLATFORM);

    private AuthResourceDAO() {
    }

    private static final class SingleHolder {
        static AuthResourceDAO INSTANCE = new AuthResourceDAO();
    }

    public static AuthResourceDAO getInstance() {
        return SingleHolder.INSTANCE;
    }


    /**
     * 插入一条数据
     *
     * @param resource
     * @return
     */
    public boolean insertOne(AuthResource resource) {
        String sql = "INSERT INTO peak_auth_resources(id,parentid,resourcename,label,description,url,moduleid,resourcetype,image,bigimage,sortorder,state) VALUE (?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbcHandler.execute(sql, resource.getId(), resource.getParentid(), resource.getResourcename(), resource.getLabel(),
                resource.getDescription(), resource.getUrl(), resource.getModuleid(), resource.getResourcetype(),
                resource.getImage(), resource.getBigimage(), resource.getSortorder(), resource.getState());
    }

    /**
     * 分页查询获取所有的user对象
     *
     * @param page
     * @param resource
     * @return
     */
    public List<AuthResource> getResources(Page page, AuthResource resource) {
        String sql = "select t1.* , t2.label as parentname from peak_auth_resources t1,(SELECT distinct parentid, label from peak_auth_resources) t2 where t1.parentid = t2.parentid";
        return jdbcHandler.queryForPageList(AuthResource.class, sql, page.getPageNo(), page.getPageSize());
    }

    public List<Map<String, Object>> getParentInfo() {
        String sql = "select t1.parentid , t2.label as parentname from peak_auth_resources t1,(SELECT distinct parentid, label from peak_auth_resources) t2 where t1.parentid = t2.parentid";
        return jdbcHandler.queryForList(sql);
    }

    public List<Map<String, Object>> queryResourceByDeptId(int deptId) {
        String sql = "SELECT * from (select t1.* , t2.label as parentname from peak_auth_resources t1,(SELECT distinct parentid , label from peak_auth_resources) t2 where t1.parentid = t2.parentid) AS tab1 " +
                " LEFT JOIN (select resourceid,roleid from peak_auth_resourceauth where roleid = ?) AS tab2 ON tab1.id = tab2.resourceid";

        return jdbcHandler.queryForList(sql,deptId);


    }

}
