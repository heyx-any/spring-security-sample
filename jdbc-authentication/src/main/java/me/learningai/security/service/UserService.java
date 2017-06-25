package me.learningai.security.service;

import me.learningai.security.api.request.UserRequest;
import me.learningai.security.entity.User;
import me.learningai.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author heyx
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder,
                       AuthorityService authorityService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityService = authorityService;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User createUser(UserRequest userRequest) {
        User user = convertUser(userRequest);
        user.setEnabled(true);
        return userRepository.save(user);
    }

    private User convertUser(UserRequest userRequest) {
        return User.builder().username(userRequest.getUsername())
            .password(encodePassword(userRequest.getPassword()))
            .authorities(authorityService.findByIds(userRequest.getAuthorityIds()))
            .build();
    }

    private String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
