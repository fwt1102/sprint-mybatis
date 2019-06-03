package com.fwt.service.impl;

import com.fwt.mapper.MenuInfoMapper;
import com.fwt.service.MenuInfoService;
import com.fwt.vo.MenuInfoVo;

import com.fwt.vo.MenuInfoVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by DELL on 2019/5/21.
 */
@Service
public class MenuInfoServiceImpl implements MenuInfoService {
    @Autowired
    MenuInfoMapper menuInfoMapper;
//查询角色权限
    public List<MenuInfoVo> listMenu(int roleid) {
        return menuInfoMapper.listMenu( roleid);
    }


//删除权限
    public int deleteMenu(int roleid) {
        return menuInfoMapper.deleteMenu(roleid);
    }

//添加权限
    public int addMenu(MenuInfoVo2 menuInfoVo2) {
        return menuInfoMapper.addMenu(menuInfoVo2);
    }

    //<!--查询当前用户所拥有的权限-->
    public List<MenuInfoVo> SelectUserRoleMenuById(int userid) {
        return menuInfoMapper.SelectUserRoleMenuById(userid);
    }
}
