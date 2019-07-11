package com.zhongruan;

import com.zhongruan.bean.UserInfo;
import com.zhongruan.dao.UserInfoDao;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserInfoDao userInfoDao = new UserInfoDao();
        List<UserInfo> list = userInfoDao.findAll();
        System.out.println(list);
//        userInfoDao.del();
//        List<UserInfo> list1 = userInfoDao.findAll();
//        System.out.println(list1);
        userInfoDao.update();
        List<UserInfo> list2 = userInfoDao.findAll();
        System.out.println(list2);
    }
}
