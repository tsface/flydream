/*
 * @(#)ZTreeNode 2015/10/18
 */
package com.flydream.common;

/**
 * @author liyan
 * @version 2015/10/18
 * @see
 * @since 1.0
 */
public class ZTreeNode {

    private int id;

    private int pId;

    private String name;

    private boolean open = true;

    private boolean checked = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
