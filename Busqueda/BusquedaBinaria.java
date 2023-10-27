package Busqueda;
import Ordenamiento.QuickSort;
import java.util.Arrays;
import java.util.Random;

public class BusquedaBinaria {
    public static void main(String[] args) {
        //Generamos 1000 numeros al azar en un arreglo 
        int arr[] = new int[1000];
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            arr[i] = random.nextInt(1000) + 1;
        }
        System.out.println("El arreglo tiene:\n " + Arrays.toString(arr));
        System.out.println("Ahora lo arreglamos con el método Quick Sort");
       // QuickSort quickSort = new QuickSort();
    }
       public static int busquedaBinaria (int  [] arr, int numeroBuscado) {
            int result = -1;
            int limiteInferior = 0;
            int limiteSuperior = arr.length - 1;
            int indice;
                         
            while (limiteInferior <= limiteSuperior && result == -1) {
                indice = (limiteInferior + limiteSuperior) / 2;
                     
                if (arr[indice] == numeroBuscado) {
                    System.out.println("Encontrado");
                    result = indice;
                }else if (numeroBuscado > arr[indice]) {
                    limiteInferior = indice + 1;
                }else if (numeroBuscado < arr[indice]) {
                    limiteSuperior = indice - 1;
                }
            }
                 
            return result;
        


    }
}