package com.feiniaojin.ddd.application.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.feiniaojin.ddd.infrastructure.persistence.data.UserData;
import com.feiniaojin.ddd.infrastructure.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * <p>UserQueryService</p>
 *
 * @author thy
 */
@Component
public class UserQueryService {


    @Autowired
    UserMapper userMapper;

    public Boolean exists(String name) {
        Long count = userMapper.selectCount(new LambdaQueryWrapper<UserData>().eq(UserData::getName, name));
        return count > 0;
    }
}
