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
    private static final ArrayList<Usuario> usuarios = new ArrayList();
    
    public void inserir(Usuario usuario){
        String sql = "INSERT INTO usuario(email, senha, nome)"+
                      "VALUES (?,?,?)";
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
        String sql = "DELETE FROM usuario WHERE id = ?";
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
        String sql = "SELECT * FROM usuario";
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
