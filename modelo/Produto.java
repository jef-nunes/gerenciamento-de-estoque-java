/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jefadmin
 */
public class Produto {
    // ID do produto (chave primária)
    private int produtoID;
    // ID da categoria do produto (chave estrangeira)
    private int categoriaID;
    // ID do usuario que registrou o produto (chave estrangeira)
    private int usuarioID;
    // Nome
    private String nome;
    // Valor da unidade (preço)
    private float valorUnidade;
    // Quantidade disponivel
    private int quantidadeDisponivel;

    public Produto(int produtoID, int categoriaID, int usuarioID, String nome, float valorUnidade, int quantidadeDisponivel) {
        this.produtoID = produtoID;
        this.categoriaID = categoriaID;
        this.usuarioID = usuarioID;
        this.nome = nome;
        this.valorUnidade = valorUnidade;
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public int getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(int categoriaID) {
        this.categoriaID = categoriaID;
    }

    public int getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(int usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(float valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }
}
