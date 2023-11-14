package Arboles;

public class NodoArbol<T> {
  private T dato;
  private boolean esBinario = false;
  private NodoArbol<T> primerHijo;
  private NodoArbol<T> siguienteHermano;

  public NodoArbol(T dato) {
    this.dato = dato;
    primerHijo = null;
    siguienteHermano = null;
  }

  /*
   * Al crear un nodo, este puede tener hijos, por lo tanto se debe agregar los
   * hijos con este metodo, llamando al nodo que le quiere poner los hijos
   * nodoPadre.agregarHijo(TipodeDato: NodoArbol hijo)
   */
  public void agregarHijo(NodoArbol<T> hijo) {
    if (primerHijo == null) {
      primerHijo = hijo;
    } else {
      NodoArbol<T> hermano = this.primerHijo;

      if (esBinario) {
        if (hermano.siguienteHermano != null) {
          System.err.println("El nodo ya tiene un hijo, no se debe agregar " + hijo.getDato());
        } else {
          hermano.siguienteHermano = hijo;
        }
      } else {
        while (hermano.siguienteHermano != null) {
          hermano = hermano.siguienteHermano;
        }
        hermano.siguienteHermano = hijo;
      }
    }
  }

  public NodoArbol<T> obtenerPrimerHijo() {
    return primerHijo;
  }

  public NodoArbol<T> obtenerSiguienteHermano() {
    return siguienteHermano;
  }

  public T getDato() {
    return dato;
  }

  public boolean esBinario() {
    return esBinario;
  }

  public void setEsBinario(boolean esBinario) {
    this.esBinario = esBinario;
  }

  public void imprimirEnPrefijo() {
    System.out.print(dato + "\t");
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPrefijo();
      hijo = hijo.siguienteHermano;
    }
  }

  public void imprimirEnInfijo() {
    NodoArbol<T> hijo = primerHijo;

    if (hijo != null) {
      hijo.imprimirEnInfijo();
    }

    System.out.print(dato + "\t");
    while (hijo != null) {
      hijo = hijo.siguienteHermano;
      if (hijo != null) {
        hijo.imprimirEnInfijo();
      }
    }
  }

  public void imprimirEnPosfijo() {
    NodoArbol<T> hijo = primerHijo;

    while (hijo != null) {
      hijo.imprimirEnPosfijo();
      hijo = hijo.siguienteHermano;
    }

    System.out.print(dato + "\t");
  }
}
