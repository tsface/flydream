/*
 * @(#)DeptController 2015/10/11
 */
package com.flydream.dept;

import com.flydream.common.Page;
import com.flydream.usr.UserBean;
import com.flydream.usr.UserService;
import com.flydream.util.PageUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author liyan
 * @version 2015/10/11
 * @since 1.0
 */
@Controller
@RequestMapping("/dept")
public class DeptController {

    private DeptService service = new DeptService() ;
    /**
     * 主页面
     * @return
     */
    @RequestMapping("/index")
    public String index(Model model){
        model.addAttribute("page",service.getAllCount(new DeptBean()));
        return "dept/list";
    }

    /**
     * 分页获取数据
     * @param page
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
    public @ResponseBody
    List<DeptBean> list(@RequestBody Page page){
        if (null == page){
            page = PageUtils.createDefaultPage();
        }
        //model.addAttribute("page",page);
        //model.addAttribute("list");
        return service.getDeptList(page, new DeptBean());
    }

    /**
     * 添加一个用户
     * @param dept
     * @return
     */
    @RequestMapping(value = "/asynadd" , method = RequestMethod.POST, produces="application/json")
    public @ResponseBody boolean ajaxAddUser(@RequestBody DeptBean dept){
        return service.save(dept);
    }


    /**
     * 批量删除数据
     * @param ids
     * @return
     */
    @RequestMapping(value="deleteBatch", method = RequestMethod.POST, produces="application/json")
    public @ResponseBody boolean ajaxDeleteBatch(@RequestBody Map<String,List<Integer>> ids){
        return service.deleteById(ids.get("ids").toArray(new Integer[]{}));
    }
}
