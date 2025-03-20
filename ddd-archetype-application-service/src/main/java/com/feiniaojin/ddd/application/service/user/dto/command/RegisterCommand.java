package com.feiniaojin.ddd.application.service.user.dto.command;

import lombok.Data;

/**
 * <p>RegisterCommand</p>
 *
 * @author thy
 */
@Data
public class RegisterCommand {
    private String name;
    private String password;
}
