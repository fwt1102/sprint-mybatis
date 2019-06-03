package com.fwt.vo;

import java.util.List;

public class MenuInfoVo {
    int id;
    int pid;
    int seqno;
    String parentname;
    String name;
    String url;
    String icon;
    boolean open = true;
    boolean checked;
    List<MenuInfoVo> children;

    public String getParentname() {
        return parentname;
    }

    public void setParentname(String parentname) {
        this.parentname = parentname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getSeqno() {
        return seqno;
    }

    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isChecked() {
        return !checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public List<MenuInfoVo> getChildren() {
        return children;
    }

    public void setChildren(List<MenuInfoVo> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenuInfoVo{" +
                "id=" + id +
                ", pid=" + pid +
                ", seqno=" + seqno +
                ", parentName='" + parentname + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", icon='" + icon + '\'' +
                ", open=" + open +
                ", checked=" + checked +
                ", children=" + children +
                '}';
    }
}
