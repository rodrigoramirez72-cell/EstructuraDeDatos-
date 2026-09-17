public class PruebaLista {
  public static void main(String[] args) {
    Nodo<String> head = new Nodo<>("Al");
    head.setSiguiente(new Nodo<>("B"));
    head.getSiguiente().setSiguiente(new Nodo<>("C"));
    head.getSiguiente().getSiguiente().setSiguiente(new Nodo<>("De"));
    head.getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo<>("Mc"));
    head.getSiguiente().getSiguiente().getSiguiente().getSiguiente().setSiguiente(new Nodo<>("Zi"));

    System.out.println("La lista queda asi al empezar: " + head);
    System.out.println("Primer elemento: " + head.getDato());

    // recorrer hasta llegar al ultimo nodo
    Nodo<String> nodoActual = head;
    while (nodoActual.getSiguiente() != null) {
      nodoActual = nodoActual.getSiguiente();
    }
    System.out.println("Ultimo nodo: " + nodoActual);

    // localizar "De" para meter "Fe" justo despues
    nodoActual = head;
    while (!nodoActual.getDato().equals("De")) {
      nodoActual = nodoActual.getSiguiente();
    }
    Nodo<String> nodoNuevo = new Nodo<>("Fe");
    nodoNuevo.setSiguiente(nodoActual.getSiguiente());
    nodoActual.setSiguiente(nodoNuevo);
    System.out.println("Insertamos Fe despues de De: " + head);

    // llegar hasta el final y agregar "Zz"
    nodoActual = head;
    while (nodoActual.getSiguiente() != null) {
      nodoActual = nodoActual.getSiguiente();
    }
    nodoActual.setSiguiente(new Nodo<>("Zz"));
    System.out.println("Agregamos Zz al final: " + head);

    // poner "Aa" en la head posicion
    Nodo<String> nodoInicial = new Nodo<>("Aa", head);
    head = nodoInicial;
    System.out.println("Insertamos Aa al inicio: " + head);
  }
}
