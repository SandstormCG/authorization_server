package org.uua.AuthorizationServer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.uua.AuthorizationServer.dto.CreateUnifiedUserDTO;
import org.uua.AuthorizationServer.dto.MessageDTO;
import org.uua.AuthorizationServer.entity.Role;
import org.uua.AuthorizationServer.entity.UnifiedUser;
import org.uua.AuthorizationServer.enums.RoleName;
import org.uua.AuthorizationServer.repository.RoleRepository;
import org.uua.AuthorizationServer.repository.UnifiedUserRepository;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class UnifiedUserService {

    private final UnifiedUserRepository unifiedUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public MessageDTO createUser(CreateUnifiedUserDTO dto){
        UnifiedUser unifiedUser = UnifiedUser.builder()
                .username(dto.username())
                .password(passwordEncoder.encode(dto.password()))
                .build();
        Set<Role> roles = new HashSet<>();
        dto.roles().forEach(r -> {
            Role role = roleRepository.findByRole(RoleName.valueOf(r))
                    .orElseThrow( () -> new RuntimeException("Role not found"));
            roles.add(role);
        });
        unifiedUser.setRoles(roles);
        unifiedUserRepository.save(unifiedUser);
        return new MessageDTO("user " + unifiedUser.getUsername() +  " saved");
    }
}
