package com.fwt.mapper;

import com.fwt.vo.MenuInfoVo;
import com.fwt.vo.MenuInfoVo2;


import java.util.List;

/**
 * Created by DELL on 2019/5/21.
 */
public interface MenuInfoMapper {
//查询角色权限
    public List<MenuInfoVo> listMenu(int roleid);
 //删除原有的权限
    int deleteMenu(int roleid);
//添加权限
    int addMenu(MenuInfoVo2 menuInfoVo2);

      //<!--查询当前用户所拥有的权限-->
    List<MenuInfoVo> SelectUserRoleMenuById(int userid);
}
