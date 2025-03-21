package com.feiniaojin.ddd.ui.web;

import com.feiniaojin.ddd.application.service.user.TokenApplicationService;
import com.feiniaojin.ddd.application.service.user.UserApplicationService;
import com.feiniaojin.ddd.application.service.user.dto.command.LoginCommand;
import com.feiniaojin.ddd.application.service.user.dto.command.RegisterCommand;
import com.feiniaojin.ddd.application.service.user.dto.view.LoginView;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>UserController</p>
 *
 * @author thy
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    UserApplicationService userApplicationService;

    @Resource
    TokenApplicationService tokenApplicationService;

    /**
     * 仅将应用层的方法向外暴露
     */
    @PostMapping("/register")
    public void register(@RequestBody RegisterCommand command) {
        userApplicationService.register(command);
    }

    @PostMapping("/login")
    public LoginView login(@RequestBody LoginCommand command) {
        return tokenApplicationService.login(command);
    }
}
