package proyectofinal;

public class ProyectoFinal {

    // Función para calcular subtotal
    public static int calcularSubtotal(int[] precios, int[] cantidades) {
        int subtotal = 0;
        for (int i = 0; i < precios.length; i++) {
            subtotal += precios[i] * cantidades[i];
        }
        return subtotal;
    }

    public static boolean hayPedido(int[][] cantidades) {
    for (int i = 0; i < cantidades.length; i++) {
        for (int j = 0; j < cantidades[i].length; j++) {
            if (cantidades[i][j] > 0) {
                return true;
            }
        }
    }
    return false;
}

    // Función para generar factura
    public static String generarFactura(String[][] nombres, int[][] precios, int[][] cantidades) {
        String factura = "----- FACTURA -----\n";

        int total = 0;

        // Ciclo anidado (matriz)
        for (int i = 0; i < nombres.length; i++) {
            for (int j = 0; j < nombres[i].length; j++) {
                if (cantidades[i][j] > 0) {
                    int subtotal = precios[i][j] * cantidades[i][j];
                    factura += nombres[i][j] + " x" + cantidades[i][j] + " = $" + subtotal + "\n";
                    total += subtotal;
                }
            }
        }

        factura += "-------------------\n";
        factura += "TOTAL: $" + total;

        return factura;
    }

}