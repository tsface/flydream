/*
 * @(#)Page.java	2014-1-9
 */
package com.flydream.common;

import com.avatar.gdk.util.PagerUtils;

/**
 * 分页对象
 * 
 * @author liyan
 * @version 2015-1-9
 * @since 1.0
 * @see
 */
public class Page extends PagerUtils
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7103548705543306044L;
	private String token;
	private String searchid;

	public Page()
	{
		super();
	}

	public Page(int pageno, int pagesize)
	{
		super();
		setPageNo(pageno);
		setPageSize(pagesize);
	}

	public String getToken()
	{
		return this.token;
	}

	public void setToken(String token)
	{
		this.token = token;
	}

	public String getSearchid()
	{
		return this.searchid;
	}

	public void setSearchid(String searchid)
	{
		this.searchid = searchid;
	}

	public void setTotalRows(int totalRows)
	{
		super.setTotalRows(totalRows);

		int realPageCount = (getTotalRows() % getPageSize() == 0) ? getTotalRows()
				/ getPageSize()
				: getTotalRows() / getPageSize() + 1;
		if (getPageNo() > realPageCount)
		{
			setPageNo(1);
		}

	}
}
