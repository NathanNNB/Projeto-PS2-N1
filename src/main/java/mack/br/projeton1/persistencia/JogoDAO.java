package mack.br.projeton1.persistencia;

import mack.br.projeton1.entidades.Jogo;

import java.util.List;

public interface JogoDAO {

    boolean create (Jogo jogo);
    List<Jogo> read ();
    boolean update (Jogo jogo);
    boolean delete (Jogo jogo);
}
