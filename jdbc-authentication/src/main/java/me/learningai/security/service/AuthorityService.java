package me.learningai.security.service;

import me.learningai.security.api.request.AuthorityRequest;
import me.learningai.security.entity.Authority;
import me.learningai.security.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author heyx
 */
@Service
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Autowired
    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public List<Authority> findByIds(List<Long> authorityIds) {
        return authorityRepository.findByIdIn(authorityIds);
    }

    public Authority createAuthority(AuthorityRequest authorityRequest) {
        return authorityRepository.save(convertToAuthority(authorityRequest));
    }

    private Authority convertToAuthority(AuthorityRequest authorityRequest) {
        return Authority.builder().name(authorityRequest.getName())
            .description(authorityRequest.getDescription()).build();
    }
}
