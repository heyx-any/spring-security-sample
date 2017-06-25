package me.learningai.security.api.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author heyx
 */
@Data
public class UserRequest implements Serializable {
    private String username;
    private String password;
    private List<Long> authorityIds;
}
