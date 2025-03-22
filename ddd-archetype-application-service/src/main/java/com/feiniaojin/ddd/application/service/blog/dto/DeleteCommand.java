package com.feiniaojin.ddd.application.service.blog.dto;

import lombok.Data;

/**
 * <p>DeleteCommand</p>
 *
 * @author thy
 */
@Data
public class DeleteCommand {
    private Integer blogId;
    private Integer userId;
}
