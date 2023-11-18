package ArbolesBalanceadosAVL;

public class NodoAVL {
    int altura;
    int dato;
    NodoAVL izquierda;
    NodoAVL derecha;

    NodoAVL(int dato) {
        this.dato = dato;
        // conveniencia, para preguntar, la altura si es que nuestro
        // padre esta preguntando la altura de nosotros
        this.altura = 1;
    }
}
