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

}