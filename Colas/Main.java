public class Main {
    // Para corregir el error de una excepcion Null, debemos hacer que el metodo
    // pueda regresarnos un error de tipo NullPointerException
    public static void main(String[] args) {
        ColaCircular();
    }

    public static void ColaSimple() {

        System.out.println("Cola simple");
        ColaSimple cola = new ColaSimple();
        cola.insertar(1);
        cola.insertar(2);
        cola.insertar(3);
        cola.insertar(4);
        cola.insertar(5);
        System.out.printf("Longitud: %d\n", cola.getLongitud());
        System.out.printf("Frente: %d\n", cola.getFrente().getDato());
        cola.eliminar();
        try {
            System.out.printf("Frente: %d\n", cola.getFrente().getDato());
        } catch (NullPointerException e) {
            System.out.println("La cola se encuentra vacia");
        }

    }

    public static void ColaCircular() {
        ColaCircular colaC = new ColaCircular();
        colaC.insertar(2);
        colaC.insertar(4);
        colaC.insertar(6);
        colaC.insertar(8);
        colaC.insertar(10);
        System.out.printf("Longitud: %d\n", colaC.getLongitud());
        try {
            System.out.printf("Frente: %d\n", colaC.getFrente().getDato());
        } catch (NullPointerException e) {
            System.out.println("Frente no tiene referencia, revise el tamaño de su cola " + e.getMessage());
        }
        System.out.printf("Atras: %d\n", colaC.getAtras().getDato());
        colaC.eliminar();
        System.out.printf("Longitud: %d\n", colaC.getLongitud());
        try {
            System.out.printf("Frente: %d\n", colaC.getFrente().getDato());
            System.out.printf("Atras: %d\n", colaC.getAtras().getDato());
        } catch (NullPointerException e) {
            System.out.println("La cola se encuentra vacia");
        }

    }
}