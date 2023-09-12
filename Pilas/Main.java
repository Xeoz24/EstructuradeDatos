public class Main {
    public static void main(String[] args) {
        Pila pila = new Pila();
        int array_numeros[] = { 14, 27, 1, 15, 10, 90, 71, 37, 2, 48 };
        // Se insertan los datos
        for (int num_aux : array_numeros) {
            pila.insertar(num_aux);
        }
        // Se obtiene el tamaño de la pila
        System.out.println("El tamaño de la pila es: " + pila.getTamanio());
        // Se quitan 4 elementos de la pila
        for (int i = 0; i < 4; i++) {
            pila.quitar();
        }
        // Se obtiene la cima
        System.out.println("El ultimo valor en haber sido introducido es " + pila.obtenerCima());

        // Se vacia la pila
        pila.vaciar();
        // Si esta vacia se imprime "La pila se encuentra vacía"
        if (pila.estaVacia()) {
            System.out.println("La pila se escuentra vacía ");
        } else {
        }
    }
}
