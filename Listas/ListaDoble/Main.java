public class Main {
    public static void main(String[] args) {

        ListaDoblementeEnlazada listaDobleEnlazada = new ListaDoblementeEnlazada();

        listaDobleEnlazada.insertar(5);
        listaDobleEnlazada.insertar(59);
        listaDobleEnlazada.insertar(91);
        listaDobleEnlazada.insertar(-17);
        listaDobleEnlazada.insertar(73);
        listaDobleEnlazada.insertar(34);
        listaDobleEnlazada.insertar(40);
        listaDobleEnlazada.eliminar(2);
        listaDobleEnlazada.eliminar(3);
        System.out.println("El indice tres es: " + listaDobleEnlazada.obtener(3));

    }

}
