public class App {
    public static void main(String[] args) throws Exception {
        Sudoku sudoku = new Sudoku();

        sudoku.novoTabuleiro(Sudoku.matrizJogo);

        sudoku.exibir();

    }
}
