package me.learningai.security.core;

import me.learningai.security.entity.Authority;
import me.learningai.security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author heyx
 */
public class AuthorityUser implements UserDetails {
    private User user;

    public AuthorityUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Optional.ofNullable(user.getAuthorities()).orElse(Collections.emptyList()).stream()
            .map(this::convertToAuthority).collect(Collectors.toList());
    }

    private GrantedAuthority convertToAuthority(Authority authority) {
        return new SimpleGrantedAuthority(authority.getName());
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }
}
