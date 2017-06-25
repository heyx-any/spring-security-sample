package me.learningai.common.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author heyx
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
}
