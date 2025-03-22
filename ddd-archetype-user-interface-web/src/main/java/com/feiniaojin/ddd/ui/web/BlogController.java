package com.feiniaojin.ddd.ui.web;

import com.feiniaojin.ddd.application.service.blog.BlogApplicationService;
import com.feiniaojin.ddd.application.service.blog.dto.DeleteCommand;
import com.feiniaojin.ddd.application.service.blog.dto.PublishCommand;
import com.feiniaojin.ddd.ui.web.config.Auth;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <p>BlogController</p>
 *
 * @author thy
 */
@RequestMapping("/blog")
@RestController
public class BlogController {

    @Resource
    private BlogApplicationService blogApplicationService;

    /**
     * 仅将应用层的方法向外暴露
     */
    @Auth
    @PostMapping("/publish")
    public void publish(@RequestBody PublishCommand command, HttpServletRequest req) {
        command.setUserId((Integer) req.getAttribute("userId"));
        blogApplicationService.publish(command);
    }

    @Auth
    @PostMapping("/delete")
    public void delete(@RequestBody DeleteCommand command, HttpServletRequest req) {
        command.setUserId((Integer) req.getAttribute("userId"));
        blogApplicationService.delete(command);
    }

}
