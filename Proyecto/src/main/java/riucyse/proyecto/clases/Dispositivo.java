package riucyse.proyecto.clases;

import java.time.LocalDate;
import java.util.Date;

public class Dispositivo {

    // Atributos
    public enum SelectorAtributo {ORDENADOR, PANTALLA, IMPRESORA, PROYECTOR, PORTATIL, ROUTER};
    private int identificador;
    private LocalDate fechaCompra;
    private double precio;
    private String atributo;
    private String marca;
    private String modelo;


    // Metodos
    public Dispositivo(int nuevoIdentificador, LocalDate nuevaFechaDeCompra, double nuevoPrecio, SelectorAtributo nuevoSelectorAtributo,
                       String nuevaMarca, String nuevoModelo){
        this.identificador = nuevoIdentificador;
        this.fechaCompra = nuevaFechaDeCompra;
        this.precio = nuevoPrecio;
        this.atributo = nuevoSelectorAtributo.toString();
        this.marca = nuevaMarca;
        this.modelo = nuevoModelo;
    }

    public Dispositivo(int nuevoIdentificador, LocalDate nuevaFechaDeCompra, double nuevoPrecio, String nuevoSelectorAtributo,
                       String nuevaMarca, String nuevoModelo){
        this.identificador = nuevoIdentificador;
        this.fechaCompra = nuevaFechaDeCompra;
        this.precio = nuevoPrecio;
        this.atributo = nuevoSelectorAtributo;
        this.marca = nuevaMarca;
        this.modelo = nuevoModelo;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAtributo() {
        return atributo;
    }

    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    public String toString(){
        return this.atributo + " modelo " + this.modelo + " de la marca " + this.marca + " con precio " + this.precio +
                " y con fecha de compra " + this.fechaCompra;
    }
}
