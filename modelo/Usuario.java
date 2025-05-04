/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import principal.Variaveis;
/**
 *
 * @author jefadmin
 */
public class Usuario {
    // ID do usuário (chave primária)
    private int usuarioID;
    // Email de login
    private String email;
    // Nome real do usuário
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    // Senha de login (hash SHA256)
    // ou seja uma string de 64 caracteres
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

    public void exibirDados(){
        if(Variaveis.isDev()){
            System.out.println("[Usuario]");
            System.out.println("ID: "+this.usuarioID);
            System.out.println("Email: "+this.email);
            System.out.println("Senha: "+this.senha);
            System.out.println("Nome: "+this.nome);
            System.out.println("");
        }
    }
    
    public Usuario(int usuarioID, String email, String senha, String nome) {
        this.usuarioID = usuarioID;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }
}
