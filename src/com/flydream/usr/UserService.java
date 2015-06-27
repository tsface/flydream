/*
 * @(#)UserService.java 2015年6月1日
 */
package com.flydream.usr;

import java.util.List;

import com.flydream.common.Page;


/**
 * 
 * @author liyan
 * @version  2015年6月1日
 * @since 1.0
 * @see
 */
public class UserService {
	
	private UserDAO dao = UserDAO.getInstance();
	
	/**
	 * 查询获取所有的用户对象 分页查询
	 * @param page
	 * @param user
	 * @return
	 */
	public List<UserBean> getUserList(Page page,UserBean user){
		return dao.getUsers(page,user);
	}
	
}
