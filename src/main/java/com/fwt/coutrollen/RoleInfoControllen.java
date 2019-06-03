package com.fwt.coutrollen;

import com.fwt.mapper.RoleInfoMapper;
import com.fwt.pojo.RoleInfo;
import com.fwt.pojo.User_Role;
import com.fwt.service.RoleInfoService;

import com.fwt.vo.RoleInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.xml.bind.SchemaOutputResolver;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Controller
public class RoleInfoControllen {
    @Autowired
    RoleInfoService roleInfoService;
//查询角色渲染页面
    @ResponseBody
    @RequestMapping("RoleUser")
    public Object selectRoleUser(@RequestParam int userId){
        List<RoleInfoVo> roleInfoVos = roleInfoService.selectOrder(userId);

        return roleInfoVos;
    }

 //添加角色身份
 @ResponseBody
    @RequestMapping("addRoleUser")
    public Object addRole(@RequestBody User_Role user_role) {
        int i = roleInfoService.addRole(user_role);

        return i;
    }

//删除角色身份
@ResponseBody
    @RequestMapping("deleteRoleUser")
    public Object deleteRoleUser(@RequestBody User_Role user_role) {
        int i = roleInfoService.deleteRole(user_role);
        return i;
    }
    @ResponseBody
    @RequestMapping("selectByUserRole1")
    public Object selectByUserRole(){
        List<RoleInfo> roleInfos = roleInfoService.selectByUserRole();
        return roleInfos;
    }

    //用 thymeleaf 渲染页面
    @RequestMapping("selectRoleUser2")
    public String selectRole_User( ModelMap modelMap){
        List<RoleInfo> roleInfos = roleInfoService.selectByUserRole();

         modelMap.addAttribute("roleuser1",roleInfos);

        return "test";
    }
}
