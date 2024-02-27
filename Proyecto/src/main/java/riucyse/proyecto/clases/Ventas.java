package riucyse.proyecto.clases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

    public boolean existeDispositivo(int idDeDispositivo){
        List<Dispositivo> aRevisar = ventas.stream().filter(Dispositivo -> Dispositivo.getIdentificador() == idDeDispositivo).collect(Collectors.toList());
        if(aRevisar.isEmpty()){
            return false;
        } else {
            return true;
        }
    }

    public List<Dispositivo> getVentas() {
        return ventas;
    }

    public void setVentas(List<Dispositivo> stock) {
        this.ventas = stock;
    }

    public void imprimirTxt(){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("VentasDispositivos"))){
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
