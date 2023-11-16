package ArbolesBalanceadosAVL;

public class ArbolAVL {
    NodoAVL raiz;
    public  void vaciarTodo(){
        this.raiz = null;
    }
    public void insertar (int dato){
        raiz = insertarAVL(raiz,dato);
    }
    private NodoAVL insertarAVL (NodoAVL nodoActual, int dato){
        if (nodoActual == null) {
            return (new NodoAVL(dato));
        }

    }
}
