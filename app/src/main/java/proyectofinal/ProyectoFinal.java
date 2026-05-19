package proyectofinal;

import javax.swing.JOptionPane;

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

    // Commit 3: Creación manualamente e ingreso de los datos en las matrices,
    // selección de tipo de usuario y validación de clave para administrador
    public static void main(String[] args) {

        // MATRICES - Categorías: Hamburguesas, Perros, Perras, Papas, Adicionales,
        // Bebidas
        String[][] nombres = {
                { "Hamburguesa Sencilla", "Hamburguesa Especial", "Hamburguesa de la Casa" },
                { "Perro Sencillo", "Perro Especial", "Super Dog" },
                { "Perra Sencilla", "Perra Especial", "Super Doggy" },
                { "Papas a la francesa" },
                { "Queso", "Tocineta", "Ensalada" },
                { "Gaseosa Personal", "Gaseosa Familiar", "Limonada", "Té", "Jugos" }
        };

        int[][] precios = {
                { 14000, 18000, 21000 },
                { 11000, 13000, 15000 },
                { 12000, 14000, 16000 },
                { 7000 },
                { 5000, 5000, 5000 },
                { 5000, 10000, 8000, 6000, 6000 }
        };

        int[][] cantidades = new int[6][];
        for (int i = 0; i < nombres.length; i++) {
            cantidades[i] = new int[nombres[i].length];
        }

        int tipoUsuario;

        do {
            try {
                tipoUsuario = Integer.parseInt(JOptionPane.showInputDialog("""
                        Seleccione tipo de usuario:
                        1. Administrador
                        2. Cliente
                        """));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese una opción válida");
                tipoUsuario = -1;
            }
        } while (tipoUsuario != 1 && tipoUsuario != 2);

        boolean esAdmin = false;

        if (tipoUsuario == 1) {
            String clave = JOptionPane.showInputDialog("Ingrese clave de administrador:");

            if (clave.equals("1234")) {
                esAdmin = true;
            } else {
                JOptionPane.showMessageDialog(null, "Clave incorrecta. Entrando como cliente.");
            }
        }
        //Commit 4
        int opcion;

do {

    String menu = """
            --- MENU ---

            1. Hamburguesas
            2. Perros
            3. Perras
            4. Papas
            5. Adiciones
            6. Bebidas
            0. Finalizar
            """;

    try {

        opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));

    } catch (Exception e) {

        JOptionPane.showMessageDialog(null, "Debes ingresar un número válido");
        opcion = -1; // para que el ciclo continúe
        continue;
    }

    switch (opcion) {

        case 1, 2, 3, 4, 5, 6 -> {

            int categoria = opcion - 1;

            if (esAdmin == true) {

                int opcionAdmin;

                do {

                    try {

                        opcionAdmin = Integer.parseInt(
                                JOptionPane.showInputDialog("""
                                ADMIN:
                                1. Agregar producto
                                2. Continuar
                                """));

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(null, "Debes ingresar un número válido");
                        opcionAdmin = -1;
                        continue;
                    }

                    if (opcionAdmin != 1 && opcionAdmin != 2) {

                        JOptionPane.showMessageDialog(null, "Opción inválida");
                    }

                } while (opcionAdmin != 1 && opcionAdmin != 2);

                if (opcionAdmin == 1) {

                    String nuevo = JOptionPane.showInputDialog(
                            "Nombre del nuevo producto:");

                    int precioNuevo;

                    try {

                        precioNuevo = Integer.parseInt(
                                JOptionPane.showInputDialog("Precio:"));

                    } catch (Exception e) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Precio inválido"
                        );

                        break;
                    }

                    JOptionPane.showMessageDialog(
                            null,
                            "Producto agregado:\n" +
                            nuevo + " - $" + precioNuevo
                    );
                }
            }
        }

        case 0 -> JOptionPane.showMessageDialog(
                null,
                "Pedido finalizado"
        );

        default -> JOptionPane.showMessageDialog(
                null,
                "Opción inválida"
        );
    }

} while (opcion != 0);
        //Commit 5
        String subMenu = "Seleccione:\n";

                    for (int i = 0; i < nombres[categoria].length; i++) {
                        subMenu += (i + 1) + ". " + nombres[categoria][i] + " $" + precios[categoria][i] + "\n";
                    }
                    subMenu += "0. Volver al menú principal\n";

                    int opcionSub = -1;
                    do { 
                        try {
                        opcionSub = Integer.parseInt(JOptionPane.showInputDialog(subMenu));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                        continue;
                    }

                    if (opcionSub == 0) {
                        continue;
                    }

                    int eleccion = opcionSub -1;
                    if (eleccion >= 0 && eleccion < nombres[categoria].length) {

                        int cantidad;
                        try {
                            cantidad = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida");
                            continue;
                        }

                        if (cantidad > 0) {
                            cantidades[categoria][eleccion] += cantidad;
                        } else {
                            JOptionPane.showMessageDialog(null, "Cantidad inválida");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Opción inválida");
                    }
                    
                } while (opcionSub != 0);
                }

                case 0 -> JOptionPane.showMessageDialog(null, "Generando factura...");

                default -> JOptionPane.showMessageDialog(null, "Opción incorrecta");
            }

        } while (opcion != 0);
    }
}
