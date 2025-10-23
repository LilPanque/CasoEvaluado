/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoevaluado;

/**
 *
 * @author Gamer
 */
public class Vendedor {
    private String nombre;
    private String apellidos;
    private String cedula;
    private String codigo;
    private String sucursal;
    private boolean tieneVehiculo;
    private double totalFacturado;
    private double bono;
    private int puntos;

    // Constructor
    public Vendedor(String nombre, String apellidos, String cedula, String codigo,
                    String sucursal, boolean tieneVehiculo) {
        this.nombre = nombre+apellidos;
        this.cedula = cedula;
        this.codigo = codigo;
        this.sucursal = sucursal;
        this.tieneVehiculo = tieneVehiculo;
    }

    // Agregar los datos de la nueva factura al vendedor
    public void agregarFactura(Factura f) {
        totalFacturado += f.getMontoFactura();
        bono += f.getBono();
        puntos += f.getPuntos();
    }

    // Verificar si el vendedor hizo más de tres ventas o si vendió más de 300000
    public void calcularBonoExtra(int cantidadFacturas) {
        if (cantidadFacturas > 3 || totalFacturado > 300000) {
            bono += 20000;
        }
    }

    // Mostrar los datos obtenidos por el vendedor
    public String resumen(int mes) {
        String mesNombre = obtenerMes(mes);
        String veh = tieneVehiculo ? "Sí" : "No";

        return "El Agente Vendedor " + nombre + " código: " 
            + codigo + " en el mes de " + mesNombre + "\n" +
            "Vendió un total de " + totalFacturado + " en facturas\n" +
            "Obtuvo un total en comisiones de " + bono + "\n" +
            "Puntos obtenidos por el vendedor: " + puntos + "\n" +
            "El Agente Vendedor " + veh + " cuenta con vehículo propio\n" +
            "Sucursal: " + sucursal + "\n";
    }
    
    // Convertir el mes de int a string
    private String obtenerMes(int mes) {  // el valor de mes se pasa desde el main usando (mes -1), donde "mes" es la entrada del usuario
        String[] nombres = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        if (mes >= 0 && mes <= 11)
            return nombres[mes];
        else
            return "Mes inválido";
    }
}

