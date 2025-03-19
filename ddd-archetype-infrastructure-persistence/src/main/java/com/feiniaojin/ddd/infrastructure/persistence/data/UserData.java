package com.feiniaojin.ddd.infrastructure.persistence.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>User</p>
 *
 * @author thy
 */
@TableName("user")
@Data
public class UserData {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String password;

    private LocalDateTime createDate;
}
