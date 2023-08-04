package com.ding.ssm.mapper;

import com.ding.ssm.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
* @author LiBin
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2023-08-01 15:40:35
* @Entity com.ding.ssm.domain.User
*/
public interface UserMapper extends BaseMapper<User> {
    User getByIdUser(@Param("id") Long id);
    List<User> getAllUser();
    int addUser(Long id,String loginName,String nickName,String passwd);
    User updateId(@Param("id") Long id);

    List<User> selectNickNameAndLoginNameById(@Param("id") Long id);

    List<User> selectIdAndLoginNameOrderByIdDesc();
}




