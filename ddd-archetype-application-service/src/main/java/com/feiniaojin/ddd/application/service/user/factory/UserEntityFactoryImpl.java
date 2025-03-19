package com.feiniaojin.ddd.application.service.user.factory;

import com.feiniaojin.ddd.domain.entity.UserEntity;
import com.feiniaojin.ddd.domain.factory.UserEntityFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * <p>UserEntityFactoryImpl</p>
 *
 * @author thy
 */
@Component
public class UserEntityFactoryImpl implements UserEntityFactory {
    @Override
    public UserEntity newInstance(String name, String password) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("用户名不允许为空");
        }

        if (StringUtils.isBlank(password)) {
            throw new RuntimeException("密码不允许为空");
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setName(name);
        userEntity.setPassword(password);
        userEntity.setCreateDate(LocalDateTime.now());

        return userEntity;
    }
}
