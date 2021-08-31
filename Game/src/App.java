import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Alvo[] alvos = new Alvo[15];
        criarAlvos(alvos);
        // atirar(alvos);
        for (int i = 0; i < alvos.length; i++) {
            System.out.print(alvos[i].toString() + "\n");
        }

    }

    private static void criarAlvos(Alvo[] alvos) {
        Random random = new Random();
        for (int i = 0; i < alvos.length; i++) {
            int x = random.nextInt(5) + 1;
            int y = random.nextInt(5) + 1;
            alvos[i] = new Alvo(x, y, 'B');
            while (verificarProsicao(alvos, x, y)) {
                x = random.nextInt(5) + 1;
                y = random.nextInt(5) + 1;
                alvos[i].setPosx(x);
                alvos[i].setPosy(y);
            }

        }
    }

    private static void atirar(Alvo[] alvos) {

    }

    private static boolean verificarProsicao(Alvo[] alvos, int x, int y) {
        for (int i = 0; i < alvos.length; i++) {
            if (alvos[i] == null) {
                return true;
            } else if (alvos[i].getPosx() == x && alvos[i].getPosy() == y) {
                return false;
            }
        }

        return true;
    }

}
