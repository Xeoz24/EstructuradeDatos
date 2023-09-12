public class Nodo {
    private int dato;
    private Nodo nodo;

    public Nodo(int valor) {
        this.dato = valor;
        this.nodo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getNodo() {
        return nodo;
    }

    public void setNodo(Nodo nodo) {
        this.nodo = nodo;
    }
}