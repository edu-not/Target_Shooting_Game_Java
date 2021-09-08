import java.util.ArrayList;

public class Alvo {

    protected static int vida = 3;
    private int posx, posy;
    private char cor;

    public Alvo(int posx, int posy, char cor) {
        this.posx = posx;
        this.posy = posy;
        this.cor = cor;
    }

    public static int getVida() {
        return vida;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    public char getCor() {
        return cor;
    }

    public void setCor(char cor) {
        this.cor = cor;
    }
    // nova prospota para classe Atira

    public char Atira(int posicaoX, int posicaoY, ArrayList<Alvo> alvos) {
        Alvo tiro = new Alvo(posicaoX, posicaoY, ' ');
        if (posicaoX == this.posx && posicaoY == this.posy) {
            tiro.setCor(this.getCor());
            return tiro.getCor();
        } else {
            return 'N';
        }
    }

    @Override
    public String toString() {
        return "Alvo [cor=" + cor + ", posx=" + posx + ", posy=" + posy + "]";
    }

}

/*--------------------------------------------------------------------------------------------------------------------*/

/*
 * public class Alvo {
 * 
 * private static int vida = 3; private int posx, posy; private char cor;
 * 
 * public Alvo(int posx, int posy, char cor) { this.posx = posx; this.posy =
 * posy; this.cor = cor; }
 * 
 * public static int getVida() { return vida; }
 * 
 * public int getPosx() { return posx; }
 * 
 * public void setPosx(int posx) { this.posx = posx; }
 * 
 * public int getPosy() { return posy; }
 * 
 * public void setPosy(int posy) { this.posy = posy; }
 * 
 * public char getCor() { return cor; }
 * 
 * public void setCor(char cor) { this.cor = cor; }
 * 
 * public char Atira(int posicaoX, int posicaoY) { if (posicaoX == this.posx &&
 * posicaoY == this.posy) { if (this.cor == 'B') { Alvo.vida++; return 'B'; }
 * else { Alvo.vida--; return 'P'; } } return 'N'; }
 * 
 * @Override public String toString() { return "Alvo [cor=" + cor + ", posx=" +
 * posx + ", posy=" + posy + "]"; }
 * 
 * }
 */