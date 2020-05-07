package com.pretty.deploy.audit.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pretty.deploy.audit.entity.User;
import com.pretty.deploy.audit.service.UserService;
import com.pretty.deploy.audit.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author:Tanht
 * @Description:
 * @Date:5:27 PM 5/6/2020
 */


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static final String PASSWORD_SALT = "cqasiainfoajnegjfk";
    /**
     * 分页查询用户数据
     * @param userCondition
     * @return
     */
    @RequestMapping(value = "queryUserList")
    @ResponseBody
    public IPage<User> queryUserList(@RequestBody JSONObject userCondition){
        //页码数
        Long currentPageNum = userCondition.getLong("pageNum");
        //查询条件（按姓名查找） 看后续是否需要添加
        Page<User> page = new Page<>();
        page.setCurrent(currentPageNum);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        return userService.selectUserPage(page,queryWrapper);
    }

    /**
     * 一个粗糙的登录功能
     * @param user
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public JSONObject login(@RequestBody User user){
        JSONObject resultJson = new JSONObject();
        //获得加密后密码
        String password = MD5Utils.getPwd(user.getPassword()+PASSWORD_SALT);
        User currentUser = userService.getById(user.getId());
        if(currentUser == null){
            resultJson.put("respCode","-100");
            resultJson.put("respMsg","不存在该用户！");
            return resultJson;
        }
        if(!currentUser.getPassword().equals(password)){
            resultJson.put("respCode","-200");
            resultJson.put("respMsg","用户名或密码错误！");
            return resultJson;
        }
        resultJson.put("respCode","100");
        resultJson.put("respMsg","登录成功！");
        return resultJson;
    }

    /**
     * 用户信息修改
     * @param user
     * @return
     */
    @RequestMapping(value = "updateUser")
    @ResponseBody
    public JSONObject updateUserInfo(@RequestBody User user){
        //获得原密码
        String password = user.getPassword();
        //密码加密
        user.setPassword(MD5Utils.getPwd(password+PASSWORD_SALT));
        boolean updateResult = userService.updateById(user);
        JSONObject resultJson = new JSONObject();
        if(!updateResult){
            resultJson.put("respCode","-100");
            resultJson.put("respMsg","修改用户信息失败");
            return resultJson;
        }
        resultJson.put("respCode","100");
        resultJson.put("respMsg","修改用户信息成功");
        return resultJson;
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @RequestMapping(value = "addUser")
    @ResponseBody
    public JSONObject addUser(@RequestBody User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //获得原密码
        String password = user.getPassword();
        //密码加密
        String newPassword = MD5Utils.getPwd(password+PASSWORD_SALT);
        user.setPassword(newPassword);
        //新增用户前需判断该用户名是否被注册
        queryWrapper.eq("USER_NAME",user.getUserName());
        User oldUser = userService.getOne(queryWrapper);
        JSONObject resultJson = new JSONObject();
        if(oldUser == null) {
            boolean addResult = userService.save(user);
            if (!addResult) {
                resultJson.put("respCode", "-100");
                resultJson.put("respMsg", "新增用户失败");
                return resultJson;
            }
            resultJson.put("respCode", "100");
            resultJson.put("respMsg", "新增用户成功");
            return resultJson;
        }
        resultJson.put("respCode", "-200");
        resultJson.put("respMsg", "该用户名已被注册");
        return resultJson;
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "deleteUser/{id}")
    @ResponseBody
    public JSONObject deleteUserInfo(@PathVariable Integer id){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("ID",id);
        boolean deleteResult = userService.remove(queryWrapper);
        JSONObject resultJson = new JSONObject();
        if(!deleteResult){
            resultJson.put("respCode","-100");
            resultJson.put("respMsg","删除用户失败");
            return resultJson;
        }
        resultJson.put("respCode","100");
        resultJson.put("respMsg","删除用户成功");
        return resultJson;
    }

    @RequestMapping(value = "logout")
    @ResponseBody
    public JSONObject logout(){
         return null;
    }


}
