/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jefadmin
 */
public class ConexaoMySQL {
    // Nome do banco
    public static final String NOME_BANCO = "estoque_db";
    // Usuario do banco
    private static final String USERNAME = "root";
    // Senha do usuario
    private static final String PASSWORD = "";
    // URL de conexão
    private static final String URL = "jdbc:mysql://localhost:3306";
    
    public static Connection conectar(){
        try{
            System.out.println("Criando conexão ao banco de dados...");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException("Erro na conexão com o banco de dados: "+e.getMessage());
        }
    }
}
