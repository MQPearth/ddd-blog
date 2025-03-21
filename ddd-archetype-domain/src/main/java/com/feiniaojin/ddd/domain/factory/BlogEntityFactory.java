package com.feiniaojin.ddd.domain.factory;


import com.feiniaojin.ddd.domain.entity.BlogEntity;

/**
 * <p>BlogEntityFactory</p>
 *
 * @author thy
 */
public interface BlogEntityFactory {

    BlogEntity newInstance(String title, String content, Integer userId);
}
