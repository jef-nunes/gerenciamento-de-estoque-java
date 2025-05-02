/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jefadmin
 */
public class Categoria {
    // ID da categoria de produto (chave primária)
    private int categoriaID;
    // Nome
    private String nome;

    public Categoria(int categoriaID, String nome) {
        this.categoriaID = categoriaID;
        this.nome = nome;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
