package com.feiniaojin.ddd.ui.web;

import com.feiniaojin.ddd.application.service.user.UserApplicationService;
import com.feiniaojin.ddd.application.service.user.dto.RegisterCommand;
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
    UserApplicationService applicationService;

    @PostMapping("/register")
    public void register(@RequestBody RegisterCommand command) {
        applicationService.register(command);
    }
}
