package org.uua.AuthorizationServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uua.AuthorizationServer.entity.Role;
import org.uua.AuthorizationServer.entity.UnifiedUser;
import org.uua.AuthorizationServer.enums.RoleName;
import org.uua.AuthorizationServer.repository.RoleRepository;
import org.uua.AuthorizationServer.repository.UnifiedUserRepository;

import java.util.Set;

@SpringBootApplication
public class AuthorizationServerApplication /*implements CommandLineRunner*/ {

	/*@Autowired
	RoleRepository roleRepository;
	@Autowired
	UnifiedUserRepository unifiedUserRepository;
*/
	public static void main(String[] args) {
		SpringApplication.run(AuthorizationServerApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Role adminRole = Role.builder().role(RoleName.ROLE_ADMIN).build();
		Role userRole = Role.builder().role(RoleName.ROLE_USER).build();

		UnifiedUser adminUser = UnifiedUser.builder().username("admin").password("admin").roles(Set.of(adminRole)).build();
		UnifiedUser regularUser = UnifiedUser.builder().username("user").password("password").roles(Set.of(userRole)).build();

		roleRepository.save(adminRole);
		roleRepository.save(userRole);

		unifiedUserRepository.save(adminUser);
		unifiedUserRepository.save(regularUser);
	}*/
}
