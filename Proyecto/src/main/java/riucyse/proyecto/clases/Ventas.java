package riucyse.proyecto.clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Es la clase que almacena todas las ventas del inventario y sus valores
 * @author Enric Gonzalez
 * @version 1.0
 */

public class Ventas {

    // Atributos
    private List<Dispositivo> ventas;


    // Metodos

    /**
     * Un instanciador de clase con un List de dispositivos vacio
     * @see Dispositivo
     */
    public Ventas(){
        ventas = new ArrayList<>();
    }

    /**
     * Un instanciador de clase con un List de dispositivos
     *
     * @see Dispositivo
     * @param nuevaListaDeDispositivos El List de dispositivos con el que se va a instanciar la clase
     */
    public Ventas(List<Dispositivo> nuevaListaDeDispositivos){
        ventas = nuevaListaDeDispositivos;
    }

    /**
     * Un metodo para añadir un nuevo dispositivo
     *
     * @see Dispositivo
     * @param nuevoDispositivo el nuevo dispositivo que se va a añadir a la List
     */
    public void altaDispositivo(Dispositivo nuevoDispositivo){
        ventas.add(nuevoDispositivo);
    }

    /**
     * Un metodo para eliminar un dispositivo de la List buscando por la ID del dispositivo
     *
     * @see Dispositivo
     * @param idDeDispositivo La ID del dispositivo que se va a eliminar de la List
     */
    public void bajaDispositivo(int idDeDispositivo){
        List<Dispositivo> aBorrar = ventas.stream().filter(Dispositivo -> Dispositivo.getIdentificador() == idDeDispositivo).collect(Collectors.toList());
        if(!(aBorrar.isEmpty())){
            Dispositivo borrar = aBorrar.get(0);
            ventas.remove(borrar);
        }
    }

    /**
     * Un metodo que indica si existe un dispositivo según su ID en la List de dispositivos, retorna verdadero o falso
     * según haya encontrado el Dispositivo o no
     *
     * @see Dispositivo
     * @param idDeDispositivo La ID del dispositivo a buscar
     * @return Retorna TRUE si hay un dispositivo con esa ID en la List, y FALSE si no
     */
    public boolean existeDispositivo(int idDeDispositivo){
        List<Dispositivo> aRevisar = ventas.stream().filter(Dispositivo -> Dispositivo.getIdentificador() == idDeDispositivo).collect(Collectors.toList());
        if(aRevisar.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Metodo para obtener la List de ventas del inventario
     *
     * @return Retorna un List de las ventas del inventario
     */
    public List<Dispositivo> getVentas() {
        return ventas;
    }

    /**
     * Metodo para poner una nueva List de ventas del inventario
     *
     * @param stock Una List para poner nuevas ventas del inventario
     */
    public void setVentas(List<Dispositivo> stock) {
        this.ventas = stock;
    }

    /**
     * Es un metodo para imprimir en un archivo .txt el inventario de ventas que se han producido
     * @see Dispositivo#toString()
     */
    public void imprimirTxt(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("VentasDispositivos.txt"))){
            StringBuilder str = new StringBuilder();
            str.append("Lista de objetos vendidos:\n");
            ventas.forEach(Dispositivo ->{
                str.append(Dispositivo.toString());
                str.append("\n");
            });
            bufferedWriter.write(str.toString());
        } catch(IOException e){
            System.out.println(e);
        }
    }
}
