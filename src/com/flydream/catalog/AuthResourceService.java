/*
 * @(#)AuthResourceService 2015/10/17
 */
package com.flydream.catalog;

import com.avatar.gdk.util.DateUtils;
import com.flydream.common.Page;
import com.flydream.common.ZTreeNode;
import com.flydream.usr.UserBean;
import org.apache.commons.collections.MapUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @version 2015/10/17
 * @see
 * @since 1.0
 */
public class AuthResourceService {

    private static final int MAX_PAGE_NO = 999999;

    private AuthResourceDAO dao = AuthResourceDAO.getInstance();

    public Page getAllCount(AuthResource resource) {
        Page page =new Page();
        page.setPageSize(MAX_PAGE_NO);
        return page;
    }

    public List<AuthResource> getResourceList(Page page, AuthResource resource) {
        page.setPageNo(MAX_PAGE_NO);
        return dao.getResources(page,resource);
    }

    public List<Map<String, Object>> ajaxParentInfo() {
        return dao.getParentInfo();
    }

    public boolean save(AuthResource resource) {
        resource.setId(Integer.valueOf(String.valueOf(DateUtils.getCurrentLongTime())));
        return dao.insertOne(resource);
    }

    /**
     * 根据部门id获取部门的信息
     * @param deptId
     * @return
     */
    public List<ZTreeNode> getResourceAndDept(int deptId) {
        List<Map<String,Object>> resourceList = dao.queryResourceByDeptId(deptId);
        List<ZTreeNode> list = new ArrayList<>();
        for(Map<String,Object> map : resourceList){
            int id = MapUtils.getInteger(map,"id");
            int parentId = MapUtils.getInteger(map,"parentid");
            String name = MapUtils.getString(map, "label");
            int roleid = MapUtils.getInteger(map, "roleid",-1);

            ZTreeNode zTreeNode = new ZTreeNode();
            zTreeNode.setId(id);
            zTreeNode.setpId(parentId);
            zTreeNode.setName(name);
            if(roleid!=-1){
                zTreeNode.setChecked(true);
            }
            list.add(zTreeNode);
        }
        return list;
    }
}
