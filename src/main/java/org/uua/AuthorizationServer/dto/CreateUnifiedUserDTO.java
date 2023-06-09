package org.uua.AuthorizationServer.dto;

import java.util.List;

public record CreateUnifiedUserDTO(String username,
                                   String password,
                                   List<String> roles)
{

}
