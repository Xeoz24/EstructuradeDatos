package Arboles;

import java.util.Locale.IsoCountryCode;

public class Main {
    public static void main(String[] args) {
        char[] nodos = new char[17];
        char raiz = 'A';

        Arbol arbolGeneral = new Arbol<Object>(raiz, false);

        for (int i = 0; i < 16; i++) {
            nodos[i] = (char) ('B' + i);
            System.out.println(i + "\t" + nodos[i]);
        }

        NodoArbol[] nodosArbol = new NodoArbol[17];

        for (int i = 0; i < 17; i++) {
            nodosArbol[i] = new NodoArbol<Object>(nodos[i]);
        }
        /*
         * Orden del arreglo de caracteres
         * 0 B
         * 1 C
         * 2 D
         * 3 E
         * 4 F
         * 5 G
         * 6 H
         * 7 I
         * 8 J
         * 9 K
         * 10 L
         * 11 M
         * 12 N
         * 13 O
         * 14 P
         * 15 Q
         */
        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodosArbol[0]);
        arbolGeneral.agregarNodoArbol(nodosArbol[0], nodosArbol[3]);
        arbolGeneral.agregarNodoArbol(nodosArbol[0], nodosArbol[4]);

        arbolGeneral.agregarNodoArbol(nodosArbol[4], nodosArbol[8]);
        arbolGeneral.agregarNodoArbol(nodosArbol[4], nodosArbol[9]);
        arbolGeneral.agregarNodoArbol(nodosArbol[4], nodosArbol[10]);

        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodosArbol[1]);

        arbolGeneral.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodosArbol[2]);
        arbolGeneral.agregarNodoArbol(nodosArbol[2], nodosArbol[5]);
        arbolGeneral.agregarNodoArbol(nodosArbol[5], nodosArbol[11]);
        arbolGeneral.agregarNodoArbol(nodosArbol[11], nodosArbol[14]);
        arbolGeneral.agregarNodoArbol(nodosArbol[11], nodosArbol[15]);

        arbolGeneral.agregarNodoArbol(nodosArbol[2], nodosArbol[6]);

        arbolGeneral.agregarNodoArbol(nodosArbol[2], nodosArbol[7]);
        arbolGeneral.agregarNodoArbol(nodosArbol[7], nodosArbol[12]);
        arbolGeneral.agregarNodoArbol(nodosArbol[7], nodosArbol[13]);

        arbolGeneral.imprimirArbol(Recorrido.INFIJO);
        arbolGeneral.imprimirArbol(Recorrido.PREFIJO);
        arbolGeneral.imprimirArbol(Recorrido.POSFIJO);
        System.out.println("\n" + "Este es la altura del arbol: " + arbolGeneral.alturaArbol());
        arbolGeneral.imprimirSubArbol(nodosArbol[2]);

        System.out.println("Arbol binario");
        Arbol arbolBinario = new Arbol<Object>(raiz, true);
        arbolBinario.agregarNodoArbol(arbolGeneral.obtenerRaiz(), nodosArbol[0]);
        arbolBinario.agregarNodoArbol(nodosArbol[0], nodosArbol[3]);
        arbolBinario.agregarNodoArbol(nodosArbol[3], nodosArbol[4]);
        arbolBinario.agregarNodoArbol(nodosArbol[4], nodosArbol[8]);
        arbolBinario.agregarNodoArbol(nodosArbol[8], nodosArbol[9]);
        arbolBinario.agregarNodoArbol(nodosArbol[9], nodosArbol[10]);
        arbolBinario.agregarNodoArbol(nodosArbol[0], nodosArbol[1]);
        arbolBinario.agregarNodoArbol(nodosArbol[1], nodosArbol[2]);
        arbolBinario.agregarNodoArbol(nodosArbol[2], nodosArbol[5]);
        arbolBinario.agregarNodoArbol(nodosArbol[5], nodosArbol[1]);

    }

}
