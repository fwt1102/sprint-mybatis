package com.fwt.service.impl;


import com.fwt.mapper.UserInfoMapper;
import com.fwt.pojo.UserInfo;
import com.fwt.service.UserInfoService;
import com.fwt.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper ;

      @Transactional(propagation = Propagation.REQUIRED)
    public List<UserInfo> selectAllUser() {

        return userInfoMapper.selectAllUser();
    }



    @Transactional(propagation = Propagation.REQUIRED)
    public int updateUserInfo(UserInfo userInfo) {

//        List<UserInfo> userInfos = userInfoMapper.selectAllUser();
//        for (UserInfo info : userInfos) {
//            System.out.println(info);
//        }
        int i = userInfoMapper.updateUserInfo(userInfo);

        return i;
    }

    /**
     * 登录
     * @param userInfo
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public UserInfo LoginUser(UserInfo userInfo) {
        return userInfoMapper.LoginUser(userInfo);
    }

    /**
     * 注册
     * @param userInfo
     * @return
     */
    public int AddUser(UserInfo userInfo) {
        return  userInfoMapper.AddUser(userInfo);
    }

    /**
     * 模糊查询
     * @param userInfo
     * @return
     */
    public List<UserInfo> selectLike(UserInfo userInfo) {
        return userInfoMapper.selectLike(userInfo);
    }

    public UserInfo UserInfoById(int userid) {
        return userInfoMapper.UserInfoById(userid);
    }

    public int deleteUserInfo(int userid) {
        return userInfoMapper.deleteUserInfo(userid);
    }

    public List<UserInfo> SelectPage(Page page) {
        return userInfoMapper.SelectPage(page);
    }

    public int selectTotalCount() {
        return userInfoMapper.selectTotalCount();
    }
}
