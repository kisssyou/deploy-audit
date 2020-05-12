package com.pretty.deploy.audit.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pretty.deploy.audit.entity.User;
import com.pretty.deploy.audit.mapper.UserMapper;
import com.pretty.deploy.audit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:Tanht
 * @Description:
 * @Date:5:26 PM 5/6/2020
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    UserMapper userMapper;


    public IPage<User> selectUserPage(Page<User> page, QueryWrapper<User> queryWrapper) {
        // 不进行 count sql 优化，解决 MP 无法自动优化 SQL 问题，这时候你需要自己查询 count 部分
        // page.setOptimizeCountSql(false);
        // 当 total 为小于 0 或者设置 setSearchCount(false) 分页插件不会进行 count 查询
        // 要点!! 分页返回的对象与传入的对象是同一个
        return userMapper.selectPageVo(page, queryWrapper);
    }

    public int updateUser(User user){
        return userMapper.updateUser(user);
    }
}
