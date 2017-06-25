package me.learningai.security.api.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author heyx
 */
@Data
public class AuthorityRequest implements Serializable {
    private String name;
    private String description;
}
