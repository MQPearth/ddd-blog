package com.feiniaojin.ddd.application.service.blog.dto;

import lombok.Data;

/**
 * <p>PublishCommand</p>
 *
 * @author thy
 */
@Data
public class PublishCommand {
    private String title;
    private String content;
    private Integer userId;
}
