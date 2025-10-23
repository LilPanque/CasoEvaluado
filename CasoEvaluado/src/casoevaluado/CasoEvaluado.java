/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package casoevaluado;

/**
 *
 * @author Gamer
 */
import javax.swing.JOptionPane;

public class CasoEvaluado {
    public static void main(String[] args) {
        Vendedor vendedor = null;
        boolean salir = false;

        while (!salir) {
            String[] opciones = {"Agregar Vendedor", "Registrar Factura", "Salir"};
            int eleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una opción:",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            int contadorFacturas = 0; // Llevar un contador de facturas para verificar el bono extra del vendedor al finalizar
            switch (eleccion) {
                case 0:
                    // Solicitar los datos del vendedor
                    String nombre = JOptionPane.showInputDialog("Nombre del agente:");
                    String apellidos = JOptionPane.showInputDialog("Apellidos:");
                    String cedula = JOptionPane.showInputDialog("Cédula:");
                    String codigo = JOptionPane.showInputDialog("Código:");
                    String sucursal = JOptionPane.showInputDialog("Sucursal:");
                    boolean vehiculo = JOptionPane.showConfirmDialog(null, "¿Tiene vehículo propio?") == 0; // Si = 0, entonces compara con 0 para ver si es true o false

                    vendedor = new Vendedor(nombre, apellidos, cedula, codigo, sucursal, vehiculo); // Crear objeto
                    JOptionPane.showMessageDialog(null, "Vendedor agregado correctamente.");
                    break;

                case 1:
                    if (vendedor == null) {
                        JOptionPane.showMessageDialog(null, "Primero debe agregar un vendedor.");
                        break;
                    }
                    int mes = -1;
                    int seguir = 0;
                    while (seguir == 0) { // Ciclo que solicita las n facturas que desee ingresar
                        // Solicitar datos de la factura, 
                        String nombreC = JOptionPane.showInputDialog("Nombre del cliente:");
                        String cedulaC = JOptionPane.showInputDialog("Cédula del cliente:");
                        String codFactura = JOptionPane.showInputDialog("Código de factura:");
                        double monto = Double.parseDouble(JOptionPane.showInputDialog("Monto de factura:"));
                        do {
                            mes = Integer.parseInt(JOptionPane.showInputDialog("Número de mes (1-12):"));
                        } while (mes < 1 || mes > 12); // Verificar la validez del mes ingresado

                        int electr = Integer.parseInt(JOptionPane.showInputDialog("Cantidad productos eléctricos:"));
                        int auto = Integer.parseInt(JOptionPane.showInputDialog("Cantidad productos automotrices:"));
                        int cons = Integer.parseInt(JOptionPane.showInputDialog("Cantidad productos construcción:"));

                        Factura f = new Factura(nombreC, cedulaC, codFactura, monto, mes, electr, auto, cons); // Crear factura
                        f.calcularBono(); // Agregar el bono para que el vendedor pueda accederlo luego
                        vendedor.agregarFactura(f); // Agregar la factura a los datos del vendedor
                        contadorFacturas++;

                        seguir = JOptionPane.showConfirmDialog(null, "¿Desea ingresar otra factura?");
                    }

                    vendedor.calcularBonoExtra(contadorFacturas);
                    JOptionPane.showMessageDialog(null, vendedor.resumen(mes -1)); // Mostrar el resumen del vendedor
                    break;

                case 2:
                case JOptionPane.CLOSED_OPTION:
                    salir = true;
                    break;
            }
        }
    }
}

