package org.uua.AuthorizationServer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.uua.AuthorizationServer.entity.Role;
import org.uua.AuthorizationServer.enums.RoleName;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    Optional<Role> findByRole(RoleName roleName);
}
