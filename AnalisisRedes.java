import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AnalisisRedes {

    public static int obtenerColumnaMes(String mesTexto) {
        mesTexto = mesTexto.toUpperCase().trim();
        switch (mesTexto) {
            case "ENERO": return 3;
            case "FEBRERO": return 4;
            case "MARZO": return 5;
            case "ABRIL": return 6;
            case "MAYO": return 7;
            case "JUNIO": return 8;
            default: return 3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cálculo de visualizaciones de YouTube ---");
        System.out.print("Ingresa el primer mes (ej. ENERO): ");
        String mes1 = scanner.nextLine();
        System.out.print("Ingresa el segundo mes (ej. JUNIO): ");
        String mes2 = scanner.nextLine();

        int col1 = obtenerColumnaMes(mes1);
        int col2 = obtenerColumnaMes(mes2);

        int difSeguidoresTw = 0;
        int difVistasYt = 0;
        double promedioCrecimientoFb = 0.0;
        double promedioCrecimientoTw = 0.0;
        double promedioMeGustaFb = 0.0;
        double promedioMeGustaTw = 0.0;
        double promedioMeGustaYt = 0.0;

        try (BufferedReader br = new BufferedReader(new FileReader("Estructura de datos.csv"))) {
            String linea;
            br.readLine(); 

            while ((linea = br.readLine()) != null) {
                String[] fila = linea.split(",");
                if (fila.length < 9) continue;

                String red = fila[0].trim();
                String concepto = fila[1].trim();

                if (red.equals("TWITTER") && concepto.equals("SEGUIDORES (FOLLOWERS)")) {
                    int enero = Integer.parseInt(fila[3].trim());
                    int junio = Integer.parseInt(fila[8].trim());
                    difSeguidoresTw = junio - enero;
                }

                if (red.equals("YOUTUBE") && concepto.equals("VISUALIZACIONES")) {
                    int vistas1 = Integer.parseInt(fila[col1].trim());
                    int vistas2 = Integer.parseInt(fila[col2].trim());
                    difVistasYt = vistas2 - vistas1;
                }

                if (red.equals("FACEBOOK") && concepto.equals("CRECIMIENTO (seguidores)")) {
                    int suma = Integer.parseInt(fila[3].trim()) + Integer.parseInt(fila[4].trim()) +
                               Integer.parseInt(fila[5].trim()) + Integer.parseInt(fila[6].trim()) +
                               Integer.parseInt(fila[7].trim()) + Integer.parseInt(fila[8].trim());
                    promedioCrecimientoFb = suma / 6.0;
                }

                if (red.equals("TWITTER") && concepto.equals("CRECIMIENTO DE FOLLOWERS")) {
                    int suma = Integer.parseInt(fila[3].trim()) + Integer.parseInt(fila[4].trim()) +
                               Integer.parseInt(fila[5].trim()) + Integer.parseInt(fila[6].trim()) +
                               Integer.parseInt(fila[7].trim()) + Integer.parseInt(fila[8].trim());
                    promedioCrecimientoTw = suma / 6.0;
                }

                if (red.equals("FACEBOOK") && concepto.equals("ME GUSTA EN PUBLICACIONES")) {
                    int suma = Integer.parseInt(fila[3].trim()) + Integer.parseInt(fila[4].trim()) +
                               Integer.parseInt(fila[5].trim()) + Integer.parseInt(fila[6].trim()) +
                               Integer.parseInt(fila[7].trim()) + Integer.parseInt(fila[8].trim());
                    promedioMeGustaFb = suma / 6.0;
                }

                if (red.equals("TWITTER") && concepto.equals("ME GUSTA")) {
                    int suma = Integer.parseInt(fila[3].trim()) + Integer.parseInt(fila[4].trim()) +
                               Integer.parseInt(fila[5].trim()) + Integer.parseInt(fila[6].trim()) +
                               Integer.parseInt(fila[7].trim()) + Integer.parseInt(fila[8].trim());
                    promedioMeGustaTw = suma / 6.0;
                }

                if (red.equals("YOUTUBE") && concepto.equals("ME GUSTA")) {
                    int suma = Integer.parseInt(fila[3].trim()) + Integer.parseInt(fila[4].trim()) +
                               Integer.parseInt(fila[5].trim()) + Integer.parseInt(fila[6].trim()) +
                               Integer.parseInt(fila[7].trim()) + Integer.parseInt(fila[8].trim());
                    promedioMeGustaYt = suma / 6.0;
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al procesar el archivo: " + e.getMessage());
        }

        System.out.println("\n--- RESULTADOS ---");
        System.out.println("Diferencia de seguidores en Twitter (Junio respecto a Enero): " + difSeguidoresTw);
        System.out.println("Diferencia de vistas en YouTube (" + mes2.toUpperCase() + " respecto a " + mes1.toUpperCase() + "): " + difVistasYt);
        System.out.printf("Promedio de crecimiento de Facebook (Ene-Jun): %.2f\n", promedioCrecimientoFb);
        System.out.printf("Promedio de crecimiento de Twitter (Ene-Jun): %.2f\n", promedioCrecimientoTw);
        System.out.printf("Promedio de 'Me gusta' en Facebook (Ene-Jun): %.2f\n", promedioMeGustaFb);
        System.out.printf("Promedio de 'Me gusta' en Twitter (Ene-Jun): %.2f\n", promedioMeGustaTw);
        System.out.printf("Promedio de 'Me gusta' en YouTube (Ene-Jun): %.2f\n", promedioMeGustaYt);
        
        scanner.close();
    }
                                                }
