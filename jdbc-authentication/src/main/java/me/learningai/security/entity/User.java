package me.learningai.security.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.learningai.common.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author heyx
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User extends BaseEntity {
    private String username;
    @JsonIgnore
    private String password;
    private Boolean enabled;
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Authority> authorities;
}
