package com.feiniaojin.ddd.application.service.user.factory;

import com.feiniaojin.ddd.domain.entity.TokenEntity;
import com.feiniaojin.ddd.domain.factory.TokenEntityFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * <p>TokenEntityFactoryImpl</p>
 *
 * @author thy
 */
@Component
public class TokenEntityFactoryImpl implements TokenEntityFactory {
    @Override
    public TokenEntity newInstance(String name, String token) {
        if (StringUtils.isBlank(name)) {
            throw new RuntimeException("用户名不允许为空");
        }

        if (StringUtils.isBlank(token)) {
            throw new RuntimeException("token不允许为空");
        }

        TokenEntity tokenEntity = new TokenEntity();

        tokenEntity.setName(name);
        tokenEntity.setToken(token);

        return tokenEntity;
    }
}
