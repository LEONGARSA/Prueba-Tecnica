package com.PruebaPractica.PruebaApiRest.Auth;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;


@Data
@Builder
@AllArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private LocalDate dateBirth;
    private String address;
    private String password;
    private String mobilePhone;
    private String email;

}
