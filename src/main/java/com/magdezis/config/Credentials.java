/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.magdezis.config;

/**
 *
 * @author AGUILON
 */
public class Credentials {
    public static final String URL_DB = System.getenv("URL_MYSQL_DB")+"/login_proyecto_in4bm";
    public static final String USER_DB = System.getenv("USER_MYSQL_DB");
    public static final String PASS_DB = System.getenv("PASS_DB");
}
