package com.pretty.deploy.audit.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pretty.deploy.audit.entity.User;

/**
 * @Author:Tanht
 * @Description:
 * @Date:5:23 PM 5/6/2020
 */


public interface UserService extends IService<User> {

     IPage<User> selectUserPage(Page<User> page, QueryWrapper<User> queryWrapper);

     int updateUser(User user);


}
