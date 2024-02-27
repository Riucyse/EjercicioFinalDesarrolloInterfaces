package riucyse.proyecto.clases;

import java.time.LocalDate;
import java.util.Date;


/**
 * Es la clase de un dispositivo unico
 * @author Enric Gonzalez
 * @version 1.0
 */
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

    /**
     * Instanciador de la clase, a la cual hay que darle un nuevo identificador, una fecha de compra, un precio, se
     * selecciona un atributo del selector de atributos, una marca y modelo
     *
     * @param nuevoIdentificador Nuevo identificador del producto. Ha de ser unico entre diferentes productos
     * @param nuevaFechaDeCompra Fecha en la que se compro el producto
     * @param nuevoPrecio Precio del producto
     * @param nuevoSelectorAtributo Que tipo de producto es, seleccionado en selector de productos
     * @param nuevaMarca La marca del producto
     * @param nuevoModelo El modelo del producto
     */
    public Dispositivo(int nuevoIdentificador, LocalDate nuevaFechaDeCompra, double nuevoPrecio, SelectorAtributo nuevoSelectorAtributo,
                       String nuevaMarca, String nuevoModelo){
        this.identificador = nuevoIdentificador;
        this.fechaCompra = nuevaFechaDeCompra;
        this.precio = nuevoPrecio;
        this.atributo = nuevoSelectorAtributo.toString();
        this.marca = nuevaMarca;
        this.modelo = nuevoModelo;
    }

    /**
     * Instanciador de la clase, usado dentro del codigo del controlador del programa. En vez de seleccionar el tipo de
     * producto del ENUM, lo recibe como parametro en forma de String
     *
     * @param nuevoIdentificador Nuevo identificador del producto. Ha de ser unico entre diferentes productos
     * @param nuevaFechaDeCompra Fecha en la que se compro el producto
     * @param nuevoPrecio Precio del producto
     * @param nuevoSelectorAtributo String que dice que tipo de producto es
     * @param nuevaMarca La marca del producto
     * @param nuevoModelo El modelo del producto
     */
    public Dispositivo(int nuevoIdentificador, LocalDate nuevaFechaDeCompra, double nuevoPrecio, String nuevoSelectorAtributo,
                       String nuevaMarca, String nuevoModelo){
        this.identificador = nuevoIdentificador;
        this.fechaCompra = nuevaFechaDeCompra;
        this.precio = nuevoPrecio;
        this.atributo = nuevoSelectorAtributo;
        this.marca = nuevaMarca;
        this.modelo = nuevoModelo;
    }

    /**
     * Metodo para obtener el identificador
     * @return Un int del identificador del dispositivo
     */
    public int getIdentificador() {
        return identificador;
    }

    /**
     * Metodo para cambiar el identificador del dispositivo
     * @param identificador Un int el cual indicara cual sera el nuevo identificador del dispositivo
     */
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    /**
     * Metodo para obtener la fehca de compra
     * @return Un LocalDate de la fecha en la que se compro el dispositivo
     */
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Metodo para cambiar la fecha de compra del dispositivo
     * @param fechaCompra Un LocalDate con la nueva fecha de compra del dispositivo
     */
    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Metodo para obtener el precio del dispositivo
     * @return Un double con el valor del dispositivo
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * Metodo para cambiar el precio al dispositivo
     * @param precio Un double indicando cual es el nuevo precio del dispositivo
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    /**
     * Metodo para obtener la marca del dispositivo
     * @return Un String con el nombre de la marca del dispositivo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Metodo para cambiar la marca del dispositivo
     * @param marca Un String con el nuevo nombre de la marca del dispositivo
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Metodo para cambiar el modelo del dispositivo
     * @return Un String con nombre del modelo del dispositivo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Metodo para cambiar el modelo del dispositivo
     * @param modelo Un String con el nuevo modelo del dispositivo
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Metodo para obtener el tipo de dispositivo que es el dispositivo
     * @return Un String indicando que tipo de dispositivo es
     */
    public String getAtributo() {
        return atributo;
    }

    /**
     * Metodo para cambiar el tipo de dispositivo que es
     * @param atributo Un String indicando el nuevo tipo de dispositivo que es
     */
    public void setAtributo(String atributo) {
        this.atributo = atributo;
    }

    /**
     * Metodo toString, escrito pensando en que quede claro para el metodo de escribir el .txt en Ventas
     * @see Ventas
     * @return Un String con la informacion del dispositivo
     */
    public String toString(){
        return this.atributo + " modelo " + this.modelo + " de la marca " + this.marca + " con precio " + this.precio +
                " y con fecha de compra " + this.fechaCompra;
    }
}
