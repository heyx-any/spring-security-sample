package me.learningai.security.repository;

import me.learningai.security.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author heyx
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
    List<Authority> findByIdIn(List<Long> authorityIds);
}
