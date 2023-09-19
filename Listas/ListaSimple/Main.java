public class Main {
    public static void main(String[] args) {

        ListaSimplementeEnlazada listaEnlazada = new ListaSimplementeEnlazada();

        listaEnlazada.insertar(5);
        listaEnlazada.insertar(59);
        listaEnlazada.insertar(91);
        listaEnlazada.insertar(-17);
        listaEnlazada.insertar(73);
        listaEnlazada.insertar(34);
        listaEnlazada.insertar(40);
        listaEnlazada.eliminar(2);
        listaEnlazada.eliminar(3);
        System.out.println("El indice tres es: %d\n" + listaEnlazada.obtener(3));

    }

}
