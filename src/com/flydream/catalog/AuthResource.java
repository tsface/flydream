/*
 * @(#)AuthResource 2015/10/15
 */
package com.flydream.catalog;

import com.avatar.db.annotation.Column;

/**
 * @author liyan
 * @version 2015/10/15
 * @see
 * @since 1.0
 */
public class AuthResource {

    @Column(name="ID")
    private int id;

    @Column(name="PARENTID")
    private int parentid=0;

    @Column(name="RESOURCENAME")
    private String resourcename;

    @Column(name="LABEL")
    private String label;

    @Column(name="DESCRIPTION")
    private String description;

    @Column(name="URL")
    private String url;

    @Column(name="MODULEID")
    private int moduleid;

    @Column(name="RESOURCETYPE")
    private int resourcetype;

    @Column(name="IMAGE")
    private String image;

    @Column(name="BIGIMAGE")
    private String bigimage;

    @Column(name="SORTORDER")
    private int sortorder;

    @Column(name="STATE")
    private int state;

    @Column(name="PARENTNAME")
    private String parentname = "platform";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentid() {
        return parentid;
    }

    public void setParentid(int parentid) {
        this.parentid = parentid;
    }

    public String getResourcename() {
        return resourcename;
    }

    public void setResourcename(String resourcename) {
        this.resourcename = resourcename;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getModuleid() {
        return moduleid;
    }

    public void setModuleid(int moduleid) {
        this.moduleid = moduleid;
    }

    public int getResourcetype() {
        return resourcetype;
    }

    public void setResourcetype(int resourcetype) {
        this.resourcetype = resourcetype;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBigimage() {
        return bigimage;
    }

    public void setBigimage(String bigimage) {
        this.bigimage = bigimage;
    }

    public int getSortorder() {
        return sortorder;
    }

    public void setSortorder(int sortorder) {
        this.sortorder = sortorder;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthResource that = (AuthResource) o;

        if (id != that.id) return false;
        if (!resourcename.equals(that.resourcename)) return false;
        return url.equals(that.url);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + resourcename.hashCode();
        result = 31 * result + url.hashCode();
        return result;
    }
}
