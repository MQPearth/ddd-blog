package com.feiniaojin.ddd.application.service.user.dto.command;

import lombok.Data;

/**
 * <p>LoginCommand</p>
 *
 * @author thy
 */
@Data
public class LoginCommand {
    private String name;
    private String password;
}
