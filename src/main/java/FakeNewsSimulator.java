import Mundo.Mundo;
import Mundo.IADestruidoraFakeNews;
import Mundo.IAGeradoraFakeNews;
import Mundo.MeioComunicacaoConfiavel;
import Pessoa.Pessoa;
import Simulation.FakeNewsSimulatorTimer;
import java.util.Timer;
/**
 *
 * @author khaledhazime
 */
public class FakeNewsSimulator {

    public static void main(String[] args) {
        Mundo mundo = new Mundo();
        Timer timer = new Timer();
        MeioComunicacaoConfiavel meioComunicacaoConfiavel = new MeioComunicacaoConfiavel();
        IAGeradoraFakeNews geradoraFakeNews = new IAGeradoraFakeNews();
        IADestruidoraFakeNews destruidoraFakeNews = new IADestruidoraFakeNews();


        mundo.adicionaPessoasAleatorias(100);
        mundo.criaMeioComunicacaoConfiavel(meioComunicacaoConfiavel);
        mundo.criaGeradoraFakeNews(geradoraFakeNews);
        mundo.criaDestruidoraFakeNews(destruidoraFakeNews);

        FakeNewsSimulatorTimer task = new FakeNewsSimulatorTimer(mundo);
        timer.schedule(task, 0, 1000); // define o intervalo de tempo entre cada tick


    }
}
