import java.util.Arrays;

public class BubbleSort {
    
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int longitud= arr.length;
        
        for (int i = 0; i < longitud; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < longitud - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                 
                }
                
               
            }
            
            if (!swapped) {
                break;
            }
            
            System.out.println("- " + Arrays.toString(arr));
        }
        
        return arr;
    }
}
