import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean jogarNovamente = false;

        do {
            jogarNovamente = false;
            jogar();
            
            System.out.println("Deseja jogar novamente? (S/N)");
            char resposta = sc.next().charAt(0);
            resposta = Character.toUpperCase(resposta);

            if (resposta == 'S') {
                jogarNovamente = true;
            }
        } while (jogarNovamente);

        System.out.println("Obrigado por jogar!");
        sc.close();
    }

    public static void jogar() {
        final int linha = 6, coluna = 7;
        char[][] tabuleiro = new char[coluna][linha];
        char escolhaCor = 'B';
        int posicaoEscolhida = 0;
        for (int l = 0; l < linha; l++) {
            for (int c = 0; c < coluna; c++) {
                tabuleiro[c][l] = 'B';
            }
        }
        Scanner sc = new Scanner(System.in);
        char corUser = escolhaUsuario(escolhaCor, sc);
        char corPc   = escolhaPc(corUser);
        System.out.println("Cor Usuário: " + corUser + "\nCor Pc: " + corPc);

        while (true) {
            adicionaTabela(tabuleiro, corPc, corUser, posicaoEscolhida, sc);
            if (verificaVitoria(tabuleiro, corUser)) {
                System.out.println("Parabéns! Você venceu!");
                break;
            }
            if (verificaVitoria(tabuleiro, corPc)) {
                System.out.println("O computador venceu!");
                break;
            }
            if (tabuleiroCheio(tabuleiro)) {
                System.out.println("O jogo empatou!");
                break;
            }
        }
    }

    public static void mostraJogo(char[][] tabuleiro) {
        System.out.println("=============================");
        System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
        System.out.println("=============================");
        for (int l = 0; l < 6; l++) {
            for (int c = 0; c < 7; c++) {
                System.out.print("| " + tabuleiro[c][l] + " ");
            }
            System.out.println("|");
        }
        System.out.println("=============================");
    }

    public static char escolhaUsuario(char escolhaCor, Scanner sc) {
        char escolhaUser = escolhaCor;
        do {
            System.out.println("Escolha uma cor V ou A: ");
            escolhaUser = sc.next().charAt(0);
            // Convertendo o caracter para maiúsculo
            escolhaUser = Character.toUpperCase(escolhaUser);
        } while (escolhaUser != 'V' && escolhaUser != 'A');
        return escolhaUser;
    }

    public static char escolhaPc(char escolhaUser) {
        char corPc = 'B';
        if (escolhaUser == 'A') {
            corPc = 'V';
        } else if (escolhaUser == 'V') {
            corPc = 'A';
        } else {
            corPc = 'B';
        }
        return corPc;
    }

    public static void adicionaTabela(char[][] tabuleiro, char corPc, char corUser, int posicaoEscolhida, Scanner sc) {
        int posicao = posicaoEscolhida;

        // jogador
        do {
            mostraJogo(tabuleiro);
            System.out.println("Informe a coluna desejada: (0 a 6)");
            posicao = sc.nextInt();

            if (tabuleiro[posicao][0] == 'B') {
                for (int i = 5; i >= 0; i--) {
                    if (tabuleiro[posicao][i] == 'B') {
                        tabuleiro[posicao][i] = corUser;
                        break;
                    }
                }
            } else {
                posicao = 7;
                System.out.println("teste!");
                System.out.println("Coluna Cheia!");
            }
        } while (posicao < 0 || posicao > 6);

        // pc
        do {
            Random gerador = new Random();
            posicao = gerador.nextInt(7);
            if (tabuleiro[posicao][0] == 'B') {
                for (int i = 5; i >= 0; i--) {
                    if (tabuleiro[posicao][i] == 'B') {
                        tabuleiro[posicao][i] = corPc;
                        break;
                    }
                }
            } else {
                posicao = 7;
            }
        } while (posicao < 0 || posicao > 6);

        mostraJogo(tabuleiro);
    }

    public static boolean verificaVitoria(char[][] tabuleiro, char cor) {
        // Verifica vitória na horizontal
        for (int l = 0; l < 6; l++) {
            for (int c = 0; c < 4; c++) {
                if (tabuleiro[c][l] == cor && tabuleiro[c + 1][l] == cor && tabuleiro[c + 2][l] == cor
                        && tabuleiro[c + 3][l] == cor) {
                    return true;
                }
            }
        }

        // Verifica vitória na vertical
        for (int c = 0; c < 7; c++) {
            for (int l = 0; l < 3; l++) {
                if (tabuleiro[c][l] == cor && tabuleiro[c][l + 1] == cor && tabuleiro[c][l + 2] == cor
                        && tabuleiro[c][l + 3] == cor) {
                    return true;
                }
            }
        }

        // Verifica vitória na diagonal descendente
        for (int c = 0; c < 4; c++) {
            for (int l = 0; l < 3; l++) {
                if (tabuleiro[c][l] == cor && tabuleiro[c + 1][l + 1] == cor && tabuleiro[c + 2][l + 2] == cor
                        && tabuleiro[c + 3][l + 3] == cor) {
                    return true;
                }
            }
        }

        // Verifica vitória na diagonal ascendente
        for (int c = 0; c < 4; c++) {
            for (int l = 3; l < 6; l++) {
                if (tabuleiro[c][l] == cor && tabuleiro[c + 1][l - 1] == cor && tabuleiro[c + 2][l - 2] == cor
                        && tabuleiro[c + 3][l - 3] == cor) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean tabuleiroCheio(char[][] tabuleiro) {
        for (int c = 0; c < 7; c++) {
            if (tabuleiro[c][0] == 'B') {
                return false;
            }
        }
        return true;
    }
}
