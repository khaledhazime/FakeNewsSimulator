package Pessoa;

import java.util.ArrayList;

/**
 *
 * @author khaledhazime
 */
public class Pessoa {
    private int x;
    private int y;
    private int cor;
    private String whatsappID;
    private final ArrayList<Pessoa> AgendaContatos;
    private boolean isResistente;
    private boolean hasFakeNews;
    private int tempo;
    
    public Pessoa(int x, int y, int cor, String whatsappID) {
        this.x = x;
        this.y = y;
        this.cor = 1;
        this.whatsappID = whatsappID;
        this.AgendaContatos = new ArrayList<>();
        this.isResistente = false;
        this.hasFakeNews = false;
        this.tempo=0;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public String getWhatsappID() {
        return whatsappID;
    }

    public void setWhatsappID(String whatsappID) {
        this.whatsappID = whatsappID;
    }

    public ArrayList<Pessoa> getAgendaContatos() {
        return AgendaContatos;
    }

    public void addContatos(Pessoa contato) {
        if (this.AgendaContatos.contains(contato)) {
            return;
        }
        this.AgendaContatos.add(contato);
    }

    public void setResistente(boolean isResistente) {
        this.isResistente = isResistente;
    }

    public boolean isResistente() {
        return this.isResistente;
    }

    public void setFakeNews(boolean hasFakeNews) {
        this.hasFakeNews = hasFakeNews;
    }

    public boolean hasFakeNews() {
        return this.hasFakeNews;
    }
}
