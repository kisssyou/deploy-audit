package com.pretty.deploy.audit.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pretty.deploy.audit.entity.User;
import org.apache.ibatis.annotations.Param;

/**
 * @Author:Tanht
 * @Description:
 * @Date:5:23 PM 5/6/2020
 */


public interface UserMapper extends BaseMapper<User> {

    /**
     * <p>
     * 查询 : 根据state状态查询用户列表，分页显示
     * </p>
     *
     * @param page 分页对象,xml中可以从里面进行取值,传递参数 Page 即自动分页,必须放在第一位(你可以继承Page实现自己的分页对象)
     * @return 分页对象
     */
    IPage<User> selectPageVo(Page<?> page, @Param("ew") QueryWrapper<User> queryWrapper);

    /**
     * 修改用户信息
     * @param user
     */
    int updateUser(@Param("userInfo") User user);
}
