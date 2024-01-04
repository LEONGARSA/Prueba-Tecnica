package com.PruebaPractica.PruebaApiRest.Auth;

import java.time.LocalDate;

import org.apache.catalina.connector.Request;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.PruebaPractica.PruebaApiRest.Jwt.JwtService;
import com.PruebaPractica.PruebaApiRest.PaqueteUsuario.ClaseUsuario;
import com.PruebaPractica.PruebaApiRest.PaqueteUsuario.RepositorioUsuario;
import com.PruebaPractica.PruebaApiRest.PaqueteUsuario.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final RepositorioUsuario repositorioUsuario;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getMobilePhone(), request.getPassword()));
        UserDetails user=repositorioUsuario.findByMobilePhone(request.getMobilePhone()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        ClaseUsuario claseUsuario = ClaseUsuario.builder()

            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .dateBirth(request.getDateBirth())
            .address(request.getAddress())          
            .password(request.getPassword())
            .mobilePhone(request.getMobilePhone())
            .email(request.getEmail())
            .role(Role.USER)
            .build();
        repositorioUsuario.save(claseUsuario);

        return AuthResponse.builder()
            .token(jwtService.getToken(claseUsuario))
            .build();

    }

}
