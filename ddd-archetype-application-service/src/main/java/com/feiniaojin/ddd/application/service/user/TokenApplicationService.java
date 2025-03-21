package com.feiniaojin.ddd.application.service.user;

import com.feiniaojin.ddd.application.service.user.dto.command.LoginCommand;
import com.feiniaojin.ddd.application.service.user.dto.view.LoginView;
import com.feiniaojin.ddd.domain.entity.TokenEntity;
import com.feiniaojin.ddd.domain.entity.UserEntity;
import com.feiniaojin.ddd.domain.factory.TokenEntityFactory;
import com.feiniaojin.ddd.domain.repository.TokenEntityRepository;
import com.feiniaojin.ddd.domain.repository.UserEntityRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p>LoginApplicationService</p>
 *
 * @author thy
 */
@Component
public class TokenApplicationService {

    @Resource
    TokenEntityFactory tokenEntityFactory;

    @Resource
    UserEntityRepository userEntityRepository;

    @Resource
    TokenEntityRepository tokenEntityRepository;

    /**
     * 用单独的领域服务
     * 应用层协调领域模型和基础设施层完成完整业务逻辑
     */
    public LoginView login(LoginCommand command) {
        // 重建实体
        UserEntity entity = userEntityRepository.load(command.getName());
        if (Objects.isNull(entity)) {
            throw new RuntimeException("用户不存在");
        }
        // 充血模型执行业务逻辑
        String token = entity.login(command.getPassword());

        TokenEntity tokenEntity = tokenEntityFactory.newInstance(command.getName(), token, entity.getId());
        // 缓存的实现属于基础设施层
        tokenEntityRepository.save(tokenEntity);
        // 返回view
        return new LoginView(token);
    }

    public Integer auth(String token) {
        TokenEntity entity = tokenEntityRepository.load(token);
        if (Objects.isNull(entity)) {
            return null;
        }
        return entity.auth();
    }
}
