import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Alvo[] alvos = new Alvo[15];
        criarAlvos(alvos);
        verificarProsicao(alvos);
        /* atirar(alvos); */
        for (int i = 0; i < alvos.length; i++) {
            System.out.print(alvos[i].toString() + "\n");
        }

    }

    private static void criarAlvos(Alvo[] alvos) {
        Random random = new Random();
        for (int i = 0; i < alvos.length; i++) {
            int x = random.nextInt(5) + 1;
            int y = random.nextInt(5) + 1;
            if (i == 14 || i == 13 || i == 12) {
                alvos[i] = new Alvo(x, y, 'P');
            } else {
                alvos[i] = new Alvo(x, y, 'B');
            }

        }
    }

    /*
     * private static void atirar(Alvo[] alvos) {
     * 
     * }
     */

    private static void verificarProsicao(Alvo[] alvos) {
        Random random = new Random();
        int cont = alvos.length;
        while (cont != 0) {
            for (int i = 0; i < alvos.length; i++) {
                if (alvos[cont].getPosx() == alvos[i].getPosx() && alvos[cont].getPosy() == alvos[i].getPosy()) {
                    int x = random.nextInt(5) + 1;
                    int y = random.nextInt(5) + 1;
                    alvos[i].setPosx(x);
                    alvos[i].setPosy(y);
                }
            }
            cont--;
        }
    }

}
