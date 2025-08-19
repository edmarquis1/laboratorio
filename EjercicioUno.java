package laboratorio;

public class EjercicioUno {
     public static void main(String[] args) {
        int[] numeros = {10, 25, 32, 45, 18};
        int numeroBuscado = 32;
        boolean encontrado = false;

        for (int numero : numeros) {
            if (numero == numeroBuscado) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("El número " + numeroBuscado + " está en el array.");
        } else {
            System.out.println("El número " + numeroBuscado + " no se encuentra en el array.");
        }
    } 
    
}
