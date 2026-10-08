/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.magdezis.dto.response;

/**
 *
 * @author AGUILON
 */
public class LoginResponse {
    private int idUsuario;
    private int idRol;
    private String nombres;
    private String apellidos;
    private String contraseña_hash;

    public LoginResponse(int idUsuario, int idRol, String nombres, String apellidos, String contraseña_hash) {
        this.idUsuario = idUsuario;
        this.idRol = idRol;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contraseña_hash = contraseña_hash;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
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

    //nombre completo para mostrar en la vista de bienvenida
    public String getNombreCompleto() {
        return (nombres + " " + apellidos).trim();
    }

    public String getContraseña_hash() {
        return contraseña_hash;
    }

    public void setContraseña_hash(String contraseña_hash) {
        this.contraseña_hash = contraseña_hash;
    }
    
}
