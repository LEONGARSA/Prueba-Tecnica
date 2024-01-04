package com.PruebaPractica.PruebaApiRest.PaqueteUsuario;


import java.time.LocalDate;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class ClaseUsuario implements UserDetails{
    @Id
    @GeneratedValue
    private Integer id;

    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NonNull 
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NonNull
    @Column(name = "date_birth", nullable = false)
    private LocalDate dateBirth;

    @NonNull
    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "token")
    private String token; // Puede ser null

    @NonNull
    @Column(name = "password", nullable = false, length = 120)
    private String password;

    @NonNull
    @Column(name = "mobile_phone", nullable = false, unique = true)
    private String mobilePhone;

    @NonNull
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @NonNull
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       return List.of(new SimpleGrantedAuthority((role.name())));
    }

    @Override
    public String getUsername() {
       return mobilePhone;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
