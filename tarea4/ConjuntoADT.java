import java.util.ArrayList;

public class ConjuntoADT<T> {
  private ArrayList<T> elementos;

  public ConjuntoADT() {
    this.elementos = new ArrayList<>();
  }

  public int longitud() {
    return elementos.size();
  }

  public boolean contieneElemento(T elemento) {
    return elementos.contains(elemento);
  }

  public void agregarElemento(T elemento) {
    if (!elementos.contains(elemento)) {
      elementos.add(elemento);
    }
  }

  public void eliminarElemento(T elemento) {
    elementos.remove(elemento);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null || getClass() != obj.getClass()) return false;
    ConjuntoADT<T> otro = (ConjuntoADT<T>) obj;
    if (this.longitud() != otro.longitud()) return false;
    for (T e : this.elementos) {
      if (!otro.contieneElemento(e)) return false;
    }
    return true;
  }

  public boolean esSubConjunto(ConjuntoADT<T> otroConjunto) {
    for (T e : this.elementos) {
      if (!otroConjunto.contieneElemento(e)) return false;
    }
    return true;
  }

  public ConjuntoADT<T> union(ConjuntoADT<T> otroConjunto) {
    ConjuntoADT<T> resultado = new ConjuntoADT<>();
    for (T e : this.elementos) {
      resultado.agregarElemento(e);
    }
    for (T e : otroConjunto.elementos) {
      resultado.agregarElemento(e);
    }
    return resultado;
  }

  public ConjuntoADT<T> interseccion(ConjuntoADT<T> otroConjunto) {
    ConjuntoADT<T> resultado = new ConjuntoADT<>();
    for (T e : this.elementos) {
      if (otroConjunto.contieneElemento(e)) {
        resultado.agregarElemento(e);
      }
    }
    return resultado;
  }

  public ConjuntoADT<T> diferencia(ConjuntoADT<T> otroConjunto) {
    ConjuntoADT<T> resultado = new ConjuntoADT<>();
    for (T e : this.elementos) {
      if (!otroConjunto.contieneElemento(e)) {
        resultado.agregarElemento(e);
      }
    }
    return resultado;
  }

  @Override
  public String toString() {
    return "ConjuntoADT{elementos=" + elementos + '}';
  }

  public ArrayList<T> getElementos() {
    return elementos;
  }

  public void setElementos(ArrayList<T> elementos) {
    this.elementos = elementos;
  }
}
