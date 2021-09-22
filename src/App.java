public class App {
    public static void main(String[] args) throws Exception {

        Sudoku sudoku = new Sudoku();
        Jogador jogador = new Jogador();
        boolean fimJogo = false;

        int nivelDificuldade = jogador.menujogo();

        if (nivelDificuldade == 1) {
            sudoku.criarNovoTabuleiro(Sudoku.matrizFacil);  
        }
        if (nivelDificuldade == 2) {
            sudoku.criarNovoTabuleiro(Sudoku.matrizMedio);            
        }
        if (nivelDificuldade == 3) {
            sudoku.criarNovoTabuleiro(Sudoku.matrizDificil);            
        }     

        sudoku.exibir();

        while (!fimJogo){
            
            jogador.entrarDados();

            while(!sudoku.checarCelulaVazia(jogador.lin, jogador.col) || (jogador.valor <= 0) || (jogador.valor > 9)){
                System.out.println("\n\033[1;91mJogada inválida. \nUsar números de 1 a 9. \nSelecionar apenas células vazias\u001B[0;0;0m");
                sudoku.exibir();
                jogador.entrarDados();
            }
            
                sudoku.inserir(jogador.lin, jogador.col, jogador.valor);

                sudoku.exibir();

                if(!sudoku.checarTabuleiroVazio()){
                    if(sudoku.sinalizarErro()){
                        if(jogador.continuar()){
                            fimJogo = false;
                            sudoku.remover();
                            sudoku.exibir();
                        }else{
                            System.out.println("\n\033[1;96mFim de jogo\u001B[0;0;0m\n");
                            fimJogo = true;
                        }
                    }else{
                        fimJogo = true;
                        System.out.println("\n\033[1;96mParabéns, jogo finalizado com sucesso!\u001B[0;0;0m\n");
                    }                
                }
        }
    }
}
