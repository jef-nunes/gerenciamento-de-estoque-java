/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexao.ConexaoMySQL;
import java.util.ArrayList;
import modelo.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jefadmin
 */
public class CategoriaDAO {
    
    // Verificar se a categoria já foi registrada
    public boolean categoriaRegistrada(String nome) {
        String sql = "SELECT 1 FROM categoria WHERE nome = ? LIMIT 1";
        try (Connection con = ConexaoMySQL.conectar();
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            // Retorna true se encontrou algum registro
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
            // Em caso de erro, retorna falso por segurança
            return false;
        }
    }
    
    public void inserir(Categoria categoria){
        String sql = "INSERT INTO categoria(nome)"+
                      "VALUES (?)";
        try (Connection con = ConexaoMySQL.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public void atualizar(Categoria categoria){
        String sql = "UPDATE categoria "+
                     "SET nome=?,"+
                     "WHERE categoria_id=?;";
        try (Connection con = ConexaoMySQL.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, categoria.getNome());
            stmt.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public void remover(int id) {
        String sql = "DELETE FROM categoria WHERE categoria_id = ?";
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
    
    public ArrayList<Categoria> listar() {
        ArrayList<Categoria> lista = new ArrayList<>();
        String sql = "SELECT * FROM categoria";
        try (Connection con = ConexaoMySQL.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Categoria c = new Categoria(
                        rs.getInt("categoria_id"),
                        rs.getString("nome")
                );
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
