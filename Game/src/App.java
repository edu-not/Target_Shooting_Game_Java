import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {

        ArrayList<Alvo> alvos = new ArrayList<Alvo>(15);

        criarAlvos(alvos);

        for (Alvo alvo : alvos) {
            System.err.println(alvo.toString());
        }

        start(alvos);

    }

    private static void criarAlvos(ArrayList<Alvo> alvos) {
        Random random = new Random();
        Alvo alvo;
        int cont = 15;
        while (cont != 0) {
            int x = random.nextInt(5) + 1;
            int y = random.nextInt(5) + 1;
            if (verificarPosicoes(x, y, alvos)) {
                if (cont <= 3) {
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

    private static void criaAlvoPreto(ArrayList<Alvo> alvos) {
        Random random = new Random();
        Alvo alvo;
        int cont = alvos.size();
        while (cont != 0) {
            int x = random.nextInt(5) + 1;
            int y = random.nextInt(5) + 1;
            if (verificarPosicoes(x, y, alvos)) {
                alvo = new Alvo(x, y, 'P');
                alvos.add(alvo);
                cont--;
            }
        }
    }

    private static boolean pesquisaAlvo(int x, int y, ArrayList<Alvo> alvos) {
        for (Alvo alvo : alvos) {
            if (alvo.getPosx() == x && alvo.getPosy() == y) {
                return true;
            }
        }
        return false;
    }

    private static void start(ArrayList<Alvo> alvos) {
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
        int qtdTiros = 10;
        while (qtdTiros != 0 && Alvo.getVida() != 0) {
            System.out.print("Insira a posicao 'X' dos eu tiro(1-5): ");
            int tiroX = scan.nextInt();

            System.out.print("Insira a posicao 'Y' dos eu tiro(1-5): ");
            int tiroY = scan.nextInt();

            for (Alvo alvo : alvos) {
                if (alvo.getPosx() == tiroX && alvo.getPosy() == tiroY) {
                    if (alvo.Atira(tiroX, tiroY) == 'P') {
                        System.err.println("Acertou um alvo preto");
                        alvos.remove(alvo);
                        int x = random.nextInt(5) + 1;
                        int y = random.nextInt(5) + 1;
                        while (verificarPosicoes(x, y, alvos)) {
                            x = random.nextInt(5) + 1;
                            y = random.nextInt(5) + 1;
                        }
                        Alvo novoAlvo = new Alvo(x, y, 'P');
                        alvos.add(novoAlvo);

                        qtdTiros--;
                    } else if (alvo.Atira(tiroX, tiroY) == 'B') {
                        System.err.println("Acertou um alvo branco");
                        alvos.remove(alvo);
                        qtdTiros--;
                    } else {
                        System.err.println("Erroou!");
                        qtdTiros--;
                    }
                }
            }
        }

        if (qtdTiros == 0) {
            System.out.println("GAME OVER!");
        } else {
            System.out.println("VENCEU!");
        }
    }

}