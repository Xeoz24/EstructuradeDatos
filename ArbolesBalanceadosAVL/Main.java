package ArbolesBalanceadosAVL;

public class Main {
    public static void main(String[] args) {
        ArbolAVL arbolAVL = new ArbolAVL();
        arbolAVL.insertar(20);
        arbolAVL.insertar(23);
        arbolAVL.insertar(23);
        arbolAVL.insertar(100);
        arbolAVL.insertar(190);
        arbolAVL.insertar(111);
        arbolAVL.insertar(141);
        arbolAVL.insertar(121);
        arbolAVL.mostrarArbolAVL();
        /* Confirmamos que existen unos valores que posteriormente vamos a eliminar */
        arbolAVL.buscar(190);
        arbolAVL.buscar(20);
        /*
         * Eliminación del nodo con datos
         * 190 y 20
         */
        System.out.println("\n" + "Despues de eliminar el 180 y el 20");
        arbolAVL.eliminar(190);
        arbolAVL.eliminar(20);
        /* Mostramos el árbol con los datos eliminados y confirmamos que si existe */
        arbolAVL.mostrarArbolAVL();
        arbolAVL.buscar(190);
        arbolAVL.buscar(20);
    }
}
