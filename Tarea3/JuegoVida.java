import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JuegoVida {
    private Array2D<Integer> mundo;
    private int totalPasos;

    public JuegoVida(String ruta) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(ruta));
        String[] cabecera = lineas.get(0).split(",");
        int filas = Integer.parseInt(cabecera[0].trim());
        int columnas = Integer.parseInt(cabecera[1].trim());
        totalPasos = Integer.parseInt(cabecera[2].trim());
        mundo = new Array2D<>(filas, columnas);

        for (int i = 1; i <= filas; i++) {
            String[] valores = lineas.get(i).split(",");
            for (int j = 0; j < columnas; j++) {
                mundo.poner(i - 1, j, Integer.parseInt(valores[j].trim()));
            }
        }
    }

    private int contarVivos(int f, int c) {
        int vivos = 0;
        for (int i = f - 1; i <= f + 1; i++) {
            for (int j = c - 1; j <= c + 1; j++) {
                if (i == f && j == c) {
                    continue;
                }
                if (i >= 0 && i < mundo.totalFilas() && j >= 0 && j < mundo.totalColumnas()) {
                    vivos += mundo.leer(i, j);
                }
            }
        }
        return vivos;
    }

    private void avanzar() {
        int filas = mundo.totalFilas();
        int columnas = mundo.totalColumnas();
        Array2D<Integer> clon = new Array2D<>(filas, columnas);
        clon.llenar(0);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int vecinos = contarVivos(i, j);
                int estado = mundo.leer(i, j);

                boolean sobrevive = estado == 1 && (vecinos == 2 || vecinos == 3);
                boolean nace = estado == 0 && vecinos == 3;
                if (sobrevive || nace) {
                    clon.poner(i, j, 1);
                }
            }
        }
        mundo = clon;
    }

    public void ejecutar() {
        System.out.println("Generacion 0:");
        System.out.println(mundo);
        for (int paso = 1; paso <= totalPasos; paso++) {
            avanzar();
            System.out.println("Generacion " + paso + ":");
            System.out.println(mundo);
        }
    }

    public static void main(String[] args) throws IOException {
        JuegoVida juego = new JuegoVida("escenario.csv");
        juego.ejecutar();
    }
}