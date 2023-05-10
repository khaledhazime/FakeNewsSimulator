import Mundo.Mundo;

/**
 *
 * @author khaledhazime
 */
public class FakeNewsSimulator {

    public static void main(String[] args) {
        Mundo mundo = new Mundo();
        mundo.adicionaPessoasAleatorias(100);
        mundo.desenhaMundo();
    }
}
