package Busqueda;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BusquedaBinaria {
    public static void main(String[] args) {
        // Generamos 1000 numeros al azar en un arreglo
        int arr[] = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            arr[i] = random.nextInt(1000) + 1;
        }
        // Generamos un algoritmo de ordenamiento, para cumplir con la condición de la
        // busqueda Binaria
        int[] arrOrdenado = QuickSort.quickSort(arr);
        System.out.println("Ahora lo arreglamos con el método Quick Sort");
        System.out.println("El arreglo tiene:\n " + Arrays.toString(arrOrdenado));
        /*
         * Ahora damos uso de nuestro algoritmo de busqueda para encontra si existe el
         * numero 1000 y un numero fuera de nuestros limites
         * generados por el Math Random
         */
        int numeroBuscado;
        System.out.println("Inserte un numero que desee buscar");
        Scanner consola = new Scanner(System.in);
        
        numeroBuscado = consola.nextInt();    
        
        
        System.out.println("El numero a encontrar será el " + numeroBuscado  );
        System.out.println(busquedaBinaria(arrOrdenado, numeroBuscado));

        //Este será un numero que nunca va encontrar ya que esta fuera de los limites
        System.out.println("El numero a encontrar será el 1020, el cual se encuentra fuera de los limites");  
        if ( busquedaBinaria(arrOrdenado, 1020)==-1 ) {
            System.out.println("Numero no encontrado");
        }
    }

    public static int busquedaBinaria(int[] arr, int numeroBuscado) {
        int result = -1;
        int limiteInferior = 0;
        int limiteSuperior = arr.length - 1;
        int indice;

        while (limiteInferior <= limiteSuperior && result == -1) {
            indice = (limiteInferior + limiteSuperior) / 2;

            if (arr[indice] == numeroBuscado) {
                System.out.println("Encontrado en la posición: ");
                result = indice;
            } else if (numeroBuscado > arr[indice]) {
                limiteInferior = indice + 1;
            } else if (numeroBuscado < arr[indice]) {
                limiteSuperior = indice - 1;
            }
        }

        return result;

    }
}