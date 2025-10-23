/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package casoevaluado;

/**
 *
 * @author Gamer
 */
public class Factura {

    private String nombreCliente;
    private String clienteID;
    private String codigoFactura;
    private double montoFactura;
    private int mes;
    private int electricos;
    private int automotrices;
    private int construccion;
    private double bono;
    private int puntos;

    // Constructor
    public Factura(String nombreCliente, String cleinteID, String codFactura,
            double montoFactura, int mes, int electricos, int automotrices, int construccion) {
        this.nombreCliente = nombreCliente;
        this.clienteID = clienteID;
        this.codigoFactura = codFactura;
        this.montoFactura = montoFactura;
        this.mes = mes;
        this.electricos = electricos;
        this.automotrices = automotrices;
        this.construccion = construccion;
        this.bono = 0;
        this.puntos = 0;
    }

    // Función para calcular el bono obtenido en la factura
    public void calcularBono() {
        if (electricos > 0 && automotrices > 0 && construccion > 0) { // Vendió los tres tipos de productos
            bono = montoFactura * 0.10;
            puntos += 3;

        } else {
            if (electricos >= 3) { // Vendió tres o más pd. eléctricos
                bono += montoFactura * 0.04;
            } else {
                bono += montoFactura * 0.02; // Sumar el 2% al bono si no
            }
            puntos += 1;

            if (automotrices > 4) { // Vendió más de 4 productos automotrices
                bono += montoFactura * 0.04;
            } else {
                bono += montoFactura * 0.02;
            }
            puntos += 1;

            if (construccion > 0) {
                bono += montoFactura * 0.08;
                puntos += 2;
            }
        }
        revisarMonto(); // Verificar si el monto de la factura es > 50000
    }

    private void revisarMonto() {
        if (montoFactura > 50000) {  // Si el monto de la factura es mayor a 50000, agrega el 5% al bono
            bono += montoFactura * 0.05;
            puntos += 1;
        }
    }

    // Getters
    public double getMontoFactura() {
        return montoFactura;
    }

    public double getBono() {
        return bono;
    }

    public int getPuntos() {
        return puntos;
    }
}
