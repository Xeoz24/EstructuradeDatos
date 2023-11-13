package Arboles;

public class Arbol <T> {
  private NodoArbol <T> raiz;
  private boolean esBinario = false;
//Al crear un arbol se genera la raiz del arbol y el tipo de dato que agregaremos
  public Arbol (T dato, boolean esBinario) {
    raiz = new NodoArbol <T> (dato);
    raiz.setEsBinario(esBinario);
    this.esBinario = esBinario;
  }

  public NodoArbol <T> obtenerRaiz() {
    return raiz;
  }

  public boolean esBinario() {
    return esBinario;
  }
/*
En esta parte el parametro "nodoRaiz" es donde se va insertar, esto quiere decir que se agregará en el nodo que le pongas,
  es como el padre y el nodoAgregado es su hijo */ 
  public void agregarNodoArbol(NodoArbol <T> nodoRaiz, NodoArbol <T> nodoAgregado) {
    if (esBinario) {
      nodoAgregado.setEsBinario(esBinario);
    }

    nodoRaiz.agregarHijo(nodoAgregado);
  }
/*recurre a enum, para poder hacer una busqueda
 del tipo de recorrido que se puso en el parametro "recorrido" que sirve para leer e imprimir el arbol dependiendo de
 Prefijo, Infijo, Posfijo, */
  public void imprimirArbol(Recorrido recorrido) {
    switch (recorrido.ordinal()) {
      case 0:
        System.out.println("Prefijo: ");
        raiz.imprimirEnPrefijo();
        break;

      case 1:
        System.out.println("\nInfijo: ");
        raiz.imprimirEnInfijo();
        break;

      case 2:
        System.out.println("\nPosfijo: ");
        raiz.imprimirEnPosfijo();
        break;
    
      default:
        break;
    }
  }
}