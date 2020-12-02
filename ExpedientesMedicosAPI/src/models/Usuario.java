/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author P
 */
public class Usuario {
    private String username;
    private String password;
    private int rol;
    private String identificador;

    public Usuario() {
        this.username = "";
        this.password = "";
        this.rol = 0;
        this.identificador = "";
    }
    
    public Usuario(String username, String password, int rol, String identificador) {
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.identificador = identificador;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
}
