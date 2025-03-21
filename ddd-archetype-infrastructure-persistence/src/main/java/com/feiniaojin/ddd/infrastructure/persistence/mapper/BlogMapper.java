package com.feiniaojin.ddd.infrastructure.persistence.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.feiniaojin.ddd.infrastructure.persistence.data.BlogData;
import org.springframework.stereotype.Repository;

/**
 * <p>BlogMapper</p>
 *
 * @author thy
 */
@Repository
public interface BlogMapper extends BaseMapper<BlogData> {
}
