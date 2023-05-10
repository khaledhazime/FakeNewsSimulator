package Simulation;

import Mundo.Mundo;
import Pessoa.Pessoa;
import java.util.Timer;
import java.util.TimerTask;

public class FakeNewsSimulatorTimer extends TimerTask {

    private Mundo mundo;
    private int tickCount = 0;
    private final int MAX_TICKS = 2; // define a quantidade de ticks a serem executados

    public FakeNewsSimulatorTimer(Mundo mundo) {
        this.mundo = mundo;
    }

    @Override
    public void run() {
        mundo.desenhaMundo();
        for(Pessoa pessoa : mundo.getMapaPessoas()){
            if (pessoa!=null){
                mundo.getPessoasAdjacentes(pessoa, false);
            }
        }
        tickCount++;
        if (tickCount >= MAX_TICKS) { // encerra o loop quando atinge o número máximo de ticks
            this.cancel();
        }
    }

}
