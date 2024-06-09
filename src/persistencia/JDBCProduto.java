package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Produto;

public class JDBCProduto {
    private Connection conexao;
    
    public JDBCProduto(Connection conexao){
        this.conexao = conexao;
    }
    
    public void inserirProduto(Produto p) {
        String sql = "INSERT INTO produto (nome, valor, quantidade) VALUES (?, ?, ?)";
        
        try (PreparedStatement ps = this.conexao.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getValor());
            ps.setInt(3, p.getQuantidade());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(JDBCProduto.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public ArrayList<Produto> listarProduto() {
        String sql = "SELECT * FROM produto";
        ArrayList<Produto> produtos = new ArrayList<>();
        
        try (PreparedStatement ps = this.conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getInt("valor"));
                p.setQuantidade(rs.getInt("quantidade"));
                produtos.add(p);
            }

            
        } catch (SQLException e) {
            Logger.getLogger(JDBCProduto.class.getName()).log(Level.SEVERE, null, e);
        }
        
        return produtos;
    }
    
    public void apagarTudo() {
        String sql = "DELETE FROM produto";
        
        try (PreparedStatement ps = this.conexao.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(JDBCProduto.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void atualizarProduto(Produto p) {
        String sql = "UPDATE produto SET nome = ?, valor = ?, quantidade = ? WHERE id = ?";
        
        try (PreparedStatement ps = this.conexao.prepareStatement(sql)) {
            ps.setString(1, p.getNome());
            ps.setDouble(2, p.getValor());
            ps.setInt(3, p.getQuantidade());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            Logger.getLogger(JDBCProduto.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
