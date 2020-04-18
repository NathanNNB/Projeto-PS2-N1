package mack.br.projeton1.persistencia;

import mack.br.projeton1.entidades.Jogo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDaoMySQL implements JogoDAO{

    private String createSQL = "INSERT INTO jogo VALUES (?,?,?,?,?)";
    private String readSQL = "SELECT * FROM jogo";
    private String updateSQL = "UPDATE jogo SET nomeA=?,nomeB=?,golsA=?,"
            + "golsB=? WHERE idjogo = ?";
    private String deleteSQL = "DELETE FROM jogo WHERE idjogo=?";

    private final MySQLConnection mysql = new MySQLConnection();

    @Override
    public boolean create(Jogo jogo){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(createSQL);

            stm.setString(1, jogo.getIdjogo());
            stm.setString(2, jogo.getNomeA());
            stm.setString(3, jogo.getNomeB());
            stm.setInt(4, jogo.getGolsA());
            stm.setInt(5, jogo.getGolsB());


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
    public List<Jogo> read (){
        Connection conexao = mysql.getConnection();
        List<Jogo> jogo = new ArrayList();
        try {
            PreparedStatement stm = conexao.prepareStatement(readSQL);
            ResultSet rs = stm.executeQuery();

            while(rs.next()){
                Jogo jogoU = new Jogo();
                jogoU.setIdjogo(rs.getString("idjogo"));
                jogoU.setNomeA(rs.getString("nomeA"));
                jogoU.setNomeB(rs.getString("nomeB"));
                jogoU.setGolsA(rs.getInt("golsA"));
                jogoU.setGolsB(rs.getInt("golsB"));
                jogo.add(jogoU);
            }
            return jogo;
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
        return jogo;
    }

    @Override
    public boolean update(Jogo jogo){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(updateSQL);

            stm.setString(1, jogo.getNomeA());
            stm.setString(2, jogo.getNomeB());
            stm.setInt(3, jogo.getGolsA());
            stm.setInt(4, jogo.getGolsB());
            stm.setString(5, jogo.getIdjogo());

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
    public boolean delete(Jogo jogo){
        Connection conexao = mysql.getConnection();
        try{
            PreparedStatement stm = conexao.prepareStatement(deleteSQL);

            stm.setString(1, jogo.getIdjogo());

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
