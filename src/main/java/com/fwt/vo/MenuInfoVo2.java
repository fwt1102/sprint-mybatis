package com.fwt.vo;

import java.util.Arrays;

public class MenuInfoVo2 {
    private int roleid;
    private int[] menuids;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int[] getMenuids() {
        return menuids;
    }

    public void setMenuids(int[] menuids) {
        this.menuids = menuids;
    }

    @Override
    public String toString() {
        return "MenuInfoVo2{" +
                "roleid=" + roleid +
                ", menuids=" + Arrays.toString(menuids) +
                '}';
    }
}
