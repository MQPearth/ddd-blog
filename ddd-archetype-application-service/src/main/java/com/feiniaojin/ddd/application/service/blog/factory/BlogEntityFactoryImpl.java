package com.feiniaojin.ddd.application.service.blog.factory;

import com.feiniaojin.ddd.domain.entity.BlogEntity;
import com.feiniaojin.ddd.domain.factory.BlogEntityFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * <p>BlogEntityFactoryImpl</p>
 *
 * @author thy
 */
@Component
public class BlogEntityFactoryImpl implements BlogEntityFactory {


    @Override
    public BlogEntity newInstance(String title, String content, Integer userId) {
        if (StringUtils.isBlank(title)) {
            throw new RuntimeException("标题不允许为空");
        }

        if (StringUtils.isBlank(content)) {
            throw new RuntimeException("内容不允许为空");
        }
        BlogEntity entity = new BlogEntity();
        entity.setTitle(title);
        entity.setContent(content);
        entity.setUserId(userId);
        return entity;
    }
}
