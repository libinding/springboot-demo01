package com.ding.ssm.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ding.ssm.domain.User;
import com.ding.ssm.service.UserService;
import com.ding.ssm.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author LiBin
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2023-08-01 15:40:35
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{
    @Autowired(required = false)
    private UserMapper userMapper;

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getByIdUser(Long id) {
        return userMapper.getByIdUser(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public int addUser(Long id, String loginName, String nickName, String passwd) {
        return userMapper.addUser(id,loginName,nickName,passwd);
    }

    @Override
    public User updateId(Long id) {
        return userMapper.updateId(id);
    }

    @Override
    public List<User> selectNickNameAndLoginNameById(Long id) {
        return userMapper.selectNickNameAndLoginNameById(id);
    }

    @Override
    public List<User> selectIdAndLoginNameOrderByIdDesc() {
        return userMapper.selectIdAndLoginNameOrderByIdDesc();
    }
}




