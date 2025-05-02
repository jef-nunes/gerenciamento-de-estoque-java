/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jefadmin
 */
public class Usuario {
    // ID do usuário (chave primária)
    private int usuarioID;
    // Email de login
    private String email;
    // Senha de login (hash)
    private String senha;
    
    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Usuario(int usuarioID, String email, String senha) {
        this.usuarioID = usuarioID;
        this.email = email;
        this.senha = senha;
    }
}
