import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        //Scanner sc = new Scanner(System.in);
        int nivelDificuldade = -1;
        boolean loppPergunta = true;
        String reset = "\u001B[0m";     //define cores
        String msgFacil = "\033[42m"; //define cores
        String msgMedio = "\033[43m"; //define cores
        String msgDificil = "\033[41m"; //define cores
        String msgSistema = "\033[47m"; //define cores

        Sudoku sudoku = new Sudoku();
        Jogador jogador = new Jogador();

        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++ SUDOKU +++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println("|   Escolha uma dificuldade abaixo:   |");
        System.out.println("|   1 - Fácil                         |");
        System.out.println("|   2 - Média                         |");
        System.out.println("|   3 - Dificil                       |");
        System.out.println("---------------------------------------");
        
        do {
            System.out.print("Digite o numero da opção desejada:\n> ");
            nivelDificuldade = Integer.parseInt(sc.next());
            if (nivelDificuldade < 1 || nivelDificuldade > 3)
                System.out.println(msgSistema + "Opção inválida! Escolha 1, 2 ou 3" + reset);
            else
                loopPergunta = false;
        } while (loopPergunta);

        
        if (nivelDificuldade == 1) {

            System.out.print("\n     " + msgFacil + " Dificuldade: Fácil  " + reset);
            sudoku.criarNovoTabuleiro(Sudoku.matrizFacil);  
        }
        if (nivelDificuldade == 2) {

            System.out.print("\n     " + msgMedio + " Dificuldade: Média  " + reset);
            sudoku.criarNovoTabuleiro(Sudoku.matrizMedio);            
        }
        if (nivelDificuldade == 3) {

            System.out.print("\n     " + msgDificil + " Dificuldade: Difícil" + reset);
            sudoku.criarNovoTabuleiro(Sudoku.matrizDificil);            
        }     

        System.out.println("\n\n\033[1;120;20mTabuleiro:\033[0m\n");

        //sudoku.criarNovoTabuleiro(Sudoku.matrizFacil);

        sudoku.exibir();

        while(sudoku.checarTabuleiroVazio()){

            jogador.entrarDados();

            while(!sudoku.checarCelulaVazia(jogador.lin, jogador.col) || (jogador.valor <= 0) || (jogador.valor > 9)){
                System.out.println("Jogada inválida. Usar números de 1 a 9 para selecionar células vazias (0)\n");
                sudoku.exibir();
                jogador.entrarDados();
                sudoku.exibir();
            }

            sudoku.criarCopiaTabuleiro();
            
            if (sudoku.validarPosicao(jogador.lin, jogador.col, jogador.valor)){
                sudoku.inserir(jogador.lin, jogador.col, jogador.valor);
                sudoku.criarCopiaTabuleiro();
                if (!sudoku.resolver()){
                    sudoku.remover(jogador.lin, jogador.col, jogador.valor);
                    System.out.println("Jogada inválida: Tabuleiro sem resolução, tente outra vez!\n");
                }else{
                    sudoku.exibir();
                }
            }else{
                System.out.println("Jogada inválida: Número repetido, tente outra vez!\n");
                //sudoku.remover(jogador.lin, jogador.col, jogador.valor);
                sudoku.exibir();
            }
        
        }

        System.out.println("Tabuleiro Resolvido: \n");

        sudoku.exibir();
    }
}
