package com.week3.Library_Management.auth;

import com.week3.Library_Management.entities.AuditableEntity;
import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImplementation implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Mritunjay Pratap Singh");
    }
}
