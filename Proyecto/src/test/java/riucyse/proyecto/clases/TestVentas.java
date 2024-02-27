package riucyse.proyecto.clases;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.*;

class TestVentas {

    @Test
    public void testCamposCorrectos(){
        Dispositivo d1 = new Dispositivo(001, LocalDate.now(), 10.99, Dispositivo.SelectorAtributo.PORTATIL,
                "Marca", "Modelo");
        Dispositivo d2 = new Dispositivo(002, LocalDate.now(), 11.99, Dispositivo.SelectorAtributo.IMPRESORA,
                "Marca", "Modelo");
        Dispositivo d3 = new Dispositivo(003, LocalDate.now(), 12.99, Dispositivo.SelectorAtributo.PANTALLA,
                "Marca", "Modelo");
        List<Dispositivo> dispositivos = new ArrayList<>();
        dispositivos.add(d1);
        dispositivos.add(d2);
        dispositivos.add(d3);
        Ventas v = new Ventas(dispositivos);
        v.bajaDispositivo(002);
        List<Dispositivo> nuevaListaDispositivos = new ArrayList<>(v.getVentas());
        AtomicReference<Integer> a = new AtomicReference<>(0);
        nuevaListaDispositivos.forEach(Dispositivo ->{
            a.updateAndGet(v1 -> v1 + Dispositivo.getIdentificador());
        });

        assertEquals(4, a.get());
    }
}