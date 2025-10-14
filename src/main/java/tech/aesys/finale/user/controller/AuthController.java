package tech.aesys.finale.user.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.aesys.finale.user.service.AuthService;

@RestController
@RequestMapping("/auth")
public @RequiredArgsConstructor class AuthController {


    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Void> login() {
        authService.login();
        return ResponseEntity.ok().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout() {
        authService.logout();
        return ResponseEntity.ok().build();
    }




}
