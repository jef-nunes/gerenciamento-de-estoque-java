/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import conexao.ConexaoMySQL;
import java.util.ArrayList;
import modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jefadmin
 */
public class ProdutoDAO {    
    
    // Verificar se algum produto com mesmo nome já foi registrada
    public boolean produtoRegistrado(String nome) {
        String sql = "SELECT 1 FROM produto WHERE nome = ? LIMIT 1";
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
    
    // Obter o nome do usuário responsável
    // pelo produto a partir do ID (chave estrangeira)
    public String obterNomeUsuario(int usuarioID){
        String sql = "SELECT nome FROM usuario WHERE usuario_id = ?;";
        try (Connection con = ConexaoMySQL.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuarioID);
            ResultSet rs = stmt.executeQuery();
            con.close();
            if(rs.next()){
                String nome = rs.getString("nome");
                return nome;
            }
            else{
                return "Desconhecido";
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return "Desconhecido";
        } 
    }
    
    // Obter o ID da categoria a partir do nome
    public int obterCategoriaID(String nome){
        String sql = "SELECT categoria_id FROM categoria WHERE nome = ?;";
        try (Connection con = ConexaoMySQL.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();
            con.close();
            if(rs.next()){
                int id = rs.getInt("categoria_id");
                return id;
            }
            else{
                return -1;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
            return -1;
        } 
    }
    
    // Ao inserir um novo produto, é passado como argumento
    // o modelo Produto, o nome da categoria a qual ele pertence
    // e o ID do usuario (chave estrangeira) que registrou o produto 
    public void inserir(Produto produto, String nomeCategoria, int usuarioID){
        // Pegar o ID da categoria (chave estrangeira)
        // a partir do nome fornecido
        int categoriaID = obterCategoriaID(nomeCategoria);
        // Query para registrar um novo produto
        String sql = "INSERT INTO produto(nome, valor_unidade, quantidade_disponivel, categoria_id, usuario_id)"+
                      "VALUES (?, ?, ?, ?, ?)";
        try (Connection con = ConexaoMySQL.conectar()) {
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getValorUnidade());
            stmt.setInt(3, produto.getQuantidadeDisponivel());
            stmt.setInt(4, categoriaID);
            stmt.setInt(5, usuarioID);
            stmt.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public void atualizar(Produto produto, String nomeCategoria){
        // Obter o ID da categoria a partir do nome
        // (chave estrangeira)
        int categoriaID = obterCategoriaID(nomeCategoria);
        String sql = "UPDATE produto "+
                     "SET nome=?,"+
                     "valor_unidade=?,"+
                     "quantidade_disponivel=?,"+
                     "categoria_id=?,"+
                     "WHERE produto_id=?;";
        try (Connection con = ConexaoMySQL.conectar()) {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, produto.getNome());
            stmt.setFloat(2, produto.getValorUnidade());
            stmt.setInt(3, produto.getQuantidadeDisponivel());
            stmt.setInt(4, categoriaID);
            stmt.setInt(4, produto.getProdutoID());
            stmt.executeUpdate();
            con.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        } 
    }
    
    public void remover(int id) {
        String sql = "DELETE FROM produto WHERE produto_id = ?";
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
    
    public ArrayList<Produto> listar() {
        ArrayList<Produto> lista = new ArrayList<>();
        String sql = "SELECT * FROM produto";
        try (Connection con = ConexaoMySQL.conectar();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Produto p = new Produto(
                        rs.getInt("produto_id"),
                        rs.getInt("categoria_id"),
                        rs.getInt("usuario_id"),
                        rs.getString("nome"),
                        rs.getFloat("valor_unidade"),
                        rs.getInt("quantidade_disponivel")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
