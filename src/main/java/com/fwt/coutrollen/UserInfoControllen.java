package com.fwt.coutrollen;

import com.fwt.pojo.UserInfo;
import com.fwt.service.UserInfoService;

import com.fwt.utils.HttpClientUtility;
import com.fwt.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserInfoControllen {

    @Autowired
    UserInfoService userInfoService;
    //登录
     @ResponseBody
    @RequestMapping("userlogin")
    public Object Login1(@RequestBody UserInfo userInfo , HttpSession Session,ModelMap map) {
        UserInfo userInfo1 = userInfoService.LoginUser(userInfo);
        System.out.println(userInfo1);
       if (userInfo1!=null){
           System.out.println("登录成功");
           Session.setAttribute("userInfo",userInfo1);
           map.addAttribute("userInfo",userInfo);
           return true;
       }else {
           return false;
       }
    }
    //注册
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    public String Register(UserInfo userInfo){
        int i = userInfoService.AddUser(userInfo);
        if (i>0){

            System.out.println("注册成功");
            return "login";
        }else {
            System.out.println("失败");
            return "reg";
        }
    }
    //查询所有User
    @ResponseBody
    @RequestMapping("selectAllUser")
    public Object SelectAllUser(){
        List<UserInfo> userInfos = userInfoService.selectAllUser();


        return userInfos;

    }
    //模糊查询
    @ResponseBody
    @RequestMapping("selectLiked")
    public Object SelectLike(@RequestBody UserInfo userInfo){
        System.out.println(111);
        List<UserInfo> userInfos = userInfoService.selectLike(userInfo);
        return userInfos;
    }
    //查找对象
    @ResponseBody
    @RequestMapping("updateUserById")
    public Object updateUserInfo(@RequestParam int userId){
        UserInfo userInfo1 = userInfoService.UserInfoById(userId);
        return userInfo1;
    }
 //修改对象
    @ResponseBody
    @RequestMapping("updataUserInfo")
    public Object updateUserInfo(@RequestBody UserInfo userInfo){

        int i = userInfoService.updateUserInfo(userInfo);
        return i;
    }
    //删除
    @ResponseBody
    @RequestMapping("deleteUser")
    public int deleteUser(@RequestParam int userId){

      return userInfoService.deleteUserInfo(userId);
    }

    //添加
    @ResponseBody
    @RequestMapping("addUserInfo")
    public int addUser(@RequestBody UserInfo userInfo){
        return userInfoService.AddUser(userInfo);
    }

    @ResponseBody
    @RequestMapping("selectPage")
    public List selectPage(@RequestParam int currentPage1){
        System.out.println(currentPage1+"KKKKK");
        Page page = new Page();
        int totalCount = userInfoService.selectTotalCount();
        page.setTotalCount(totalCount);
        page.setCurrentPage(currentPage1);
        List userInfos = userInfoService.SelectPage(page);
        userInfos.add(page);
        return userInfos;
    }

}
