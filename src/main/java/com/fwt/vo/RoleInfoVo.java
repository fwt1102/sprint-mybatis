package com.fwt.vo;

public class RoleInfoVo {
    private int roleid;
    private  String roleName;
    private String shortName;
    private int isnull;
    private int userId;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getIsnull() {
        return isnull;
    }

    public void setIsnull(int isnull) {
        this.isnull = isnull;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "RoleInfoVo{" +
                "roleid=" + roleid +
                ", roleName='" + roleName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", isnull=" + isnull +
                ", userId=" + userId +
                '}';
    }
}
