package com.feiniaojin.ddd.infrastructure.persistence.repository;

import com.feiniaojin.ddd.domain.entity.BlogEntity;
import com.feiniaojin.ddd.domain.repository.BlogEntityRepository;
import com.feiniaojin.ddd.infrastructure.persistence.data.BlogData;
import com.feiniaojin.ddd.infrastructure.persistence.mapper.BlogMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * <p>BlogEntityRepositoryImpl</p>
 *
 * @author thy
 */
@Component
public class BlogEntityRepositoryImpl implements BlogEntityRepository {

    @Resource
    private BlogMapper blogMapper;

    @Override
    public BlogEntity load(Integer id) {
        BlogData blogData = blogMapper.selectById(id);
        if (blogData == null) {
            return null;
        }
        BlogEntity entity = new BlogEntity();
        entity.setTitle(blogData.getTitle());
        entity.setContent(blogData.getContent());
        entity.setId(blogData.getId());
        entity.setUserId(blogData.getUserId());
        entity.setStatus(blogData.getStatus());
        entity.setCreateDate(blogData.getCreateDate());
        return entity;
    }

    @Override
    public void save(BlogEntity blog) {
        if (Objects.isNull(blog)) {
            throw new NullPointerException();
        }
        BlogData blogData = new BlogData();
        blogData.setTitle(blog.getTitle());
        blogData.setContent(blog.getContent());
        blogData.setUserId(blog.getUserId());
        blogData.setStatus(blog.getStatus());
        blogData.setCreateDate(blog.getCreateDate());
        if (Objects.isNull(blog.getId())) {
            blogMapper.insert(blogData);
        } else {
            blogData.setId(blog.getId());
            blogMapper.updateById(blogData);
        }
    }
}
