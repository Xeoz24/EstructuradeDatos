package ArbolesBalanceadosAVL;

public class ArbolAVL {
    NodoAVL raiz;

    /* Constructor- */
    public ArbolAVL() {
    }

    public void vaciarTodo() {
        this.raiz = null;
    }

    public void insertar(int dato) {
        raiz = insertarAVL(raiz, dato);
    }

    /* /Insertar */
    private NodoAVL insertarAVL(NodoAVL nodoActual, int dato) {

        if (nodoActual == null) {
            return (new NodoAVL(dato));
        }
        if (dato < nodoActual.dato) {
            nodoActual.izquierda = insertarAVL(nodoActual.izquierda, dato);
        } else if (dato > nodoActual.dato) {
            nodoActual.derecha = insertarAVL(nodoActual.derecha, dato);
        } else {// si el dato esta duplicada retorna el mismo nodo encontrado
            return nodoActual;
        }
        nodoActual.altura = 1 + max(getAltura(nodoActual.izquierda), getAltura(nodoActual.derecha));
        /* Factor de equilibrio */
        int factEq = getFactorEquilibrio(nodoActual);
        /* Caso de rotación simple a la derecha */
        if (factEq > 1 && dato < nodoActual.izquierda.dato) {
            return rotacionDerecha(nodoActual);
        }
        /* Caso de rotación simple a la izquierda */
        if (factEq < -1 && dato > nodoActual.derecha.dato) {
            return RotacionIzquierda(nodoActual);
        }
        /* Caso rotación Doble Izquierda Derecha */
        if (factEq > 1 && dato < nodoActual.izquierda.dato) {
            nodoActual.izquierda = rotacionDerecha(nodoActual.izquierda);
            return RotacionIzquierda(nodoActual);
        }
        /* Caso Rotacion Doble Derecha Izquierda */
        if (factEq < -1 && dato < nodoActual.derecha.dato) {
            nodoActual.derecha = rotacionDerecha(nodoActual.derecha);
            return RotacionIzquierda(nodoActual);
        }
        return nodoActual;
    }

    /* Eleminacion */
    public void eliminar(int dato) {
        raiz = eliminarAVL(raiz, dato);
    }

    private NodoAVL eliminarAVL(NodoAVL nodoActual, int dato) {
        if (nodoActual == null)
            return nodoActual;

        if (dato < nodoActual.dato) {
            nodoActual.izquierda = eliminarAVL(nodoActual.izquierda, dato);
        } else if (dato > nodoActual.dato) {
            nodoActual.derecha = eliminarAVL(nodoActual.derecha, dato);
        } else {
            /* nodo es igual al dato, se elimina, nodo con un único hijo o es hoja */
            if ((nodoActual.izquierda == null) || (nodoActual.derecha == null)) {
                NodoAVL temp = null;
                if (temp == nodoActual.izquierda) {
                    temp = nodoActual.derecha;
                } else {
                    temp = nodoActual.izquierda;
                }
                // Cuando no tiene hijos
                if (temp == null) {
                    nodoActual = null;
                } else {/* caso con un hijo */
                    nodoActual = temp;
                } // se elimina el valor actual reemplzandolo por su hijo
            } else {
                /* Nodo con dos hijos se busca al predecesor */
                NodoAVL temp = getNodoConValorMaximo(nodoActual.izquierda);
                // se copia el dato temporalmete
                nodoActual.dato = temp.dato;
                // se elemina el predecesor
                nodoActual.izquierda = eliminarAVL(nodoActual.izquierda, temp.dato);
            }
        }
        if (nodoActual == null) {
            return nodoActual;
        }
        /* actualizar altura */
        nodoActual.altura = max(getAltura(nodoActual.izquierda), getAltura(nodoActual.izquierda)) + 1;
        int factEq = getFactorEquilibrio(nodoActual);
        /* dependiendo del factor de quilibrio se hacen las rotaciones necesarias */
        /* Caso de rotación simple a la derecha */
        if (factEq > 1 && getFactorEquilibrio(nodoActual.izquierda) >= 0) {
            return rotacionDerecha(nodoActual);
        }
        /* Caso de rotación simple a la izquierda */
        if (factEq < -1 && getFactorEquilibrio(nodoActual.derecha) <= 0) {
            return RotacionIzquierda(nodoActual);
        }
        /* Caso rotación Doble Izquierda Derecha */
        if (factEq > 1 && getFactorEquilibrio(nodoActual.izquierda) < 0) {
            nodoActual.izquierda = rotacionDerecha(nodoActual.izquierda);
            return RotacionIzquierda(nodoActual);
        }
        /* Caso Rotacion Doble Derecha Izquierda */
        if (factEq < -1 && getFactorEquilibrio(nodoActual.derecha) > 0) {
            nodoActual.derecha = rotacionDerecha(nodoActual.derecha);
            return RotacionIzquierda(nodoActual);
        }
        return nodoActual;
    }

    /* Busqueda */
    public void buscar(int elemento) {
        if (BuscarEnAVL(raiz, elemento)) {
            System.out.println("El dato " + elemento + " Existe en el Árbol");
        } else {
            System.out.println("El dato " + elemento + " No existe en el Árbol");
        }
    }

    public boolean BuscarEnAVL(NodoAVL nodoActual, int elemento) {
        if (nodoActual == null) {
            return false;
        } else if (elemento == nodoActual.dato) {
            return true;
        } else if (elemento < nodoActual.dato) {
            return BuscarEnAVL(nodoActual.izquierda, elemento);
        } else {
            return BuscarEnAVL(nodoActual.derecha, elemento);
        }
    }
    /* Rotaciones */

    private NodoAVL rotacionDerecha(NodoAVL nodoActual) {
        NodoAVL nuevaRaiz = nodoActual.izquierda;
        NodoAVL aux = nuevaRaiz.derecha;
        /* Se hace la rotación */
        nuevaRaiz.derecha = nodoActual;
        nodoActual.izquierda = aux;
        /* Se actualiza la altura */
        nodoActual.altura = max(getAltura(nodoActual.izquierda), getAltura(nodoActual.derecha)) + 1;
        nuevaRaiz.altura = max(getAltura(nodoActual.izquierda), getAltura(nodoActual.derecha)) + 1;
        return nuevaRaiz;
    }

    /* Rotar hacia la izquierda */
    private NodoAVL RotacionIzquierda(NodoAVL nodoActual) {
        NodoAVL nuevaRaiz = nodoActual.derecha;
        NodoAVL aux = nuevaRaiz.izquierda;

        nuevaRaiz.izquierda = nodoActual;
        nodoActual.derecha = aux;

        nodoActual.altura = max(getAltura(nodoActual.izquierda), getAltura(nodoActual.derecha)) + 1;
        nuevaRaiz.altura = max(getAltura(nodoActual.izquierda), getAltura(nodoActual.derecha)) + 1;
        return nuevaRaiz;
    }

    /* Metodos para mostral el arbol */
    public void mostrarArbolAVL() {
        System.out.println("Arbol AVL");
        mostrarArbol(raiz, 0);
    }

    private void mostrarArbol(NodoAVL nodo, int nivel) {
        if (nodo.derecha != null) {
            mostrarArbol(nodo.derecha, nivel + 1);
        }
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        System.out.println("(" + nodo.dato + ")");
        if (nodo.izquierda != null) {
            mostrarArbol(nodo.izquierda, nivel + 1);
        }
    }

    /* Metodos Auxiliares */
    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private int getAltura(NodoAVL nodoActual) {

        if (nodoActual == null) {
            return 0;
        }
        /*
         * Gracias a las rotaciones obtenemos la actualización de las alturas
         * por lo que no es necesario recorrer el arbol
         */
        return nodoActual.altura;
    }

    private int getFactorEquilibrio(NodoAVL nodoActual) {
        if (nodoActual == null) {
            return 0;
        }
        return getAltura(nodoActual.izquierda) - getAltura(nodoActual.derecha);
    }

    private NodoAVL getNodoConValorMaximo(NodoAVL nodo) {
        NodoAVL actual = nodo;
        while (actual.derecha != null) {
            actual = actual.derecha;
        }
        return actual;
    }

}
