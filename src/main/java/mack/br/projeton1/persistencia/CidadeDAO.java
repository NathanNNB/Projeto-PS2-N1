
package mack.br.projeton1.persistencia;

import mack.br.projeton1.entidades.Cidade;
import java.util.List;

public interface CidadeDAO {
    boolean create (Cidade cidade);
    List<Cidade> read ();
    boolean update (Cidade cidade);
    boolean delete (Cidade cidade);
}
