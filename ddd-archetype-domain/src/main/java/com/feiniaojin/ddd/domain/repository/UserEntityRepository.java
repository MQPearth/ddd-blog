package com.feiniaojin.ddd.domain.repository;


import com.feiniaojin.ddd.domain.entity.UserEntity;

/**
 * <p>UserEntityRepository</p>
 *
 * @author thy
 */
public interface UserEntityRepository {

    UserEntity load(String name);

    void save(UserEntity user);
}
