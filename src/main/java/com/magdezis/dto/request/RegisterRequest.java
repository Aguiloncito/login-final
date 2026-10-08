/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.magdezis.dto.request;

/**
 *
 * @author AGUILON
 */
public class RegisterRequest {
    private String nombres;
    private String apellidos;
    private String email;
    private String contraseña_hash;

    public RegisterRequest(String nombres, String apellidos, String email, String contraseña_hash) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.contraseña_hash = contraseña_hash;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña_hash() {
        return contraseña_hash;
    }

    public void setContraseña_hash(String contraseña_hash) {
        this.contraseña_hash = contraseña_hash;
    }
    
    
}
