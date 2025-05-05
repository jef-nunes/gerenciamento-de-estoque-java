/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;

import dao.ProdutoDAO;
import java.util.ArrayList;
import modelo.Produto;

/**
 *
 * @author jefadmin
 */
public class ProdutoControle {
    private ProdutoDAO dao = new ProdutoDAO();
    
    public void registrar(String nomeProduto, float valorUnidade, int quantidadeDisponivel, int usuarioID, String nomeCategoria){
        // Usuario u = new Usuario(email, senha, nome);
        Produto p = new Produto(-1,-1,-1,nomeProduto,valorUnidade,quantidadeDisponivel);
        dao.inserir(p,nomeCategoria,usuarioID);
    }
    
    public String obterNomeResponsavel(int usuarioID){
        return dao.obterNomeUsuario(0);
    }
    
    public ArrayList<Produto> listar(){
        return dao.listar();
    }
}
