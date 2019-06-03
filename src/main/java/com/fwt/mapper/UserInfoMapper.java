package com.fwt.mapper;

import com.fwt.pojo.UserInfo;
import com.fwt.utils.Page;

import java.util.List;

public interface UserInfoMapper {
    /**
     * 查询所有
     * @return
     */
    List<UserInfo> selectAllUser();

    /**
     * 修改Userinfo
     * @param userInfo
     * @return
     */
    int updateUserInfo(UserInfo userInfo);

    /**
     * 登录
     * @param userInfo
     * @return
     */
     UserInfo LoginUser(UserInfo userInfo);
    /**
     * 注册
     */
    int AddUser(UserInfo userInfo);
    /**
     * 模糊chaxun
     */
    List<UserInfo> selectLike(UserInfo userInfo);
//查找
    UserInfo UserInfoById(int userid);

    /**
     * 删除
     * @param userid
     * @return
     */
    int deleteUserInfo(int userid);

    List<UserInfo> SelectPage(Page page);

    int selectTotalCount();
}
