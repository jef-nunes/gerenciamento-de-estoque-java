/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jefadmin
 */
public class Movimentacao {
    // As constantes abaixo são utilizadas pela
    // variável tipoFluxo para indicar o 
    // sentido da movimentação de estoque
    private static final String ENTRADA = "Entrada";
    private static final String SAIDA = "Saída";
    // ID da movimentação (chave primária)
    private int movimentacaoID;
    // ID do produto (chave estrangeira)
    private int produtoID;
    // ID do usuario que realizou a movimentação (chave estrangeira)
    private int usuarioID;
    // Indica se o fluxo é de entrada ou saída
    private String tipoFluxo;
    // Quantidade de produtos que foram movimentados
    private int quantidade;

    public Movimentacao(int movimentacaoID, int produtoID, String tipoFluxo, int quantidade) {
        this.movimentacaoID = movimentacaoID;
        this.produtoID = produtoID;
        this.tipoFluxo = tipoFluxo;
        this.quantidade = quantidade;
    }

    public int getMovimentacaoID() {
        return movimentacaoID;
    }

    public void setMovimentacaoID(int movimentacaoID) {
        this.movimentacaoID = movimentacaoID;
    }

    public int getProdutoID() {
        return produtoID;
    }

    public void setProdutoID(int produtoID) {
        this.produtoID = produtoID;
    }

    public String getTipoFluxo() {
        return tipoFluxo;
    }

    public void setTipoFluxo(String tipoFluxo) {
        this.tipoFluxo = tipoFluxo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
