public class ColaCircular {
    private Nodo frente;
    private Nodo atras;
    private int longitud;

    public ColaCircular() {
        frente = null;
        atras = null;
        longitud = 0;
    }

    public void insertar(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
            atras = nuevoNodo;
            atras.setSiguiente(frente);
        } else {
            atras.setSiguiente(nuevoNodo);
            atras = nuevoNodo;
            atras.setSiguiente(frente);
        }
        longitud++;
    }

    public void eliminar() {
        if (!estaVacia()) {
            if (frente == atras) {
                frente = null;
                atras = null;
            } else {
                frente = frente.getSiguiente();
                atras.setSiguiente(frente);
            }
            longitud--;
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }

    /*
     * Para corregir el error de una excepcion Null, debemos hacer que el metodo
     * pueda regresarnos un error de tipo NullPointerException
     * se hace de igualmanera para el metodo getAtras()
     */
    public Nodo getFrente() throws NullPointerException {
        if (frente == null) {
            throw new NullPointerException("Frente no logra encontra una referencia, revise si su cola esta llena");
        }
        return frente;
    }

    public Nodo getAtras() throws NullPointerException {
        if (atras == null) {
            throw new NullPointerException("Atras no logra encuentra una referencia, revise el tamaño de la cola");
        }
        return atras;
    }

    public int getLongitud() {
        return longitud;
    }
}
