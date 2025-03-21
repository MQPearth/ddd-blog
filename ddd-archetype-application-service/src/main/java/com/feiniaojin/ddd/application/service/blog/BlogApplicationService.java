package com.feiniaojin.ddd.application.service.blog;

import com.feiniaojin.ddd.application.service.blog.dto.PublishCommand;
import com.feiniaojin.ddd.domain.entity.BlogEntity;
import com.feiniaojin.ddd.domain.factory.BlogEntityFactory;
import com.feiniaojin.ddd.domain.repository.BlogEntityRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * <p>BlogApplicationService</p>
 *
 * @author thy
 */
@Component
public class BlogApplicationService {

    @Resource
    private BlogEntityFactory blogEntityFactory;

    @Resource
    private BlogEntityRepository blogEntityRepository;


    public void publish(PublishCommand command) {
        BlogEntity entity = blogEntityFactory.newInstance(command.getTitle(),
                command.getContent(), command.getUserId());
        entity.publish();
        blogEntityRepository.save(entity);
    }
}
