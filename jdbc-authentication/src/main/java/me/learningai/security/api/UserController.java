package me.learningai.security.api;

import io.swagger.annotations.ApiOperation;
import me.learningai.security.api.request.UserRequest;
import me.learningai.security.core.AuthorityUser;
import me.learningai.security.entity.User;
import me.learningai.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping("/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value = "创建用户", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }

    @ApiOperation(value = "当前登录用户", httpMethod = "GET")
    @GetMapping("/me")
    public User me(@AuthenticationPrincipal AuthorityUser user) {
        return userService.findByUsername(user.getUsername());
    }
}
