package com.fwt.service.impl;

import com.fwt.mapper.RoleInfoMapper;
import com.fwt.pojo.RoleInfo;
import com.fwt.pojo.User_Role;
import com.fwt.service.RoleInfoService;

import com.fwt.vo.RoleInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleInfoServiceImpl implements RoleInfoService {

    @Autowired
    RoleInfoMapper roleInfoMapper;

    //        <!--查询分配好与未分配的角色-->
    public List<RoleInfoVo> selectOrder(int userid) {
        return roleInfoMapper.selectOrder(userid);
    }
    //添加
    public int addRole(User_Role user_role) {
        int i = roleInfoMapper.addRole(user_role);
        return i;
    }
    //删除
    public int deleteRole(User_Role user_role) {
        return roleInfoMapper.deleteRole(user_role);
    }

    public List<RoleInfo> selectByUserRole() {
        return roleInfoMapper.selectByUserRole();
    }
}
