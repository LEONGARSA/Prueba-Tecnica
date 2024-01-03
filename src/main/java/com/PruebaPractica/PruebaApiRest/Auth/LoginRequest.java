package com.PruebaPractica.PruebaApiRest.Auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class LoginRequest {

    String mobilePhone;
    String password;
    
}
