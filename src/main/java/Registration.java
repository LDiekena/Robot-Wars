import java.util.Scanner;

public class Registration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte gebe deinen Namen ein: ");
        String name = sc.nextLine();

        System.out.println("Hallo " + name + "! Viel Spaß beim Spielen!");

        char[][] board = new char[10][10];

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                System.out.print(" " + board[i][j]);
                if(j < 10-1) System.out.print(" │");
            }

            if (i < 10-1) {
                System.out.print("\n───");
                for(int j = 0; j < 10-1; j++) System.out.print("┼───");
                System.out.println();
            }
        }
    }
}
