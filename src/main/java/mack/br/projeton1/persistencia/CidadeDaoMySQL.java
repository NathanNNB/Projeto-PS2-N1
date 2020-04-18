
package mack.br.projeton1.persistencia;
import mack.br.projeton1.entidades.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeDaoMySQL implements CidadeDAO {
    private String createSQL = "INSERT INTO cidade VALUES (?,?,?,?,?)";
    private String readSQL = "SELECT * FROM cidade";
    private String updateSQL = "UPDATE cidade SET nome=?,estado=?,pais=?,"
            + "populacao=? WHERE idCidade = ?";
    private String deleteSQL = "DELETE FROM cidade WHERE idCidade=?";
    
    private final MySQLConnection mysql = new MySQLConnection();
    
    @Override
    public boolean create(Cidade cidade){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);
            
            stm.setString(1, cidade.getIdCidade());
            stm.setString(2, cidade.getNome());
            stm.setString(3, cidade.getEstado());
            stm.setString(4, cidade.getPais());
            stm.setString(5, cidade.getPopulacao());
            
            
            int registros= stm.executeUpdate();
            
            return registros> 0? true : false;
            
        }catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
    return false;
    }
   
    @Override
    public List<Cidade> read (){
        Connection conexao = mysql.getConnection();
        List<Cidade> cidade = new ArrayList();
        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();
            
            while(rs.next()){
                Cidade cidadeU = new Cidade();
                cidadeU.setIdCidade(rs.getString("idCidade"));
                cidadeU.setNome(rs.getString("nome"));
                cidadeU.setEstado(rs.getString("estado"));
                cidadeU.setPais(rs.getString("pais"));
                cidadeU.setPopulacao(rs.getString("populacao"));
                cidade.add(cidadeU);
            }
            return cidade;
        }catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                conexao.close();
            }catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return cidade;
    
    }
    
    @Override
    public boolean update(Cidade cidade){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(updateSQL);
            
            stm.setString(1, cidade.getNome());
            stm.setString(2, cidade.getEstado());
            stm.setString(3, cidade.getPais());
            stm.setString(4, cidade.getPopulacao());
            stm.setString(5, cidade.getIdCidade());
            
            int registros = stm.executeUpdate();
            return registros > 0? true: false;
            
        }catch(final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        }catch (final Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                conexao.close();
            }catch (final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
    
    @Override
    public boolean delete(Cidade cidade){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);
            
            stm.setString(1, cidade.getIdCidade());
            
            int registros = stm.executeUpdate();
            
            return registros > 0? true:false;
        }catch (final SQLException ex){
            System.out.println("Falha de conexão com a base de dados");
            ex.printStackTrace();
        
        }catch(final Exception ex){
            ex.printStackTrace();
        }finally{
            try{
                conexao.close();
            } catch(final Exception ex){
                ex.printStackTrace();
            }
        }
        return false;
    }
}
