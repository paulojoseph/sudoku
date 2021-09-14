
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
        private int[][] gabarito;
        public static final int vazio = 0; // Células vazias serão indicadas pelo valor 0
        public static final int tamanho = 9; // Tamanho da matriz do tabuleiro Sudoku
        
        //Recebe uma "matriz jogo" como argumento e gera um novo tabuleiro
        public void criarNovoTabuleiro(int[][] tabuleiro) {
            this.tabuleiro = new int[tamanho][tamanho];
            
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    this.tabuleiro[i][j] = tabuleiro[i][j];
                }
            }

            criarCopiaTabuleiro();
        }

        //Cria uma cópia do tabuleiro
        public void criarCopiaTabuleiro() {
            gabarito = new int[tamanho][tamanho];
            
            for (int i = 0; i < tamanho; i++) {
                for (int j = 0; j < tamanho; j++) {
                    gabarito[i][j] = tabuleiro[i][j];
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

            /*for (int i = 0; i < tamanho; i++) {
                if((i%3 == 0) && (i != 0)){
                    System.out.println("- - - - - - - - - -");

                }
                for (int j = 0; j < tamanho; j++) {
                    if((j%3 == 0) && (j !=0)){
                        System.out.print("|");
                    }
                    System.out.print(" " + gabarito[i][j]);
                }
            
                System.out.println();
            }*/
            
            System.out.println();
        }

        public void inserir(int lin, int col, int valor){
                tabuleiro[lin][col] = valor;
            
        }

        public void remover(int lin, int col, int valor){
            tabuleiro[lin][col] = vazio;
        }

        public boolean checarCelulaVazia(int lin, int col){
            if(tabuleiro[lin][col] == vazio){
                return true;
            }else{
                return false;
            }
        }

        public boolean checarTabuleiroVazio(){
            for (int lin = 0; lin < tamanho; lin++) {
                for (int col = 0; col < tamanho; col++) {
                    // Busca por células vazias (0)
                    if (tabuleiro[lin][col] == vazio) {
                        return true;
                    }
                }
            }
            return false;
        }

        // Verifica se o valor inserido já foi usado na mesma linha
        private boolean checarLinha(int lin, int valor) {
            for (int i = 0; i < tamanho; i++)
                if (tabuleiro[lin][i] == valor){
                    return true;
                }
            return false;
        }    

        // Verifica se o valor inserido já foi usado na mesma coluna
        private boolean checarColuna(int col, int valor) {
            for (int i = 0; i < tamanho; i++)
                if (tabuleiro[i][col] == valor){
                    return true;
                }
            return false;
        }

        // Verifica se o valor inserido já foi usado no mesmo quadrante
        private boolean checarQuadrante(int lin, int col, int valor) {             
            int l = lin - lin % 3; //de 0 a 2 retorna 0, de 3 a 5 retorna 3 e de 6 a 8 retorna 6.
            int c = col - col % 3;
            // Os números 0, 3 e 6 representam o inicio de cada quadrante.
            // O for irá percorrer todas as casas do quadrande de [l][c] a [l+3][c+3]
            for (int i = l; i < l + 3; i++)
                for (int j = c; j < c + 3; j++)
                    if (tabuleiro[i][j] == valor){
                        return true;
                    }
            return false;
        }

        // Combina os métodos de validação de linha, coluna e quadrante para validar o valor inserido em uma posição
        public boolean validarPosicao (int lin, int col, int valor) {
		    return !checarLinha(lin, valor)  &&  !checarColuna(col, valor)  &&  !checarQuadrante(lin, col, valor);
    	}

        // Método para resolver o sudoku utilizando algoritmo de Backtraking.
        public boolean resolver() {
            for (int lin = 0; lin < tamanho; lin++) {
                for (int col = 0; col < tamanho; col++) {
                    // Busca por células vazias (0)
                    if (gabarito[lin][col] == vazio) {
                        // Tenta valores possiveis para a posição
                        for (int valor = 1; valor <= tamanho; valor++) {
                            if (validarPosicao(lin, col, valor)) {
                                // Valor corresponde as regras do sudoku
                                gabarito[lin][col] = valor;

                                if (resolver()) { // Faz o Backtraking chmando a função resolver recursivamente
                                    return true;
                                } else { // Se solução inválida, limpa a célula e continua
                                    gabarito[lin][col] = vazio;
                                }
                            }
                        }

                        return false;
                    }
                }
            }

            return true; // sudoku resolvido
	    }


    }
    
