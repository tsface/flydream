/*
 * @(#)UserBean.java 2015/6月/
 */
package com.flydream.usr;

import com.avatar.db.annotation.Column;

/**
 * User Bean
 * @author liyan
 * @version  2015/6/1
 * @since 1.0
 * @see
 */
public class UserBean{
	
	@Column(name="ID")
	private int id;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="PASSWORD")
	private String passWord;
	
	@Column(name="REALNAME")
	private String realName;
	
	@Column(name="GENDER")
	private int gender;
	
	@Column(name="AVATAR1")
	private String avatar1;
	
	@Column(name="AVATAR2")
	private String avatar2;
	
	@Column(name="AVATAR3")
	private String avatar3;
	
	@Column(name="STATUS")
	private int status;
	
	@Column(name="LASTLOGINTIME")
	private long lastLoginTime;
	
	@Column(name="LOGINIP")
	private String loginIp;
	
	@Column(name="LOGINMAC")
	private String loginMac;
	
	@Column(name="CREATETIME")
	private long createTime;
	
	@Column(name="USERTYPE")
	private int userType;
	
	@Column(name="DEADLINE")
	private long deadLine;

	private String depts;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getAvatar1() {
		return avatar1;
	}

	public void setAvatar1(String avatar1) {
		this.avatar1 = avatar1;
	}

	public String getAvatar2() {
		return avatar2;
	}

	public void setAvatar2(String avatar2) {
		this.avatar2 = avatar2;
	}

	public String getAvatar3() {
		return avatar3;
	}

	public void setAvatar3(String avatar3) {
		this.avatar3 = avatar3;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(long lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public String getLoginMac() {
		return loginMac;
	}

	public void setLoginMac(String loginMac) {
		this.loginMac = loginMac;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public long getDeadLine() {
		return deadLine;
	}

	public void setDeadLine(long deadLine) {
		this.deadLine = deadLine;
	}

	public String getDepts() {
		return depts;
	}

	public void setDepts(String depts) {
		this.depts = depts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((avatar1 == null) ? 0 : avatar1.hashCode());
		result = prime * result + ((avatar2 == null) ? 0 : avatar2.hashCode());
		result = prime * result + ((avatar3 == null) ? 0 : avatar3.hashCode());
		result = prime * result + (int) (createTime ^ (createTime >>> 32));
		result = prime * result + (int) (deadLine ^ (deadLine >>> 32));
		result = prime * result + gender;
		result = prime * result + id;
		result = prime * result
				+ (int) (lastLoginTime ^ (lastLoginTime >>> 32));
		result = prime * result + ((loginIp == null) ? 0 : loginIp.hashCode());
		result = prime * result
				+ ((loginMac == null) ? 0 : loginMac.hashCode());
		result = prime * result
				+ ((passWord == null) ? 0 : passWord.hashCode());
		result = prime * result
				+ ((realName == null) ? 0 : realName.hashCode());
		result = prime * result + status;
		result = prime * result
				+ ((userName == null) ? 0 : userName.hashCode());
		result = prime * result + userType;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserBean other = (UserBean) obj;
		if (avatar1 == null) {
			if (other.avatar1 != null)
				return false;
		} else if (!avatar1.equals(other.avatar1))
			return false;
		if (avatar2 == null) {
			if (other.avatar2 != null)
				return false;
		} else if (!avatar2.equals(other.avatar2))
			return false;
		if (avatar3 == null) {
			if (other.avatar3 != null)
				return false;
		} else if (!avatar3.equals(other.avatar3))
			return false;
		if (createTime != other.createTime)
			return false;
		if (deadLine != other.deadLine)
			return false;
		if (gender != other.gender)
			return false;
		if (id != other.id)
			return false;
		if (lastLoginTime != other.lastLoginTime)
			return false;
		if (loginIp == null) {
			if (other.loginIp != null)
				return false;
		} else if (!loginIp.equals(other.loginIp))
			return false;
		if (loginMac == null) {
			if (other.loginMac != null)
				return false;
		} else if (!loginMac.equals(other.loginMac))
			return false;
		if (passWord == null) {
			if (other.passWord != null)
				return false;
		} else if (!passWord.equals(other.passWord))
			return false;
		if (realName == null) {
			if (other.realName != null)
				return false;
		} else if (!realName.equals(other.realName))
			return false;
		if (status != other.status)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		if (userType != other.userType)
			return false;
		return true;
	}

}
