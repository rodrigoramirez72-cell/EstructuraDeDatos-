public class AjedrezEstatico {
  private static final int DIMENSION = 8;

  public static void main(String[] args) {
    Array2D<Character> mesa = new Array2D<>(DIMENSION, DIMENSION);

    char[] negras = { '\u265C', '\u265E', '\u265D', '\u265B', '\u265A', '\u265D', '\u265E', '\u265C' };
    char[] blancas = { '\u2656', '\u2658', '\u2657', '\u2655', '\u2654', '\u2657', '\u2658', '\u2656' };
    char peonN = '\u265F';
    char peonB = '\u2659';

    // Colocacion inicial de todas las piezas en la mesa
    for (int j = 0; j < DIMENSION; j++) {
      mesa.poner(0, j, negras[j]); // piezas principales negras
      mesa.poner(1, j, peonN); // peones negros
      mesa.poner(6, j, peonB); // peones blancos
      mesa.poner(7, j, blancas[j]); // piezas principales blancas
    }

    String etiquetas = "  a b c d e f g h";
    System.out.println(etiquetas);
    for (int i = 0; i < DIMENSION; i++) {
      System.out.print((DIMENSION - i) + " ");
      for (int j = 0; j < DIMENSION; j++) {
        Character ficha = mesa.leer(i, j);
        System.out.print((ficha == null ? '.' : ficha) + " ");
      }
      System.out.println(DIMENSION - i);
    }
    System.out.println(etiquetas);
  }
}
