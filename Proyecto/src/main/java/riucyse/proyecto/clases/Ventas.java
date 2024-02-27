package riucyse.proyecto.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ventas {

    // Atributos
    private List<Dispositivo> ventas;


    // Metodos
    public Ventas(){
        ventas = new ArrayList<>();
    }

    public Ventas(List<Dispositivo> nuevaListaDeDispositivos){
        ventas = nuevaListaDeDispositivos;
    }

    public void altaDispositivo(Dispositivo nuevoDispositivo){
        ventas.add(nuevoDispositivo);
    }

    public void bajaDispositivo(int idDeDispositivo){
        List<Dispositivo> aBorrar = ventas.stream().filter(Dispositivo -> Dispositivo.getIdentificador() == idDeDispositivo).collect(Collectors.toList());
        if(!(aBorrar.isEmpty())){
            Dispositivo borrar = aBorrar.get(0);
            ventas.remove(borrar);
        }
    }

    public List<Dispositivo> getVentas() {
        return ventas;
    }

    public void setVentas(List<Dispositivo> stock) {
        this.ventas = stock;
    }
}
