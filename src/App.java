public class App {
    public static void main(String[] args) throws Exception {
        Sudoku sudoku = new Sudoku();

        System.out.println("Novo Tabuleiro: \n");

        sudoku.novoTabuleiro(Sudoku.matrizJogo);

        sudoku.exibir();

        sudoku.resolver();

        System.out.println("Tabuleiro Resolvido: \n");

        sudoku.exibir();

    }
}
