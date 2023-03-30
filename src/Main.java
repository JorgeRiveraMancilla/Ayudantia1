import edu.princeton.cs.stdlib.StdIn;
import edu.princeton.cs.stdlib.StdOut;

public class Main {
    public static void main(String[] args) {
        int saldo = 1000;
        int[] ruedas = new int[3];

        while (saldo != 0) {
            StdOut.print("Su saldo actual es $" + saldo + ". ¿Cuánto desea apostar? ");
            int apuesta = StdIn.readInt();

            if (0 < apuesta && apuesta <= saldo) {
                saldo -= apuesta;

                ruedas[0] = (int) (Math.random() * 10);
                ruedas[1] = (int) (Math.random() * 10);
                ruedas[2] = (int) (Math.random() * 10);

                imprimirJuego(ruedas);

                int premio = obtenerPremio(ruedas, apuesta);

                if (0 < premio) {
                    StdOut.println("Usted obtiene $" + premio);
                    saldo += premio;
                }
            } else {
                if (apuesta == 0) {
                    StdOut.println("Muchas gracias por Jugar.  Su saldo final es de $" + saldo + ".");
                    break;
                } else {
                    StdOut.println("Por favor, ingrese apuestas válidas para jugar o 0 para salir");
                }
            }
        }

        if (saldo == 0) {
            StdOut.println("Muchas Gracias por jugar.  Mejor suerte la próxima vez.");
        }
    }

    /**
     * Despliega los valores del arreglo de ruedas.
     * @param ruedas Arreglo que representa el tragamonedas.
     */
    public static void imprimirJuego(int[] ruedas) {
        StdOut.println("+---+---+---+");
        for (int i = 0; i < 3; i++) {
            if (ruedas[i] == 0) {
                StdOut.print("| * ");
            } else {
                StdOut.print("| " + ruedas[i] + " ");
            }
        }
        StdOut.println("|");
        StdOut.println("+---+---+---+");
    }

    /**
     * Calcula el premio a recibir.
     * @param ruedas Arreglo que representa el tragamonedas.
     * @param apuesta Valor apostado.
     * @return Valor del premio.
     */
    public static int obtenerPremio(int[] ruedas, int apuesta) {
        if (ruedas[0] == ruedas[1] && ruedas[1] == ruedas[2] && ruedas[0] != 0) {
            return ruedas[0] * apuesta;
        }

        int contador = 0;
        for (int i = 0; i < 3; i++) {
            if (ruedas[i] == 0) {
                contador++;
            }
        }

        switch (contador) {
            case 1:
                return 50;
            case 2:
                return 300;
            case 3:
                return 500;
            default:
                return 0;
        }
    }
}