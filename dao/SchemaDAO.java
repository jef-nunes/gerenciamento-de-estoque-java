/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jefadmin
 */
// Prepara o banco de dados
// testando a conexão e criando
// o banco e tabelas
// em caso de não existirem
public class SchemaDAO {
    // Criar o banco se não existir
    private static void criarBanco(){
        System.out.println("Preparando criação do banco de dados");
        System.out.println("Criando conexão ao MySQL...");
        try (Connection con = ConexaoMySQL.conectarSemBanco()) {
            // Query
            String sql = "CREATE SCHEMA IF NOT EXISTS "+ConexaoMySQL.NOME_BANCO+";";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    // Criar tabelas se não existirem
    private static void criarTabelas(){
        // Queries
        // Tabela de categoria
        String sql1 = "CREATE TABLE IF NOT EXISTS categoria("+
                      "categoria_id INT NOT NULL,"+
                      "nome VARCHAR(255) NOT NULL,"+
                      "PRIMARY KEY (categoria_id));";
        // Tabela de usuário
        String sql2 = "CREATE TABLE IF NOT EXISTS usuario("+
                      "usuario_id INT NOT NULL,"+
                      "email VARCHAR(255) NOT NULL,"+
                      "senha CHAR(64) NOT NULL,"+
                      "nome VARCHAR(255) NOT NULL,"+
                      "PRIMARY KEY (usuario_id))";
        // Tabela de produto
        String sql3 =   "CREATE TABLE IF NOT EXISTS produto ("+
                        "produto_id INT NOT NULL,"+
                        "nome VARCHAR(255) NOT NULL,"+
                        "valor_unidade FLOAT NOT NULL,"+
                        "quantidade_disponivel INT NOT NULL,"+
                        "categoria_id INT NOT NULL,"+
                        "usuario_id INT NOT NULL,"+
                        "PRIMARY KEY (produto_id, categoria_id, usuario_id),"+
                        "INDEX fk_produto_categoria1_idx (categoria_id ASC) VISIBLE,"+
                        "INDEX fk_produto_usuario1_idx (usuario_id ASC) VISIBLE,"+
                        "CONSTRAINT fk_produto_categoria1"+
                        "  FOREIGN KEY (categoria_id)"+
                        "  REFERENCES mydb.categoria (categoria_id)"+
                        "  ON DELETE NO ACTION"+
                        "  ON UPDATE NO ACTION,"+
                        "CONSTRAINT fk_produto_usuario1"+
                        "  FOREIGN KEY (usuario_id)"+
                        "  REFERENCES mydb.usuario (usuario_id)"+
                        "  ON DELETE NO ACTION"+
                        "  ON UPDATE NO ACTION)";
        // Tabela de movimentacao
        String sql4 =   "CREATE TABLE IF NOT EXISTS movimentacao ("+
                        "movimentacao_id INT NOT NULL,"+
                        "tipo_fluxo VARCHAR(255) NOT NULL,"+
                        "quantidade INT NOT NULL,"+
                        "usuario_id INT NOT NULL,"+
                        "produto_id INT NOT NULL,"+
                        "PRIMARY KEY (movimentacao_id, usuario_id, produto_id),"+
                        "INDEX fk_movimentacao_usuario_idx (usuario_id ASC) VISIBLE,"+
                        "INDEX fk_movimentacao_produto1_idx (produto_id ASC) VISIBLE,"+
                        "CONSTRAINT fk_movimentacao_usuario"+
                        "  FOREIGN KEY (usuario_id)"+
                        "  REFERENCES mydb.usuario (usuario_id)"+
                        "  ON DELETE NO ACTION"+
                        "  ON UPDATE NO ACTION,"+
                        "CONSTRAINT fk_movimentacao_produto1"+
                        "  FOREIGN KEY (produto_id)"+
                        "  REFERENCES mydb.produto (produto_id)"+
                        "  ON DELETE NO ACTION"+
                        "  ON UPDATE NO ACTION)";
        
        // Executar cada query SQL
        String[] arraySQL = {sql1,sql2,sql3,sql4};
        for(int i=0; i<arraySQL.length;i++){
           try (Connection con = ConexaoMySQL.conectarSemBanco()) {
                PreparedStatement stmt = con.prepareStatement(arraySQL[i]);
                stmt.executeUpdate();
            }
            catch (SQLException e){
                e.printStackTrace();
            } 
        }
    }
    private static void testarConexao(){
        try{
            Connection con = ConexaoMySQL.conectarSemBanco();
            System.out.println("Conexão de teste com o MySQL efetuada com sucesso.");
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão de teste com o MySQL.");
            e.printStackTrace();
        }
    }
    public static void iniciar(){
        testarConexao();
        criarBanco();
        criarTabelas();
    }
}
