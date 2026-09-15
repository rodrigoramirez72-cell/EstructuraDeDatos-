public class Main {
  public static void main(String[] args) {
    ConjuntoADT<String> ana = new ConjuntoADT<>();
    ConjuntoADT<String> luis = new ConjuntoADT<>();

    ana.agregarElemento("ED");
    ana.agregarElemento("BD");
    ana.agregarElemento("Redes");
    ana.agregarElemento("IA");

    luis.agregarElemento("ED");
    luis.agregarElemento("Redes");
    luis.agregarElemento("SO");

    System.out.println("Ana: " + ana);
    System.out.println("Luis: " + luis);
    System.out.println();

    System.out.println("Longitud Ana: " + ana.longitud());
    System.out.println("Longitud Luis: " + luis.longitud());
    System.out.println();

    System.out.println("Ana contiene 'BD': " + ana.contieneElemento("BD"));
    System.out.println("Luis contiene 'BD': " + luis.contieneElemento("BD"));
    System.out.println();

    System.out.println("Union: " + ana.union(luis));
    System.out.println("Interseccion: " + ana.interseccion(luis));
    System.out.println("Diferencia (Ana - Luis): " + ana.diferencia(luis));
    System.out.println("Diferencia (Luis - Ana): " + luis.diferencia(ana));
    System.out.println();

    ConjuntoADT<String> sub = new ConjuntoADT<>();
    sub.agregarElemento("ED");
    sub.agregarElemento("Redes");
    System.out.println("{ED, Redes} es subconjunto de Ana: " + sub.esSubConjunto(ana));
    System.out.println("{ED, Redes} es subconjunto de Luis: " + sub.esSubConjunto(luis));
    System.out.println();

    ConjuntoADT<String> copia = new ConjuntoADT<>();
    copia.agregarElemento("ED");
    copia.agregarElemento("Redes");
    copia.agregarElemento("SO");
    System.out.println("Luis equals {ED, Redes, SO}: " + luis.equals(copia));
    System.out.println("Luis equals Ana: " + luis.equals(ana));
    System.out.println();

    System.out.println("Agregar 'ED' a Ana (duplicado):");
    ana.agregarElemento("ED");
    System.out.println("Ana despues de duplicado: " + ana);
    System.out.println("Longitud Ana: " + ana.longitud());
    System.out.println();

    System.out.println("Eliminar 'BD' de Ana:");
    ana.eliminarElemento("BD");
    System.out.println("Ana despues de eliminar: " + ana);
  }
}
