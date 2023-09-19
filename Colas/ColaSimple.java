public class ColaSimple {
    private Nodo frente;
    private int longitud;

    public ColaSimple() {
        frente = null;
        longitud = 0;
    }

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (frente == null) {
            frente = nuevoNodo;
        } else {
            Nodo nodoActual = frente;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        longitud++;
    }

    public void eliminar() {
        if (frente != null) {
            frente = frente.getSiguiente();
            longitud--;
        }
    }

    public boolean estaVacia() {
        return true;
    }
    //Para corregir el error de una excepcion Null, debemos hacer que el metodo pueda regresarnos un error de tipo NullPointerException
    public Nodo getFrente() throws NullPointerException {
        if (frente == null) {
            throw new NullPointerException("Frente no logra encontra una referencia, revise si su cola esta llena");
        }
        return frente;
    }

    public int getLongitud() {
        return longitud;
    }
}
