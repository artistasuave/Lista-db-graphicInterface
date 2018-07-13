package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Michelle de Jesus Rogério
 */
public class ConnectionA {
    
    private static String CLASS_NAME = "jdbc.mysql.com.Driver";
    private static String HOST = "jdbc:mysql://localhost:3306/sistemaAluno";
    private static String LOGIN = "root";
    private static String SENHA = "";
    private static Connection conexao;
    
    public static void main(String[] args) {
        ConnectionA.obterConexao();        
    }
    
    
    
    public static Connection obterConexao(){
        try{
            conexao = DriverManager.getConnection(HOST, LOGIN, SENHA);
        } catch(SQLException e){
            e.printStackTrace();
        }
        return conexao;
    }

    public static void fecharConexao(){
        try{
            if(conexao != null){
                conexao.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

}
