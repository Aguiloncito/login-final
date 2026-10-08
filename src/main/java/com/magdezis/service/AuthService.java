/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.magdezis.service;

import main.java.com.magdezis.dto.request.LoginRequest;
import main.java.com.magdezis.dto.request.RegisterRequest;
import main.java.com.magdezis.dto.response.LoginResponse;
import main.java.com.magdezis.dto.response.RegisterResponse;
import main.java.com.magdezis.repository.AuthRepository;
import main.java.com.magdezis.security.jbcrypt.BCrypt;

/**
 *
 * @author AGUILON
 */
public class AuthService {
    private final AuthRepository authRepository;
    private boolean status = false;
    public AuthService(AuthRepository authRepository){
        this.authRepository = authRepository;
    }
public LoginResponse login (LoginRequest loginRequest) throws Exception{
    if ((loginRequest == null)) {
        throw new RuntimeException("Credenciales vacias.");
    }else if(loginRequest.getEmail()== null || loginRequest.getContraseña()== null){
        throw new RuntimeException("El usuario o la contraseña no pueden estar vacios");
    }
    LoginResponse response = authRepository.findUserByEmail(loginRequest);
    if (response== null) {
        throw new RuntimeException("Usuario no encontado");
    }
  String contrasenaHashed = response.getContraseña_hash();
  if(contrasenaHashed == null){
      throw new RuntimeException("contrasena invalida.");
  }else{
      if (BCrypt.checkpw(loginRequest.getContraseña(),contrasenaHashed )){
          return response;
      }
  }
      throw new RuntimeException("Contraseña incorrecta.");
}

public RegisterResponse register(RegisterRequest registerRequest) throws Exception{
    if(registerRequest == null){
        throw new RuntimeException("Datos de registro vacios.");
    }
    if(isBlank(registerRequest.getNombres()) || isBlank(registerRequest.getApellidos())
            || isBlank(registerRequest.getContraseña_hash()) || isBlank(registerRequest.getEmail())){
        throw new RuntimeException("Todos los campos son obligatorios.");
    }
    if(authRepository.existsByEmail(registerRequest.getEmail())){
        throw new RuntimeException("Ya existe un usuario registrado con ese correo.");
    }
    String contrasenaHasheada = BCrypt.hashpw(registerRequest.getContraseña_hash(), BCrypt.gensalt());
    registerRequest.setContraseña_hash(contrasenaHasheada);
    return authRepository.save(registerRequest);
}

private boolean isBlank(String texto){
    return texto == null || texto.trim().isEmpty();
}
}
