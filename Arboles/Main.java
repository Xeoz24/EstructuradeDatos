package Arboles;

import java.util.Locale.IsoCountryCode;

public class Main {
    public static void main(String[] args) {
        char[] nodos = new char[17];
        char raiz = 'A';

        Arbol arbolito = new Arbol<Object>(raiz, false);

        for (int i = 0; i < 16; i++) {
            nodos[i] = (char) ('B' + i);
            System.out.println(nodos[i]);
        }

        NodoArbol[] nodosArbol = new NodoArbol[17];

        for (int i = 0; i < 17; i++) {
            nodosArbol[i] = new NodoArbol<Object>(nodos[i]);
        }
        arbolito.agregarNodoArbol(arbolito.obtenerRaiz(), nodosArbol[0]);
        arbolito.agregarNodoArbol(nodosArbol[0], nodosArbol[3]);
        arbolito.agregarNodoArbol(nodosArbol[0], nodosArbol[4]);

        arbolito.agregarNodoArbol(nodosArbol[4], nodosArbol[8]);
        arbolito.agregarNodoArbol(nodosArbol[4], nodosArbol[9]);
        arbolito.agregarNodoArbol(nodosArbol[4], nodosArbol[11]);

        arbolito.agregarNodoArbol(arbolito.obtenerRaiz(), nodosArbol[1]);

        arbolito.agregarNodoArbol(arbolito.obtenerRaiz(), nodosArbol[2]);

        arbolito.agregarNodoArbol(nodosArbol[2], nodosArbol[5]);
        arbolito.agregarNodoArbol(nodosArbol[5], nodosArbol[12]);
        arbolito.agregarNodoArbol(nodosArbol[12], nodosArbol[15]);
        arbolito.agregarNodoArbol(nodosArbol[12], nodosArbol[16]);

        arbolito.agregarNodoArbol(nodosArbol[2], nodosArbol[8]);
        arbolito.agregarNodoArbol(nodosArbol[8], nodosArbol[13]);
        arbolito.agregarNodoArbol(nodosArbol[8], nodosArbol[14]);

        System.out.println("Recorrido Infijo");
        arbolito.imprimirArbol(Recorrido.INFIJO);
        System.out.println("Recorrido Prefijo");
        arbolito.imprimirArbol(Recorrido.PREFIJO);
        System.out.println("Recorrido Posfijo");
        arbolito.imprimirArbol(Recorrido.POSFIJO);
    }

}
