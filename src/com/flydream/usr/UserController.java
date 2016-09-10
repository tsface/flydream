/*
 * @(#)UserController.java 2015/6/1
 */
package com.flydream.usr;

import com.flydream.dept.DeptBean;
import com.flydream.dept.DeptService;
import com.flydream.util.PageUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.flydream.common.Page;

import java.util.*;

/**
 * 用户管理Action单元
 *
 * @author liyan
 * @version  2015/6/1
 * @since 1.0
 * @see
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService service = new UserService() ;

	/**
	 * 主页面
	 * @return
	 */
	@RequestMapping("/index")
	public String index(Model model){
		model.addAttribute("page",service.getAllCount(new UserBean()));
		return "user/list";
	}

	/**
	 * 分页获取数据
	 * @param page
	 */
	@RequestMapping(value = "/list", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody List<UserBean> list(@RequestBody Page page){
		if (null == page){
			page = PageUtils.createDefaultPage();
		}
		//model.addAttribute("page",page);
		//model.addAttribute("list");
		return service.getUserList(page, new UserBean());
	}

	/**
	 * 获取部门信息
	 * @param page
	 */
	@RequestMapping(value = "/getDept", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody List<DeptBean> getAllDept(@RequestBody Page page){
		return new DeptService().getDeptList(null, new DeptBean());
	}


	/**
	 * 添加一个用户
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/asynadd" , method = RequestMethod.POST, produces="application/json")
	public @ResponseBody boolean ajaxAddUser(@RequestBody UserBean user){
		return service.save(user);
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


	/**
	 * 批量更新数据集合
	 * @param data
	 * @return
	 */
	@RequestMapping(value="updateBatch", method = RequestMethod.POST, produces="application/json")
	public @ResponseBody boolean ajaxUpdateBatch(@RequestBody HashMap<String,Object> data){
		List<Integer> list= (ArrayList<Integer>)data.get("data[ids]");
		return service.updateByIds(list.toArray(new Integer[]{}),(boolean)data.get("data[isStart]"));
	}

}
