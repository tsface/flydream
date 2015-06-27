/*
 * @(#)UserDao.java 2015/6/1
 */
package com.flydream.usr;

import java.util.List;

import com.avatar.db.DBFactory;
import com.avatar.db.jdbc.JdbcHandler;
import com.flydream.common.Constant;
import com.flydream.common.Page;

/**
 * User persistent
 * @author liyan
 * @version  2015/6/1
 * @since 1.0
 */
public class UserDAO{
	
	/**
	 * jdbc handler
	 */
	private JdbcHandler jdbcHandler = DBFactory.create(Constant.DATABASE_PLATFORM);
	
	
	
	private UserDAO(){}
	
	private static class SingleHolder{
		static UserDAO INSTANCE = new UserDAO();
	}
	
	/**
	 * 获取平台库操作实例
	 */
	public static final UserDAO getInstance(){
		return SingleHolder.INSTANCE;
	}
	
	/**
	 * 插入一条数据
	 * @param user
	 * @return
	 */
	public boolean insertOne(UserBean user){
		String sql = "INSERT INTO peak_user(id,username,password,realname,gender,avatar1,avatar2,avatar3,status,lastlogintime,loginip,loginmac,createtime,usertype,deadline) VALUE (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		return jdbcHandler.execute(sql, user.getId(),user.getUserName(),user.getPassWord(),
				user.getRealName(),user.getGender(),user.getAvatar1(),user.getAvatar2(),user.getAvatar3(),
				user.getStatus(),user.getLastLoginTime(),user.getLoginIp(),user.getLoginMac(),user.getCreateTime(),
				user.getUserType(),user.getDeadLine());
	}
	
	
	/**
	 * 根据删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteOneById(String id){
		String sql = "DELETE FROM peak_user WHERE id = ?";
		return jdbcHandler.execute(sql, Integer.valueOf(id));
	}
	
	/**
	 * 根据用户id查询获取用户对象
	 * @param id
	 * @return
	 */
	public UserBean getUserById(String id){
		String sql = "SELECT * FROM peak_user WHERE id = ?";
		return jdbcHandler.queryForBean(UserBean.class, sql,Integer.valueOf(id));
	}

	/**
	 * 分页查询获取所有的user对象
	 * @param page
	 * @param user
	 * @return
	 */
	public List<UserBean> getUsers(Page page,UserBean user) {
		String sql = "SELECT * FROM peak_user WHERE 1=1 order by username desc";
		return jdbcHandler.queryForPageList(UserBean.class, sql, page.getPageNo(),page.getPageSize());
	}
	
	

}
