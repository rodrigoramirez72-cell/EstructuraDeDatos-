public class Array2D<T> {
    private int filas;
    private int columnas;
    private Object[][] celdas;

    public Array2D(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        this.celdas = new Object[filas][columnas];
    }

    public void llenar(T valor) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                celdas[i][j] = valor;
            }
        }
    }

    public int totalFilas() {
        return filas;
    }

    public int totalColumnas() {
        return columnas;
    }

    public void poner(int i, int j, T valor) {
        if (i >= 0 && i < filas && j >= 0 && j < columnas) {
            celdas[i][j] = valor;
        } else {
            throw new ArrayIndexOutOfBoundsException("Posicion invalida [" + i + ", " + j + "]");
        }
    }

    @SuppressWarnings("unchecked")
    public T leer(int i, int j) {
        if (i >= 0 && i < filas && j >= 0 && j < columnas) {
            return (T) celdas[i][j];
        } else {
            throw new ArrayIndexOutOfBoundsException("Posicion invalida [" + i + ", " + j + "]");
        }
    }

    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        for (int i = 0; i < filas; i++) {
            salida.append("[");
            for (int j = 0; j < columnas; j++) {
                salida.append(celdas[i][j]);
                if (j < columnas - 1) {
                    salida.append(", ");
                }
            }
            salida.append("]\n");
        }
        return salida.toString();
    }
}