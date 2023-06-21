import java.util.Random;
import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        new App();
    }

    private App() {
        Scanner sc = new Scanner(System.in);
        final int linha = 6, coluna = 7;
        char[][] tabuleiro = new char[coluna][linha];
        char escolhaCor = 'B';
        int posicaoEscolhida = 0;
        for (int l = 0; l < linha; l++) {
            for (int c = 0; c < coluna; c++) {
                tabuleiro[c][l] = 'B';
            }
        }
       char corUser = escolhaUsuario(escolhaCor, sc);
       char corPc   = escolhaPc(corUser);
       System.out.println("Cor Usuário: " + corUser + "\nCor Pc: " + corPc);
        adicionaTabela(tabuleiro, corPc, corUser, posicaoEscolhida, sc);


        sc.close();
    }

    public void mostraJogo(char[][] tabuleiro) {
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

    public char escolhaUsuario(char escolhaCor, Scanner sc) {
        char escolhaUser = escolhaCor;
        do {
            System.out.println("Escolha uma cor V ou A: ");
            escolhaUser = sc.next().charAt(0);
            // Convertendo o caracter para maiúsculo
            escolhaUser = Character.toUpperCase(escolhaUser);
            System.out.println(escolhaUser);
        } while (escolhaUser != 'V' && escolhaUser != 'A');
        return escolhaUser;
    }
    public char escolhaPc(char escolhaUser){
        char corPc = 'B';
        if (escolhaUser == 'A') {
        corPc = 'V';
       }else if (escolhaUser == 'V') {
        corPc = 'A';
       }else{
        corPc = 'B';
       }
       return corPc;
    }

    //Perguntar se o Jogador que jogar novamente
    public void usuarioJogarNovamente(char resposta, Scanner sc) {   
        do {
            System.out.println("Deseja jogar novamente? (S/N)");
            resposta = sc.next().charAt(0);
            resposta = Character.toUpperCase(resposta);
        } while (resposta == 'S');
        System.out.println("Obrigado por jogar!");
    }

    public void adicionaTabela(char[][]tabuleiro, char corPc, char corUser,int posicaoEscolhida, Scanner sc){
        int posicao = posicaoEscolhida;
        
        // jogador
        do {
            mostraJogo(tabuleiro);
            System.out.println("Informe a coluna desejada: (0 a 6)");
            posicao = sc.nextInt();

            if(tabuleiro[posicao][0] == 'B'){
                for (int i = 5; i >= 0; i--) {
                    if(tabuleiro[posicao][i] == 'B'){
                        tabuleiro[posicao][i] = corUser;
                        break;
                    }   
                }
            }else{
                posicao = 7;
                System.out.println("teste!");
                System.out.println("Coluna Cheia!");
            }
        } while (posicao < 0 || posicao > 6);

        //pc

        do {
            Random gerador = new Random();
            posicao = (int) gerador.nextInt(7);
            if(tabuleiro[posicao][0] == 'B'){
                for (int i = 5; i >= 0; i--) {
                    if(tabuleiro[posicao][i] == 'B'){
                        tabuleiro[posicao][i] = corPc;
                        break;
                    }   
                }
            }else{
                posicao = 7;
            }
        } while (posicao < 0 || posicao > 6);
        
        

        mostraJogo(tabuleiro);
    }
    
}