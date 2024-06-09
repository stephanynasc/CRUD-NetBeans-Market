package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private Connection conexao;
    
    public void fecharCon(){
        if (conexao != null) {
            try {
                conexao.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public Connection abrirConexao(){
        String url = "jdbc:mysql://localhost:3306/mercado?useTimezone=true&serverTimezone=UTC";
        String user = "root";


        
        String password = "";
        
        try {
            conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            conexao = null; 
        }
        
        return conexao;
    }
}
