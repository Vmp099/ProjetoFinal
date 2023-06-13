import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        liga4();
    }
    public static void liga4() {
        Scanner sc = new Scanner(System.in);
        final int linha = 6, coluna = 7;
        char[][] tabuleiro = new char[coluna][linha];

        for (int l = 0; l < linha; l++) {
            for (int c = 0; c < coluna; c++) {
                tabuleiro[c][l] = 'B';
            }
        }
        System.out.println("_____________________________");
        for (int l = 0; l < linha; l++) {
            for (int c = 0; c < coluna; c++) {
                System.out.print("| " + tabuleiro[c][l] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-----------------------------");

    }
}
