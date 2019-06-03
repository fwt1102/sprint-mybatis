package com.fwt.service;

import com.fwt.pojo.RoleInfo;
import com.fwt.pojo.User_Role;

import com.fwt.vo.RoleInfoVo;

import java.util.List;

public interface RoleInfoService {

    //        <!--查询分配好与未分配的角色-->
    List<RoleInfoVo> selectOrder(int userid);
  //添加
    int addRole(User_Role user_role);
    //删除
    int deleteRole(User_Role user_role);

    List<RoleInfo> selectByUserRole();
}
