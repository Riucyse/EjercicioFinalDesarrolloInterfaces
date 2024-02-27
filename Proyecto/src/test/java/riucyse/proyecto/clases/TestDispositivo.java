package riucyse.proyecto.clases;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class TestDispositivo {

    @Test
    public void testCamposCorrectos(){
        LocalDate ld = LocalDate.now();
        Dispositivo d = new Dispositivo(001, ld, 10.99, Dispositivo.SelectorAtributo.PORTATIL,
                "Marca", "Modelo");
        assertEquals(001, d.getIdentificador());
        assertEquals(10.99, d.getPrecio());
        assertEquals("PORTATIL", d.getAtributo());
        assertEquals("Marca", d.getMarca());
        assertEquals("Modelo", d.getModelo());
    }
}