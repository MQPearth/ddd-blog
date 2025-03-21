package com.feiniaojin.ddd.domain.repository;


import com.feiniaojin.ddd.domain.entity.BlogEntity;

/**
 * <p>BlogEntityRepository</p>
 *
 * @author thy
 */
public interface BlogEntityRepository {

    BlogEntity load(Integer id);

    void save(BlogEntity blog);
}
