package com.feiniaojin.ddd.domain.factory;


import com.feiniaojin.ddd.domain.entity.UserEntity;

/**
 * <p>UserEntityFactory</p>
 *
 * @author thy
 */
public interface UserEntityFactory {
    UserEntity newInstance(String name, String password);
}
