package com.ding.ssm.controller;

import com.ding.ssm.domain.User;
import com.ding.ssm.mapper.UserMapper;
import com.ding.ssm.service.UserService;
import com.ding.ssm.service.impl.UserServiceImpl;
import lombok.extern.flogger.Flogger;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class UserController {
   @Autowired
   // UserMapper userMapper;
    private UserService userService=new UserServiceImpl();
    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable("id") Long id){
        User user = userService.getByIdUser(id);
        return user;
        //return userMapper.getByIdUser(id);
    }
    @ResponseBody
    @GetMapping("/user")
    public List<User> getAllUser(){
        List<User> user = userService.getAllUser();
        user.forEach(System.out::println);
        return user;
    }
    @GetMapping("add/{id}/{loginName}/{nickName}/{passwd}")
    public String addUser(@PathVariable("id") Long id,@PathVariable("loginName") String loginName,@PathVariable("nickName") String nickName,@PathVariable("passwd") String passwd){
        userService.addUser(id, loginName, nickName, passwd);
        return "redirect:/user";
    }
    @GetMapping("/update/{id}")
    @ResponseBody
    public User updateUser(@PathVariable("id") Long id){
        User user = userService.updateId(id);
        return user;
    }
    @GetMapping("/remove/{id}")
    @ResponseBody
    public boolean deleteUser(@PathVariable("id") Long id){
        boolean user = userService.removeById(id);
        return user;
    }

    @GetMapping("/select/{id}")
    @ResponseBody
    public List<User> selectNickNameAndLoginNameById(@PathVariable("id") Long id){
        List<User> users = userService.selectNickNameAndLoginNameById(id);
        return users;
    }
    @GetMapping("/select")
    @ResponseBody
    public List<User> selectIdAndLoginNameOrderByIdDesc(){
        List<User> users = userService.selectIdAndLoginNameOrderByIdDesc();
        return users;
    }
}
