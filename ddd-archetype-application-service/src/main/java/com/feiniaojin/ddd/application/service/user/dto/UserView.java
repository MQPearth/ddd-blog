package com.feiniaojin.ddd.application.service.user.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * <p>UserView</p>
 *
 * @author thy
 */
@Data
public class UserView {

    private Integer id;
    private String name;
    private LocalDateTime createDate;
}
