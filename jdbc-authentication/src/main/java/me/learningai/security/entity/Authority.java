package me.learningai.security.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import me.learningai.common.entity.BaseEntity;

import javax.persistence.Entity;
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
public class Authority extends BaseEntity {
    private String name;
    private String description;
    @ManyToMany(mappedBy = "authorities")
    private List<User> users;
}
