/*
 * @(#)DeptBean 2015/10/11
 */
package com.flydream.dept;

import com.avatar.db.annotation.Column;

/**
 * @author liyan
 * @version 2015/10/11
 * @since 1.0
 */
public class DeptBean {

    @Column(name="ID")
    private int id;

    @Column(name="PARENTDEPTID")
    private int parentdeptid=0;

    @Column(name="DEPTCODE")
    private String deptcode;

    @Column(name="DEPTNAME")
    private String deptname;

    @Column(name="DEPTDESC")
    private String deptdesc;

    @Column(name="FLAG")
    private int flag = 0;

    @Column(name="CREATOR")
    private String creator = "0";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentdeptid() {
        return parentdeptid;
    }

    public void setParentdeptid(int parentdeptid) {
        this.parentdeptid = parentdeptid;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptdesc() {
        return deptdesc;
    }

    public void setDeptdesc(String deptdesc) {
        this.deptdesc = deptdesc;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
