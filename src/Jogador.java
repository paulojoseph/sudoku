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
        String msgFacil = "\033[32;1m"; //define cores
        String msgMedio = "\033[33;1m"; //define cores
        String msgDificil = "\033[31;1m"; //define cores
        String msgSistema = "\033[30;1;44m"; //define cores
        String msgSistema2 = "\033[34;1;40m"; //define cores
        String msgSistema3 = "\033[37;1;40m"; //define cores

        System.out.println(msgSistema2 + "+++++++++++++++++++++++++++++++++++++++");
        System.out.println("+++++++++++" + msgSistema2 + "    "+ msgSistema3 + "SUDOKU" + msgSistema2 + "    " + msgSistema2 + "++++++++++++++");
        System.out.println("+++++++++++++++++++++++++++++++++++++++" + reset);
        System.out.println(msgSistema2 + "|   Escolha uma dificuldade abaixo:   |");
        System.out.println("|   1 - " + msgFacil + "Fácil" + msgSistema2 + "                         |");
        System.out.println("|   2 - " + msgMedio + "Média" + msgSistema2 + "                         |");
        System.out.println("|   3 - " + msgDificil + "Difícil" + msgSistema2 + "                       |");
        System.out.println("---------------------------------------" + reset);

        do {
            System.out.print("Digite o numero da opção desejada:\n> ");
            nivelDificuldade = Integer.parseInt(sc.next());
            if (nivelDificuldade < 1 || nivelDificuldade > 3)
                System.out.println(msgSistema + "Opção inválida! Escolha 1, 2 ou 3" + reset);
            else
                loopPergunta = false;
        } while (loopPergunta);
        
        if (nivelDificuldade == 1) {

            System.out.print("\n     " + msgFacil + " Dificuldade: Fácil  \n" + reset);
        }
        if (nivelDificuldade == 2) {

            System.out.print("\n     " + msgMedio + " Dificuldade: Média  \n" + reset);           
        }
        if (nivelDificuldade == 3) {

            System.out.print("\n     " + msgDificil + " Dificuldade: Difícil  \n" + reset);         
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
