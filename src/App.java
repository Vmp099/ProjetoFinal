import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        new App();
    }

    private App() {
        Scanner sc = new Scanner(System.in);
        final int linha = 6, coluna = 7;
        char[][] tabuleiro = new char[coluna][linha];
        char escolhaCor = 'B', corPc = 'B';
        char escolhaUsuario = 'B';
        for (int l = 0; l < linha; l++) {
            for (int c = 0; c < coluna; c++) {
                tabuleiro[c][l] = 'B';
            }
        }
       escolhaUsuario(escolhaCor, sc);

        sc.close();
    }

    public void mostraJogo(char[][] tabuleiro) {
        System.out.println("=============================");
        System.out.println("| 0 | 1 | 2 | 3 | 4 | 5 | 6 |");
        for (int l = 0; l < 6; l++) {
            for (int c = 0; c < 7; c++) {
                System.out.print("| " + tabuleiro[c][l] + " ");
            }
            System.out.println("|");
        }
        System.out.println("=============================");
    }

    public void escolhaUsuario(char escolhaCor, Scanner sc) {
        do {
            System.out.println("Escolha uma cor V ou A: ");
            escolhaCor = sc.next().charAt(0);
            // Convertendo o caracter para maiúsculo
            escolhaCor = Character.toUpperCase(escolhaCor);
            System.out.println(escolhaCor);
        } while (escolhaCor != 'V' && escolhaCor != 'A');
    }

    //Perguntar se o Jogador que jogar novamente
 public void Usuariojogarnovamente(char resposta, Scanner sc) {   
do {
            System.out.println("Deseja jogar novamente? (S/N)");
            resposta = sc.next().charAt(0);
            resposta = Character.toUpperCase(resposta);
        } while (resposta == 'S');
        System.out.println("Obrigado por jogar!");
    }
}


