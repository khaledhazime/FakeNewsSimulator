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
            mapaPessoas[i] = pessoa;
            mapa[x][y] = cor;
        }
    }

    public void desenhaMundo() {
        for (int i = 0; i < LARGURA; i++) {
            for (int j = 0; j < ALTURA; j++) {
                switch (mapa[i][j]) {
                    case 0 -> System.out.print(Colors.WHITE.getColorCode() + "0");
                    case 1 ->{
                        int cor = getPessoa(i, j).getCor();
                        if(cor == 1) {
                            System.out.print(Colors.BLUE.getColorCode() + "1");
                        } else if(cor == 2) {
                            System.out.print(Colors.RED.getColorCode() + "2");
                        }

                    }
                }
            }
            System.out.println();
        }
    }

    public Pessoa[] getMapaPessoas() {
        return mapaPessoas;
    }

    public Pessoa getPessoa(int x, int y) {
        if (mapa[x][y] == 1) {
            for (Pessoa pessoa : mapaPessoas) {
                if (pessoa.getX() == x && pessoa.getY() == y) {
                    return pessoa;
                }
            }
        }
        return null;
    }

    public void getPessoasAdjacentes(Pessoa pessoa){
        int x = pessoa.getX();
        int y = pessoa.getY();
        Pessoa pessoaAdjacente;
        if (x > 0 && mapa[x - 1][y] == 1) {
            pessoaAdjacente = getPessoa(x - 1, y);
            pessoa.addContatos(pessoaAdjacente);
        }
        if (x < LARGURA - 1 && mapa[x + 1][y] == 1) {
            pessoaAdjacente = getPessoa(x + 1, y);
            pessoa.addContatos(pessoaAdjacente);
        }
        if (y > 0 && mapa[x][y - 1] == 1) {
            pessoaAdjacente = getPessoa(x, y - 1);
            pessoa.addContatos(pessoaAdjacente);
        }
        if (y < ALTURA - 1 && mapa[x][y + 1] == 1) {
            pessoaAdjacente = getPessoa(x, y + 1);
            pessoa.addContatos(pessoaAdjacente);
        }
        if (pessoa.getAgendaContatos().size() > 0){
            System.out.println(pessoa.getWhatsappID() + " tem " + pessoa.getAgendaContatos().size() + " contatos");
            System.out.print("Contatos: [");
            for (Pessoa contato : pessoa.getAgendaContatos()) {
                System.out.print(contato.getWhatsappID() + ", ");
            }
            System.out.println("]");
        }

    }
}

