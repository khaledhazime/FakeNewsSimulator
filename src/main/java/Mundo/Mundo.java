package Mundo;

import Pessoa.Pessoa;
import Colors.Colors;
import java.util.Arrays;

/**
 *
 * @author khaledhazime
 */
public class Mundo {
    public static final int LARGURA = 30;
    public static final int ALTURA = 60;

    private final int[][] mapa = new int[LARGURA][ALTURA];

    private final Pessoa[] mapaPessoas = new Pessoa[LARGURA * ALTURA];

    public Mundo() {
        System.out.println("Criando mundo...");
        for (int i = 0; i < LARGURA; i++) {
            Arrays.fill(mapa[i], 0);
        }
        System.out.println("Mundo criado!");
    }

    public void adicionaPessoasAleatorias(int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            int x = (int) (Math.random() * LARGURA);
            int y = (int) (Math.random() * ALTURA);
            int cor = 1;
            String whatsappID = "Pessoa" + i;
            Pessoa pessoa = new Pessoa(x, y, cor, whatsappID);
            mapa[x][y] = cor;
        }
    }

    public void desenhaMundo(){
        for(int i=0; i<LARGURA; i++){
            for(int j=0; j<ALTURA; j++){
                switch (mapa[i][j]) {
                    case 0 -> System.out.print(Colors.WHITE.getColorCode() + "0");
                    case 1 -> System.out.print(Colors.BLUE.getColorCode() + "1");
                }
            }
            System.out.println();
        }
    }

}
