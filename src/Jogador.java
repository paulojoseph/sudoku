import java.util.Scanner;

public class Jogador {

    Scanner sc = new Scanner(System.in);

    public int lin;
    public int col;
    public int valor;

    public void entrarDados(){

        System.out.println("Informe a linha e coluna da célula desejada e o valor a ser preenchido");

        lin = sc.nextInt() - 1;
        col = sc.nextInt() - 1;
        valor = sc.nextInt();

    }

}
