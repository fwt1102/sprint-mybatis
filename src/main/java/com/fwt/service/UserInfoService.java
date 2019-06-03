package com.fwt.service;

import com.fwt.pojo.UserInfo;
import com.fwt.utils.Page;

import java.util.List;

public interface UserInfoService {
    List<UserInfo> selectAllUser();

    int updateUserInfo(UserInfo userInfo);

    /**
     * 登录
     * @param userInfo
     * @return
     */
    UserInfo LoginUser(UserInfo userInfo);

    /**
     * 注册
     * @param userInfo
     * @return
     */
    int AddUser(UserInfo userInfo);

    /**
     * 模糊查询
     * @return
     */
//    List<UserInfo> selectLike(String name);
    List<UserInfo> selectLike(UserInfo userInfo);


    UserInfo UserInfoById(int userid);


    int deleteUserInfo(int userid);

    List<UserInfo> SelectPage(Page page);


    int selectTotalCount();



}
