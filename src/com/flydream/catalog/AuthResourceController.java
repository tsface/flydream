/*
 * @(#)AuthResourceController 2015/10/17
 */
package com.flydream.catalog;

import com.flydream.common.Page;
import com.flydream.common.ZTreeNode;
import com.flydream.util.PageUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @version 2015/10/17
 * @see
 * @since 1.0
 */
@Controller
@RequestMapping("/authresource")
public class AuthResourceController {

    AuthResourceService service = new AuthResourceService();
    /**
     * 主页面
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("page",service.getAllCount(new AuthResource()));
        return "authresource/list";
    }


    /**
     * 分页获取数据
     * @param page
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public @ResponseBody List<AuthResource> list(@RequestBody Page page){
        if (null == page){
            page = PageUtils.createDefaultPage();
        }
        //model.addAttribute("page",page);
        //model.addAttribute("list");
        return service.getResourceList(page, new AuthResource());
    }

    /**
     * 分页获取数据
     */
    @RequestMapping(value = "/parentinfo", method = RequestMethod.POST, produces="application/json")
    public @ResponseBody List<Map<String,Object>> ajaxParentInfo(){
        //model.addAttribute("page",page);
        //model.addAttribute("list");
        return service.ajaxParentInfo();
    }

    /**
     * 添加一个用户
     * @param resource
     * @return
     */
    @RequestMapping(value = "/asynadd" , method = RequestMethod.POST, produces="application/json")
    public @ResponseBody boolean ajaxAddAuthResource(@RequestBody AuthResource resource){
        return service.save(resource);
    }

    /**
     * 分页获取数据
     */
    @RequestMapping(value = "/asyauthinfo", method = RequestMethod.POST, produces="application/json")
    public @ResponseBody List<ZTreeNode> getResourceAndDept(HttpServletRequest request){
        //model.addAttribute("page",page);
        //model.addAttribute("list");
        String deptId = StringUtils.isNotEmpty(request.getParameter("deptId")) ? request.getParameter("deptId") : "0";
        return service.getResourceAndDept(Integer.parseInt(deptId));
    }

    /**
     * 跳转到授权主页
     * @return
     */
    @RequestMapping("/auth")
    public String auth(Model model){
        return "authresource/authresources";
    }

    /**
     * 跳转到授权主页
     * @return
     */
    @RequestMapping("/authdetail/{id}")
    public String authDetail(@PathVariable Integer id,Model model){
        model.addAttribute("deptId",id);
        return "authresource/authdetail";
    }

}
