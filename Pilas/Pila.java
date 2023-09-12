public class Pila {
    private Nodo cima;
    private int tamanio;

    public Pila() {
        cima = null;
        tamanio = 0;
    }

    // inserta un nodo
    public void insertar(int dato) {
        Nodo nuevo_nodo = new Nodo(dato);
        nuevo_nodo.setNodo(cima);
        cima = nuevo_nodo;
        tamanio++;
    }

    // reemplaza el nodo con su enlace siguiente, eliminando un dato de la pila
    public int quitar() {
        int datoAux = cima.getDato();
        cima = cima.getNodo();
        tamanio--;
        return datoAux;
    }

    // retorna si la pila esta vacía
    public boolean estaVacia() {
        return cima == null;
    }

    // Elimina todos los nodos hasta que la pila se encuentre vacía
    public void vaciar() {
        while (!estaVacia()) {
            quitar();
        }
    }

    // Se obtiene el ultimo dato insertado en la pila
    public Integer obtenerCima() {
        if (cima == null) {
            System.out.println("La pila se encuentra vacía");
            return null;
        } else {
            return cima.getDato();
        }

    }

    // Da el tamaño de la pila
    public int getTamanio() {
        return tamanio;
    }

}
