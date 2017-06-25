package me.learningai.security.core;

import me.learningai.security.entity.User;
import me.learningai.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author heyx
 */
public class SpringDataUserDetailsService implements UserDetailsService {
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("username:" + username + " not found");
        }
        return new AuthorityUser(user);
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
