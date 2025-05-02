/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexao.ConexaoMySQL;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author jefadmin
 */
public class SchemaDAO {
    private static void criarBanco(){
        
    }
    private static void criarTabelas(){
        
    }
    private static void testarConexao(){
        try{
            Connection con = ConexaoMySQL.conectar();
            System.out.println("Conexão de teste com o banco de dados efetuada com sucesso.");
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro na conexão de teste com o banco de dados.");
            e.printStackTrace();
        }
    }
    public static void iniciar(){
        testarConexao();
        criarBanco();
        criarTabelas();
    }
}
