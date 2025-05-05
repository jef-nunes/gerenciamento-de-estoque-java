/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import dao.CategoriaDAO;
import java.util.ArrayList;
import modelo.Categoria;

/**
 *
 * @author jefadmin
 */
public class CategoriaControle {
    private CategoriaDAO dao = new CategoriaDAO();
    
    public void registrar(String nome){
        Categoria c = new Categoria(-1,nome);
        dao.inserir(c);
    }
    
    public boolean categoriaRegistrada(String nome){
        return dao.categoriaRegistrada(nome);
    }
    
    public ArrayList<Categoria> listar(){
        return dao.listar();
    }
}
