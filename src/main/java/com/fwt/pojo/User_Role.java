package com.fwt.pojo;

import java.io.Serializable;
import java.util.Arrays;

public class User_Role implements Serializable {
    private int id;
    private int userid;
    private int roleid;
    private int[] roleids;

    public int[] getRoleids() {
        return roleids;
    }

    public void setRoleids(int[] roleids) {
        this.roleids = roleids;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return "User_Role{" +
                "id=" + id +
                ", userid=" + userid +
                ", roleid=" + roleid +
                ", roleids=" + Arrays.toString(roleids) +
                '}';
    }
}
