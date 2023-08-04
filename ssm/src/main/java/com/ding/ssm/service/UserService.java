package com.ding.ssm.service;

import com.ding.ssm.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author LiBin
* @description 针对表【t_user】的数据库操作Service
* @createDate 2023-08-01 15:40:35
*/
public interface UserService extends IService<User> {
    User getByIdUser(@Param("id") Long id);
    List<User> getAllUser();
    int addUser(Long id,String loginName,String nickName,String passwd);
    User updateId(@Param("id") Long id);
    List<User> selectNickNameAndLoginNameById(@Param("id") Long id);
    List<User> selectIdAndLoginNameOrderByIdDesc();
}
