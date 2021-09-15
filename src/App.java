public class App {
    public static void main(String[] args) throws Exception {

        Sudoku sudoku = new Sudoku();

        Jogador jogador = new Jogador();

        System.out.println("Novo Tabuleiro: \n");

        sudoku.criarNovoTabuleiro(Sudoku.matrizJogo);

        sudoku.exibir();

        while(sudoku.checarTabuleiroVazio()){

            jogador.entrarDados();

            while(!sudoku.checarCelulaVazia(jogador.lin, jogador.col) || (jogador.valor <= 0) || (jogador.valor > 9)){
                System.out.println("Jogada inválida. Usar números de 1 a 9 para selecionar células vazias (0)");
                jogador.entrarDados();
            }
            sudoku.criarCopiaTabuleiro();
            if (sudoku.validarPosicao(jogador.lin, jogador.col, jogador.valor)){
                sudoku.inserir(jogador.lin, jogador.col, jogador.valor);
                if (!sudoku.resolver()){
                    sudoku.remover(jogador.lin, jogador.col, jogador.valor);
                    System.out.println("Jogada inválida: Tabuleiro sem resolução, tente outra vez!");
                }else{
                    sudoku.exibir();
                }
            }else{
                System.out.println("Jogada inválida: Número repetido, tente outra vez!");
            }
        
        }

        System.out.println("Tabuleiro Resolvido: \n");

        sudoku.exibir();

    }
}
