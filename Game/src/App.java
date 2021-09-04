import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Alvo> alvos = new ArrayList<Alvo>(15);
        criarAlvos(alvos);
        for (Alvo alvo : alvos) {
            System.out.println(alvo.toString());
        }
    }

    private static void criarAlvos(ArrayList<Alvo> alvos) {
        Random random = new Random();
        Alvo alvo;
        int cont = 15;
        while (cont != 0) {
            int x = random.nextInt(5) + 1;
            int y = random.nextInt(5) + 1;
            if (verificarPosicoes(x, y, alvos)) {
                if (cont > 3) {
                    alvo = new Alvo(x, y, 'B');
                    alvos.add(alvo);
                    cont--;
                } else {
                    alvo = new Alvo(x, y, 'P');
                    alvos.add(alvo);
                    cont--;
                }

            }
        }
    }

    private static boolean verificarPosicoes(int x, int y, ArrayList<Alvo> alvos) {
        for (Alvo alvo : alvos) {
            if (alvo.getPosx() == x && alvo.getPosy() == y) {
                return false;
            }
        }
        return true;
    }

}