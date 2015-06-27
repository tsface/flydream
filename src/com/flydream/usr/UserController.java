/*
 * @(#)UserController.java 2015/6/1
 */
package com.flydream.usr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.flydream.common.Page;

/**
 * 
 * @author liyan
 * @version  2015/6/1
 * @since 1.0
 * @see
 */

@Controller
@RequestMapping("/user")
public class UserController {
	
	private UserService service ;
	
	@RequestMapping("/list")
	public String list(Page page,UserBean user,Model model){
		model.addAttribute(page);
		model.addAttribute(service.getUserList(page, user));
		return "index";
	}

}
