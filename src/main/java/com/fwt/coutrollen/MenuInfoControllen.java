package com.fwt.coutrollen;

import com.fwt.mapper.MenuInfoMapper;
import com.fwt.pojo.UserInfo;
import com.fwt.service.MenuInfoService;
import com.fwt.service.impl.MenuInfoServiceImpl;
import com.fwt.utils.Page;
import com.fwt.vo.MenuInfoVo;
import com.fwt.vo.MenuInfoVo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class MenuInfoControllen {

    @Autowired
    MenuInfoService menuInfoService;


    //查询所有权限
    @RequestMapping("selectMenu")
    public Object selectMenu(@RequestParam int roleId){

        List<MenuInfoVo> menuInfoVos = menuInfoService.listMenu(roleId);
        return menuInfoVos;
                }

    //修改角色权限
    @RequestMapping("updateMenu")
    public Object updateMenu(@RequestBody MenuInfoVo2 menuInfoVo2){
        int addMenu=0;

        //先删除原有的权限
        int deleteMenu = menuInfoService.deleteMenu(menuInfoVo2.getRoleid());

        //如果menuids数组有值 则执行添加
        if (menuInfoVo2.getMenuids().length>0){
        addMenu = menuInfoService.addMenu(menuInfoVo2);
        }
          //如果删除或添加成功 则返回true 否则false
        if (deleteMenu>0 || addMenu>0){
        return true;
        }
        return false;
        }

        @RequestMapping("SelectUserRoleMenuById")
        public Object SelectUserRoleMenuById(HttpSession httpSession){
            UserInfo userInfo = (UserInfo) httpSession.getAttribute("userInfo");
            List<MenuInfoVo> menuInfoVos = menuInfoService.SelectUserRoleMenuById(userInfo.getUserId());
            return menuInfoVos;
        }
        }
