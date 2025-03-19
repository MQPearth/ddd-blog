package com.feiniaojin.ddd.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feiniaojin.ddd.infrastructure.persistence.data.UserData;
import org.springframework.stereotype.Repository;

/**
 * <p>UserMapper</p>
 *
 * @author thy
 */
@Repository
public interface UserMapper extends BaseMapper<UserData> {
}
