/*
 * @(#)UserService.java 2015年6月1日
 */
package com.flydream.usr;

import java.util.List;

import com.avatar.gdk.util.DateUtils;
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

	public Page getAllCount(UserBean user){
		Page page =new Page();
		page.setPageSize(10);
		page.setTotalRows(dao.getCount(user));
		return page;
	}

	/**
	 * 保存一个User对象到数据库中
	 * @param user
	 * @return
	 */
	public boolean save(UserBean user) {
		if(null!=user){
			user.setCreateTime(DateUtils.getCurrentLongTime());
			user.setId(Integer.valueOf(String.valueOf(DateUtils.getCurrentLongTime())));
			return dao.insertOne(user);
		}
		return false;
	}

	/**
	 * 根据ids批量删除数据
	 * @param ids
	 * @return
	 */
	public boolean deleteById(Integer... ids) {
		return dao.deleteById(ids);
	}

	/**
	 * 批量更新状态
	 * @param idses
	 * @return
	 */
	public boolean updateByIds(Integer[] ids,boolean isStart) {

		return dao.updateStatusByIds(ids,isStart);
	}
}
