/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexao.ConexaoMySQL;
import java.util.ArrayList;
import modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jefadmin
 */
public class UsuarioDAO {
    
    // Retornar um usuario a partir das credenciais de login
    public Usuario obterUsuarioPorLogin(String email, String senha){
        Usuario u;
        String sql = "SELECT * FROM usuario WHERE email= ? AND senha = ?;";
        try (Connection con = ConexaoMySQL.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                u = new Usuario(
                        rs.getInt("usuario_id"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome")
                );
                return u;
            }
            else{
                u = new Usuario(-1,"?","?","?");
                return u;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            u = new Usuario(-1,"?","?","?");
            return u;
        }
    }
    
    // Autenticar um usuario
    public boolean autenticar(String email, String senha) {
        String sql = "SELECT 1 FROM usuario WHERE email = ? AND senha = ? LIMIT 1;";
        try (Connection con = ConexaoMySQL.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    // Verificar se um email de login
    // já está registrado no banco de dados
    public boolean emailRegistrado(String email) {
        String sql = "SELECT 1 FROM usuario WHERE email = ? LIMIT 1;";
        try (Connection con = ConexaoMySQL.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            // Retorna true se encontrou algum registro
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            // Em caso de erro, retorna falso por segurança
            return false;
        }
    }
    
    public void inserir(Usuario usuario){
        String sql = "INSERT INTO usuario(email, senha, nome)"+
                      "VALUES (?,?,?);";
        try (Connection con = ConexaoMySQL.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNome());
            stmt.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public void atualizar(Usuario usuario){
        String sql = "UPDATE usuario "+
                     "SET email=?,"+
                     "senha=?, "+
                     "nome=?, "+
                     "WHERE id=?;";
        try (Connection con = ConexaoMySQL.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, usuario.getEmail());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getNome());
            stmt.setInt(4, usuario.getUsuarioID());
            stmt.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public void remover(int id) {
        String sql = "DELETE FROM usuario WHERE id = ?;";
        try (Connection con = ConexaoMySQL.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario;";
        try (Connection con = ConexaoMySQL.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("usuario_id"),
                        rs.getString("email"),
                        rs.getString("senha"),
                        rs.getString("nome")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
