package me.learningai.security.api;

import io.swagger.annotations.ApiOperation;
import me.learningai.security.api.request.AuthorityRequest;
import me.learningai.security.entity.Authority;
import me.learningai.security.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author heyx
 */
@RestController
@RequestMapping("/v1/authority")
public class AuthorityController {
    private final AuthorityService authorityService;

    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    @ApiOperation(value = "创建Authority", httpMethod = "POST")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Authority createAuthority(@RequestBody AuthorityRequest authorityRequest) {
        return authorityService.createAuthority(authorityRequest);
    }
}
