/*
 * @(#)UserDao.java 2015/6/1
 */
package com.flydream.usr;

import java.util.ArrayList;
import java.util.List;

import com.avatar.db.DBFactory;
import com.avatar.db.jdbc.JdbcHandler;
import com.flydream.common.Constant;
import com.flydream.common.Page;
import org.apache.commons.lang.StringUtils;

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
		return jdbcHandler.batchUpdate(getBatchSQL(user)).isSuccess();

	}

	private String[] getBatchSQL(UserBean user){
		List<String> sqls = new ArrayList<>();
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO peak_user(id,username,password,realname,gender,avatar1,avatar2,avatar3,status,lastlogintime,loginip,loginmac,createtime,usertype,deadline) VALUE ");
		sql.append("(").append(user.getId()).append(" , '").append(user.getUserName()).append("','").append(user.getPassWord()).append("','");
		sql.append(user.getRealName()).append("',").append(user.getGender()).append(",'").append(user.getAvatar1()).append("','").append(user.getAvatar2()).append("','").append(user.getAvatar3()).append("',");
		sql.append(user.getStatus()).append(",").append(user.getLastLoginTime()).append(",'").append(user.getLoginIp()).append("',").append(user.getLoginMac()).append(",").append(user.getCreateTime());
		sql.append(",").append(user.getUserType()).append(",").append(user.getDeadLine()).append(")");

		sqls.add(sql.toString());
		String[] depts = user.getDepts().split(",");

		for(String dept : depts){
			sqls.add("INSERT INTO peak_auth_deptuser(id,userid,deptid,isleader) VALUE("+System.currentTimeMillis()/1000+","+user.getId()+","+dept+",0)");
		}
		return sqls.toArray(new String[]{});
	}
	
	
	/**
	 * 根据删除用户
	 * @param id
	 * @return
	 */
	public boolean deleteById(Integer... id){
		String sql = "DELETE FROM peak_user WHERE id in (?)";
		return jdbcHandler.execute(sql, id);
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

	/**
	 * 获取分页总数
	 * @param user
	 * @return
	 */
	public int getCount(UserBean user){
		String sql = "SELECT count(*) FROM peak_user WHERE 1=1 "+sqlWhere(user)+"order by username desc";
		return jdbcHandler.queryForInteger(sql);
	}

	private String sqlWhere(UserBean user) {
		if(null!= user && StringUtils.isNotEmpty(user.getUserName())){
			return " USERNAME='"+user.getUserName()+"' ";
		}
		return "";
	}

	/**
	 * 根据id进行批量更新
	 * @param ids
	 * @return
	 */
	public boolean updateStatusByIds(Integer[] ids,boolean isStart) {
		List<String> sqls = new ArrayList<>();
		int status = isStart ? 0:1;
		for (int id : ids){
			sqls.add("UPDATE peak_user SET status = "+status+" WHERE ID = "+id);
		}
		return jdbcHandler.batchUpdate(sqls.toArray(new String[]{})).isSuccess();
	}
}
