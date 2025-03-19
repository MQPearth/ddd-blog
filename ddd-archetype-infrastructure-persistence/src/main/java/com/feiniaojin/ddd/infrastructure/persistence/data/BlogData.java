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
@TableName("blog")
@Data
public class BlogData {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String title;

    private String content;

    private LocalDateTime createDate;

    private Integer status;
}
