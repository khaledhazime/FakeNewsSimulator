package Mundo;

import java.util.ArrayList;
import java.util.List;

public class IAGeradoraFakeNews {
    private int cor;
    private List<int[]> coordenadas;

    public IAGeradoraFakeNews(){
        this.cor = 2;
        this.coordenadas = new ArrayList<int[]>();
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public List<int[]> getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(List<int[]> coordenadas) {
        this.coordenadas = coordenadas;
    }
}

