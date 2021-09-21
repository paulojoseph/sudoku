import java.util.Scanner;

public class Jogador {

    Scanner sc = new Scanner(System.in);

    public int lin;
    public int col;
    public int valor;

    public int nivelDificuldade;

    public void entrarDados(){

        System.out.println("Informe a linha e coluna da célula desejada e o valor a ser preenchido");

        lin = Integer.parseInt(sc.next()) - 1;
        col = Integer.parseInt(sc.next()) - 1;
        valor = Integer.parseInt(sc.next());

    }
    public int menujogo(){
        //Scanner sc = new Scanner(System.in);
        int nivelDificuldade = -1;

        boolean loopPergunta = true;
        String reset = "\u001B[0;0;0m";     //define cores
        String msgFacil = "\033[42m"; //define cores
        String msgMedio = "\033[43m"; //define cores
        String msgDificil = "\033[41m"; //define cores
        String msgSistema = "\033[1;1;105m"; //define cores
        String msgSistema2 = "\033[1;90m"; //define cores

        System.out.println(msgSistema + "+++++++++++++++++++++++++++++++++++++++");
        System.out.println("++++++++++++++ " + msgSistema2 + "SUDOKU +++++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++" + reset);
        System.out.println("|   Escolha uma dificuldade abaixo:   |");
        System.out.println("|   1 - " + msgFacil + "Fácil" + reset + "                         |");
        System.out.println("|   2 - " + msgMedio + "Média" + reset + "                         |");
        System.out.println("|   3 - " + msgDificil + "Difícil" + reset + "                         |");
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
        }
        if (nivelDificuldade == 2) {

            System.out.print("\n     " + msgMedio + " Dificuldade: Média  " + reset);           
        }
        if (nivelDificuldade == 3) {

            System.out.print("\n     " + msgDificil + " Dificuldade: Difícil" + reset);         
        }

        return nivelDificuldade;
    }

    public boolean continuar(){
        String continuar;
        System.out.println("Existem casas com números repetidos. Deseja continuar?\n s - Sim \n n - não");
        continuar = sc.next();
        if(continuar.equals("s")){
            return true;
        }
        return false;
    }

}
