/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import principal.Variaveis;
/**
 *
 * @author jefadmin
 */
// Lógica de conexão com o MySQL
public class ConexaoMySQL {
    // Contador de conexões estabelecidads
    private static int contador;
    // Nome do banco
    public static final String NOME_BANCO = "estoque_db";
    // Usuario do banco
    private static final String USERNAME = "root";
    // Senha do usuario
    private static final String PASSWORD = "";
    // OBS: Em desenvolvimento sera utilizado
    // uma variavel de ambiente
    private static String passwordDev;
    
    // URLs de conexão
    private static final String URL = "jdbc:mysql://localhost:3306/"+NOME_BANCO;
    // URL sem o banco de dados
    // em caso deste ser criado dinamicamente
    private static final String URL_SEM_BANCO = "jdbc:mysql://localhost:3306/";
    // URLs em ambiente de desenvolvimento com flags adicionais
    private static final String URL_DEV = "jdbc:mysql://localhost:3306/"+NOME_BANCO+"?verifyServerCertificate=false&useSSL=true";
    private static final String URL_SEM_BANCO_DEV = "jdbc:mysql://localhost:3306/"+"?verifyServerCertificate=false&useSSL=true";

    public static String getPasswordDev() {
        return passwordDev;
    }

    public static void setPasswordDev(String passwordDev) {
        ConexaoMySQL.passwordDev = passwordDev;
    }
    
    public static Connection conectar(){
        contador+=1;
        try{
             if(Variaveis.isDev()){
             //System.out.println("(Conexão ao banco de dados em ambiente de desenvolvimento)"+"("+contador+")");
             return DriverManager.getConnection(URL_DEV, USERNAME, passwordDev);
            }
            else{
             return DriverManager.getConnection(URL, USERNAME, PASSWORD);
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro na conexão com o banco de dados: "+e.getMessage());
        }
    }
    
    public static Connection conectarSemBanco(){
        contador+=1;
        try{
            if(Variaveis.isDev()){
             //System.out.println("(Conexão ao MySQL em ambiente de desenvolvimento)"+"("+contador+")");
             return DriverManager.getConnection(URL_SEM_BANCO_DEV, USERNAME, passwordDev);
            }
            else{
             return DriverManager.getConnection(URL_SEM_BANCO, USERNAME, PASSWORD);
            }
        } catch (SQLException e){
            throw new RuntimeException("Erro na conexão com o MySQL: "+e.getMessage());
        }
    }
}
