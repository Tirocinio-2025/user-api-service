package tech.aesys.finale.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.aesys.finale.user.dto.UserDetailResponseDTO;
import tech.aesys.finale.user.model.AuthRequest;
import tech.aesys.finale.user.resolver.Username;
import tech.aesys.finale.user.service.AuthService;
import tech.aesys.finale.user.service.UserService;

@RestController
@RequestMapping("/user")
public @RequiredArgsConstructor class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<UserDetailResponseDTO> getuser(@Username String username) {
        var response = userService.getByUsername(username)
                .map(user -> UserDetailResponseDTO.builder()
                        .username(user.getUsername())
                        .roles(user.getUserRoles().stream()
                                .map(role -> tech.aesys.finale.user.dto.RoleResponseDTO.builder()
                                        .role(role.getRole().getName())
                                        .build())
                                .toList())
                        .build())
                .orElseThrow(() -> new RuntimeException("User not found"));;
        return ResponseEntity.ok(response);
    }

}