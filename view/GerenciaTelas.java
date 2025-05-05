/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controle.CategoriaControle;
import controle.ProdutoControle;
import controle.UsuarioControle;
import modelo.Usuario;
/**
 *
 * @author jefadmin
 */
public class GerenciaTelas {
    public static Usuario usuarioLogado;
    public static UsuarioControle usuarioControle = new UsuarioControle();
    public static CategoriaControle categoriaControle = new CategoriaControle();
    public static ProdutoControle produtoControle = new ProdutoControle();
    public static TelaLogin telaLogin;
    public static TelaSignup telaSignup;
    public static TelaEstoque telaEstoque;
    // Renderiza apenas a tela especificada
    public static void definirTelaAtual(String nomeTela){
        switch(nomeTela){
            case "estoque":
                telaSignup.setVisible(false);
                telaLogin.setVisible(false);
                telaEstoque.setVisible(true);
                break;
            case "login":
                telaSignup.setVisible(false);
                telaEstoque.setVisible(false);
                telaLogin.setVisible(true);
                break;
            case "signup":
                telaLogin.setVisible(false);
                telaEstoque.setVisible(false);
                telaSignup.setVisible(true);
                break;
            default:
                break;
        }
    }
    // Responsavel por iniciar a interface gráfica
    public static void iniciar(){
        telaLogin = new TelaLogin();
        telaLogin.setLocationRelativeTo(null);
        telaLogin.setResizable(false);
        telaLogin.setVisible(true);
        
        telaSignup = new TelaSignup();
        telaSignup.setLocationRelativeTo(null);
        telaSignup.setResizable(false);
        
        telaEstoque = new TelaEstoque();
        telaEstoque.setLocationRelativeTo(null);
        telaEstoque.setResizable(false);
    }
}