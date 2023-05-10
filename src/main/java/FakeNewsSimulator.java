import Mundo.Mundo;
import Pessoa.Pessoa;
/**
 *
 * @author khaledhazime
 */
public class FakeNewsSimulator {

    public static void main(String[] args) {
        Mundo mundo = new Mundo();
        mundo.adicionaPessoasAleatorias(100);
        mundo.desenhaMundo();
        for(Pessoa pessoa : mundo.getMapaPessoas()){
            if (pessoa!=null){
                mundo.getPessoasAdjacentes(pessoa, false);
            }
        }

    }
}
