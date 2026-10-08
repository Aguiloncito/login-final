/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.magdezis.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import main.java.com.magdezis.config.DataBaseConnection;
import main.java.com.magdezis.dto.request.LoginRequest;
import main.java.com.magdezis.dto.request.RegisterRequest;
import main.java.com.magdezis.dto.response.LoginResponse;
import main.java.com.magdezis.dto.response.RegisterResponse;

/**
 *
 * @author AGUILON
 */
public class AuthRepository {
    //rol que se asigna a los usuarios que se registran desde la aplicacion
    //(debe existir en la tabla roles, ver PROYECTO_FINAL.sql)
    public static final int ID_ROL_USUARIO = 2;

    public LoginResponse findUserByEmail(LoginRequest loginRequest)throws SQLException{
        String sql = "select id_usuarios, id_rol, nombres, apellidos, contraseña_hash" +
            " from usuarios" +
            " where email = ? ";
        try(PreparedStatement pstm = DataBaseConnection.getConnectionDataBase().prepareStatement(sql)){
            pstm.setString(1, loginRequest.getEmail());
            try(ResultSet rs = pstm.executeQuery()){
                if(rs.next()){
                    return new LoginResponse(
                            rs.getInt("id_usuarios"),
                            rs.getInt("id_rol"),
                            rs.getString("nombres"),
                            rs.getString("apellidos"),
                            rs.getString("contraseña_hash"));
                }
            }
        }catch(SQLException e){
            System.out.println("Error al encontrar el USUARIO; " + e.getMessage());
        }
        return null;
    }

    //verifica si ya existe un usuario registrado con ese email
    public boolean existsByEmail(String email) throws SQLException{
        String sql = "select id_usuarios from usuarios where email = ?";
        try(PreparedStatement pstm = DataBaseConnection.getConnectionDataBase().prepareStatement(sql)){
            pstm.setString(1, email);
            try(ResultSet rs = pstm.executeQuery()){
                return rs.next();
            }
        }
    }

    //inserta un nuevo usuario en la base de datos (id_usuarios es AUTO_INCREMENT)
    public RegisterResponse save(RegisterRequest registerRequest) throws SQLException{
        String sql = "insert into usuarios (id_rol, nombres, apellidos, email, contraseña_hash) values (?, ?, ?, ?, ?)";
        try(PreparedStatement pstm = DataBaseConnection.getConnectionDataBase().prepareStatement(sql)){
            pstm.setInt(1, ID_ROL_USUARIO);
            pstm.setString(2, registerRequest.getNombres());
            pstm.setString(3, registerRequest.getApellidos());
            pstm.setString(4, registerRequest.getEmail());
            pstm.setString(5, registerRequest.getContraseña_hash());
            pstm.executeUpdate();
        }
        return new RegisterResponse(registerRequest.getNombres(), registerRequest.getApellidos(), registerRequest.getEmail());
    }
}
