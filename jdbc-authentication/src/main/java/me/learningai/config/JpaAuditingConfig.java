package me.learningai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Spring data jpa配置
 * @author heyx
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
}
