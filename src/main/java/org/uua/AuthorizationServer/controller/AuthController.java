package org.uua.AuthorizationServer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.uua.AuthorizationServer.dto.CreateUnifiedUserDTO;
import org.uua.AuthorizationServer.dto.MessageDTO;
import org.uua.AuthorizationServer.service.UnifiedUserService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UnifiedUserService unifiedUserService;

    public ResponseEntity<MessageDTO> createUser(@RequestBody CreateUnifiedUserDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(unifiedUserService.createUser(dto));
    }
}
