package com.feiniaojin.ddd.application.service.user;

import com.feiniaojin.ddd.application.service.user.dto.command.RegisterCommand;
import com.feiniaojin.ddd.domain.entity.UserEntity;
import com.feiniaojin.ddd.domain.factory.UserEntityFactory;
import com.feiniaojin.ddd.domain.repository.UserEntityRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * <p>UserApplicationService</p>
 *
 * @author thy
 */
@Component
public class UserApplicationService {

    @Resource
    UserEntityFactory userEntityFactory;

    @Resource
    UserEntityRepository userEntityRepository;

    @Resource
    UserQueryService userQueryService;

    public void register(RegisterCommand command) {
        // CQRS分离查询
        if (userQueryService.exists(command.getName())) {
            throw new RuntimeException("用户名已占用");
        }
        UserEntity entity = userEntityFactory.newInstance(command.getName(), command.getPassword());
        entity.register();
        userEntityRepository.save(entity);
    }

}
