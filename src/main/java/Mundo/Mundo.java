package Mundo;

import Pessoa.Pessoa;
import Colors.Colors;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe que representa o mundo onde as pessoas estão
 * Possui métodos para adicionar pessoas aleatórias e desenhar o mundo, junto às IAs e o meio de comunicação confiável
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

    public void criaMeioComunicacaoConfiavel(MeioComunicacaoConfiavel meioComunicacaoConfiavel) {
        int x = (int) (Math.random() * LARGURA);
        int y = (int) (Math.random() * ALTURA);
        ArrayList<int[]> coordenadas = new ArrayList<int[]>();
        int[] coordenadaInicial = {x, y};
        coordenadas.add(coordenadaInicial);

        // adiciona coordenadas adjacentes
        int[][] deltas = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // cima, baixo, esquerda, direita
        for (int[] delta : deltas) {
            int novoX = x + delta[0];
            int novoY = y + delta[1];
            if (novoX >= 0 && novoX < LARGURA && novoY >= 0 && novoY < ALTURA) {
                int[] novaCoordenada = {novoX, novoY};
                coordenadas.add(novaCoordenada);
            }
        }

        meioComunicacaoConfiavel.setCor(4);
        meioComunicacaoConfiavel.setCoordenadas(coordenadas);
        desenhaMeioComunicacaoConfiavel(meioComunicacaoConfiavel);
    }

    public void desenhaMeioComunicacaoConfiavel(MeioComunicacaoConfiavel meioComunicacaoConfiavel) {
        for (int[] coordenada : meioComunicacaoConfiavel.getCoordenadas()) {
            mapa[coordenada[0]][coordenada[1]] = 4;
        }
    }

    public void criaGeradoraFakeNews(IAGeradoraFakeNews IAGeradoraFakeNews) {
        int x = (int) (Math.random() * LARGURA);
        int y = (int) (Math.random() * ALTURA);
        ArrayList<int[]> coordenadas = new ArrayList<int[]>();
        int[] coordenadaInicial = {x, y};
        coordenadas.add(coordenadaInicial);

        // adiciona coordenadas adjacentes
        int[][] deltas = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // cima, baixo, esquerda, direita
        for (int[] delta : deltas) {
            int novoX = x + delta[0];
            int novoY = y + delta[1];
            if (novoX >= 0 && novoX < LARGURA && novoY >= 0 && novoY < ALTURA) {
                int[] novaCoordenada = {novoX, novoY};
                coordenadas.add(novaCoordenada);
            }
        }

        IAGeradoraFakeNews.setCor(2);
        IAGeradoraFakeNews.setCoordenadas(coordenadas);
        desenhaGeradoraFakeNews(IAGeradoraFakeNews);
    }

    public void desenhaGeradoraFakeNews(IAGeradoraFakeNews IAGeradoraFakeNews) {
        for (int[] coordenada : IAGeradoraFakeNews.getCoordenadas()) {
            mapa[coordenada[0]][coordenada[1]] = 2;
        }
    }

    public void criaDestruidoraFakeNews(IADestruidoraFakeNews IADestruidoraFakeNews) {
        int x = (int) (Math.random() * LARGURA);
        int y = (int) (Math.random() * ALTURA);
        ArrayList<int[]> coordenadas = new ArrayList<int[]>();
        int[] coordenadaInicial = {x, y};
        coordenadas.add(coordenadaInicial);

        // adiciona coordenadas adjacentes
        int[][] deltas = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // cima, baixo, esquerda, direita
        for (int[] delta : deltas) {
            int novoX = x + delta[0];
            int novoY = y + delta[1];
            if (novoX >= 0 && novoX < LARGURA && novoY >= 0 && novoY < ALTURA) {
                int[] novaCoordenada = {novoX, novoY};
                coordenadas.add(novaCoordenada);
            }
        }

        IADestruidoraFakeNews.setCor(3);
        IADestruidoraFakeNews.setCoordenadas(coordenadas);
        desenhaDestruidoraFakeNews(IADestruidoraFakeNews);
    }

    public void desenhaDestruidoraFakeNews(IADestruidoraFakeNews IADestruidoraFakeNews) {
        for (int[] coordenada : IADestruidoraFakeNews.getCoordenadas()) {
            mapa[coordenada[0]][coordenada[1]] = 3;
        }
    }


    public void desenhaMundo() {
        for (int i = 0; i < LARGURA; i++) {
            for (int j = 0; j < ALTURA; j++) {
                switch (mapa[i][j]) {
                    case 0 -> System.out.print(Colors.getColor(0) + " ");
                    case 1 ->{
                        System.out.print(Colors.getColor(getPessoa(i, j).getCor()) + "P");
                    }
                    case 2 -> System.out.print(Colors.getColor(2) + "G");
                    case 3 -> System.out.print(Colors.getColor(3) + "D");
                    case 4 -> System.out.print(Colors.getColor(4) + "M");
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

    public void getPessoasAdjacentes(Pessoa pessoa, boolean printaContatos){
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
        if (pessoa.getAgendaContatos().size() > 0 && printaContatos) {
            System.out.println(pessoa.getWhatsappID() + " tem " + pessoa.getAgendaContatos().size() + " contatos");
            System.out.print("Contatos: [");
            for (Pessoa contato : pessoa.getAgendaContatos()) {
                System.out.print(contato.getWhatsappID() + ", ");
            }
            System.out.println("]");
        }

    }
}

