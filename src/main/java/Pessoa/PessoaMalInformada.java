
package Pessoa;

import Mundo.Mundo;

import java.util.Random;
/**
 *
 * @author khaledhazime
 */

public class PessoaMalInformada extends Pessoa implements IMovable {
    public PessoaMalInformada(int x, int y, int cor, String whatsappID) {
        super(x, y, cor, whatsappID);
        this.setCor(3);
    }

    @Override
    public void move() {

        Random random = new Random();

        int direction = random.nextInt(4);
        switch (direction) {
            case 0 -> {
                if (this.getX() < Mundo.LARGURA - 1) {
                    this.setX(this.getX() + 1);
                } else {
                    this.setX(0);
                }
            }
            case 1 -> {
                if (this.getX() > 0) {
                    this.setX(this.getX() - 1);
                } else {
                    this.setX(Mundo.LARGURA - 1);
                }
            }
            case 2 -> {
                if (this.getY() < Mundo.ALTURA - 1) {
                    this.setY(this.getY() + 1);
                } else {
                    this.setY(0);
                }
            }
            case 3 -> {
                if (this.getY() > 0) {
                    this.setY(this.getY() - 1);
                } else {
                    this.setY(Mundo.ALTURA - 1);
                }
            }
        }

    }
}
