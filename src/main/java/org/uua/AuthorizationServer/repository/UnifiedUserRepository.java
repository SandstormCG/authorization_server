package org.uua.AuthorizationServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uua.AuthorizationServer.entity.UnifiedUser;

import java.util.Optional;

public interface UnifiedUserRepository extends JpaRepository<UnifiedUser, Integer> {

    Optional<UnifiedUser> findByUsername(String username);
}
