package laboratorio;
import java.util.Scanner;

public class BuscadorMatriz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Matriz predefinida
        int[][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // Número a buscar
        System.out.print("Ingrese un numero a buscar en la matriz: ");
        int numero = scanner.nextInt();

        boolean encontrado = false;

        // Recorrer matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] == numero) {
                    System.out.println("Numero encontrado en [" + i + "][" + j + "]");
                    encontrado = true;
                }
            }
        }

        // Si no se encontro
        if (!encontrado) {
            System.out.println("Numero no encontrado");
        }

        scanner.close();
    }
}