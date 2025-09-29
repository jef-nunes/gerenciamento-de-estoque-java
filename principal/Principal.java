/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package principal;
import conexao.ConexaoMySQL;
import dao.SchemaDAO;
import controle.UsuarioControle;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;
import view.TelaLogin;
import view.TelaSignup;
import view.GerenciaTelas;

/**
 *
 * @author jefadmin
 */
public class Principal {
    
    // Testes em desenvolvimento
    private static void testes(){
        UsuarioControle usuarioCtrl = new UsuarioControle();
        usuarioCtrl.cadastrar("abc@exemplo.com", "1234", "Abc");
        usuarioCtrl.cadastrar("def@exemplo.com", "5678", "Def");
        ArrayList<Usuario> listaUsuarios = usuarioCtrl.listar();
        for(Usuario usuario : listaUsuarios){
            usuario.exibirDados();
        }
    }

    public static void main(String[] args) {
        // Se o argumento --dev for passado
        // Isso afeta a senha utilizada
        // pela conexão ao banco de dados
        for(String arg:args){
            // Se em ambiente de desenvolvimento
            if(arg.equalsIgnoreCase("--dev")){
                System.out.println("[Ambiente de Desenvolvimento]");
                Variaveis.setDev(true);
            }
        }
        // Prepara o banco de dados
        SchemaDAO.iniciar();
        
        // Testes em ambiente de desenvolvimento
        if(Variaveis.isDev()){
            testes();
        }
        GerenciaTelas.iniciar();
    }
}
