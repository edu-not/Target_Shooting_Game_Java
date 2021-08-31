import java.util.Scanner;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        Alvo[] alvos = new Alvo[3];
        criarAlvos(alvos);
        //atirar(alvos);
        for (int i = 0; i < alvos.length; i++) {
            System.out.print(alvos[i].toString() + "\n");
        }

    }

    private static void criarAlvos(Alvo[] alvos) {
        Random random = new Random();
        for (int i = 0; i < alvos.length; i++) {
            int x, y;
            do {
                x = random.nextInt(5) + 1;
                y = random.nextInt(5) + 1;
                alvos[i].setPosx(x);
                alvos[i].setPosy(y);
            } while (verificarProsicao(alvos[i], x, y));

        }
    }

    private static void atirar(Alvo[] alvos) {

    }

    private static boolean verificarProsicao(Alvo alvo, int x, int y) {
        if (alvo.getPosx() == x && alvo.getPosy() == y) {
            return false;
        }
        return true;
    }

}
