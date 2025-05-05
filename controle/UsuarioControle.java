/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controle;
import dao.UsuarioDAO;
import modelo.Usuario;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HexFormat;

/**
 *
 * @author jefadmin
 */
public class UsuarioControle {
    private UsuarioDAO dao = new UsuarioDAO();
    
    public String criptografarSenha(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
            return HexFormat.of().formatHex(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritmo SHA-256 não encontrado.", e);
        }
    }
    
    public void cadastrar(String email, String senha, String nome){
        // Usuario u = new Usuario(email, senha, nome);
        String senhaCripto = criptografarSenha(senha);
        Usuario u = new Usuario(-1,email,senhaCripto,nome);
        dao.inserir(u);
    }
    
    public boolean emailRegistrado(String email){
        return dao.emailRegistrado(email);
    }
    
    public boolean autenticar(String email, String senha){
        return dao.autenticar(email,senha);
    }
    
    public ArrayList<Usuario> listar(){
        return dao.listar();
    }
}
