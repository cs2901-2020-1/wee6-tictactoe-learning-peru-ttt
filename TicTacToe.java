import java.util.Scanner;

public class TicTacToe {

    //Matriz
    private static String[][] M = new String[3][3];
    //True = 1p. False = 2p
    private static boolean player = true;
    private static Integer turno = 0;

    public static void createMatrix() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                M[i][j] = null;
    }

    public static boolean theGameIsOver(int x, int y) {
        if (turno < 4) {
            return false;
        }

        //Chequear fila, columna y diagonal de x y
        //Fila
        String aux = M[x][y];

        if (aux.equals(M[0][y]) && aux.equals(M[1][y]) && aux.equals(M[2][y])) {
            return true;
        }

        if (aux.equals(M[x][0]) && aux.equals(M[x][1]) && aux.equals(M[x][2])) {
            return true;
        }

        if (x+y % 2 == 0 || x == y) {
            if (aux.equals(M[0][0]) && aux.equals(M[1][1]) && aux.equals(M[2][2])) {
                return true;
            }

            if (aux.equals(M[2][0]) && aux.equals(M[1][1]) && aux.equals(M[0][2])) {

                return true;
            }
        }

        return false;
    }

    public static void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (M[i][j] != null) {
                    System.out.print(M[i][j]);
                } else {
                    System.out.print("-");
                }

            }
            System.out.print("\n");
        }

    }

    public static void play(Integer posx, Integer posy) {
        if (player) {
            M[posx][posy] = "X";
        } else {
            M[posx][posy] = "O";
        }
        print();
        turno++;
    }

    public static void main (String [] Args) {
        System.out.println("Bienvenido a TicTacToe!");
        createMatrix();
        int x=0, y=0;

        while(!theGameIsOver(x, y)) {
            String p = player ? "player 1" : "player 2";
            System.out.println("Turno de " + p);
            System.out.println("Ingrese las coordenadas (x, y)");

            do {
                Scanner scanner = new Scanner(System.in);
                x = scanner.nextInt();
                y = scanner.nextInt();
            } while (M[x][y] != null);

            play(x, y);
            player = !player;
        }

        if (turno != 9) {
            String p = player ? "player 1" : "player 2";
            System.out.println("Gano " + p);
        }

        System.out.println("Fin de programa");

    }

}
