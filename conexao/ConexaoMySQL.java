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
// Lógica de conexão com o MySQL
public class ConexaoMySQL {
    // Nome do banco
    public static final String NOME_BANCO = "estoque_db";
    // Usuario do banco
    private static final String USERNAME = "root";
    // Senha do usuario
    private static final String PASSWORD = "";
    // URLs de conexão
    private static final String URL = "jdbc:mysql://localhost:3306/"+NOME_BANCO;
    private static final String URL_SEM_BANCO = "jdbc:mysql://localhost:3306/";
    
    public static Connection conectarSemBanco(){
        try{
            System.out.println("Criando conexão ao MySQL...");
            return DriverManager.getConnection(URL_SEM_BANCO, USERNAME, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException("Erro na conexão com o MySQL: "+e.getMessage());
        }
    }
    
    public static Connection conectar(){
        try{
            System.out.println("Criando conexão ao banco de dados...");
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e){
            throw new RuntimeException("Erro na conexão com o banco de dados: "+e.getMessage());
        }
    }
}
