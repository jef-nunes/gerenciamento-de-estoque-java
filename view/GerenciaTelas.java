/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controle.UsuarioControle;
/**
 *
 * @author jefadmin
 */
public class GerenciaTelas {
    public static UsuarioControle usuarioControle = new UsuarioControle();
    private static TelaLogin telaLogin;
    private static TelaSignup telaSignup;
    // Renderiza apenas a tela especificada
    public static void definirTelaAtual(String nomeTela){
        switch(nomeTela){
            case "login":
                telaSignup.setVisible(false);
                telaLogin.setVisible(true);
                break;
            case "signup":
                telaLogin.setVisible(false);
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
    }
}
