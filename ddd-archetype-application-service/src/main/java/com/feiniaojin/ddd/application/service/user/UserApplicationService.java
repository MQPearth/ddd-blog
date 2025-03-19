package com.feiniaojin.ddd.application.service.user;

import com.feiniaojin.ddd.application.service.user.dto.RegisterCommand;
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
    UserEntityFactory entityFactory;

    @Resource
    UserEntityRepository repository;

    @Resource
    UserQueryService userQueryService;

    public void register(RegisterCommand command) {
        if (userQueryService.exists(command.getName())) {
            throw new RuntimeException("用户名已占用");
        }
        UserEntity entity = entityFactory.newInstance(command.getName(), command.getPassword());
        entity.register();
        repository.save(entity);
    }
}
