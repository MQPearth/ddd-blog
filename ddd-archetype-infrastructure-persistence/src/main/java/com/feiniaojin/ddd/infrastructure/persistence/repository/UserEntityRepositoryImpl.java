package com.feiniaojin.ddd.infrastructure.persistence.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.feiniaojin.ddd.domain.entity.UserEntity;
import com.feiniaojin.ddd.domain.repository.UserEntityRepository;
import com.feiniaojin.ddd.infrastructure.persistence.data.UserData;
import com.feiniaojin.ddd.infrastructure.persistence.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * <p>UserEntityRepositoryImpl</p>
 *
 * @author thy
 */
@Component
public class UserEntityRepositoryImpl implements UserEntityRepository {


    @Resource
    UserMapper userMapper;

    @Override
    public UserEntity load(String name) {
        UserData userData = userMapper.selectOne(new LambdaQueryWrapper<UserData>().eq(UserData::getName, name));
        UserEntity entity = new UserEntity();
        entity.setId(userData.getId());
        entity.setName(userData.getName());
        entity.setPassword(userData.getPassword());
        entity.setCreateDate(userData.getCreateDate());
        return entity;
    }

    @Override
    public void save(UserEntity user) {
        UserData userData = new UserData();
        userData.setName(user.getName());
        userData.setPassword(user.getPassword());
        userData.setCreateDate(user.getCreateDate());
        userMapper.insert(userData);
    }
}
