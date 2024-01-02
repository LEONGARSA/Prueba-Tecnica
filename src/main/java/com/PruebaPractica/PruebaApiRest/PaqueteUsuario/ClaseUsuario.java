package com.PruebaPractica.PruebaApiRest.PaqueteUsuario;


import java.time.LocalDate;
import java.util.Date;

import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClaseUsuario {
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
    @Column(name = "mobile_phone", nullable = false)
    private String mobilePhone;

    @NonNull
    @Column(name = "email", nullable = false)
    private String email;
}
