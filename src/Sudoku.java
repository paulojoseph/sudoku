
public class Sudoku {

        // Definição de uma matriz simples para jogo. A matriz é um Array 2D.
        public static int[][] matrizJogo = {
                {9,0,0,1,0,0,0,0,5},
                {0,0,5,0,9,0,2,0,1},
                {8,0,0,0,4,0,0,0,0},
                {0,0,0,0,8,0,0,0,0},
                {0,0,0,7,0,0,0,0,0},
                {0,0,0,0,2,6,0,0,9},
                {2,0,0,3,0,0,0,0,6},
                {0,0,0,2,0,0,9,0,0},
                {0,0,1,9,0,4,5,7,0},
        };
        
        private int[][] tabuleiro;
        public static final int vazio = 0; // Células vazias serão indicadas pelo valor 0
        public static final int tamanho = 9; // Tamanho da matriz do tabuleiro Sudoku
        
        //Recebe uma "matriz jogo" como argumento e gera um novo tabuleiro
        public void novoTabuleiro(int[][] tabuleiro) {
            this.tabuleiro = new int[tamanho][tamanho];
            
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    this.tabuleiro[i][j] = tabuleiro[i][j];
                }
            }
        }
        //Imprime o tabuleiro no terminal
        public void exibir() {
            for (int i = 0; i < tamanho; i++) {
                if((i % 3 == 0) && (i != 0)){
                    System.out.println("- - - - - - - - - -");

                }
                for (int j = 0; j < tamanho; j++) {
                    if((j % 3 == 0) && (j != 0)){
                        System.out.print("|");
                    }
                    System.out.print(" " + tabuleiro[i][j]);
                }
            
                System.out.println();
            }
            
            System.out.println();
        }
      
      // ...
    }
    
