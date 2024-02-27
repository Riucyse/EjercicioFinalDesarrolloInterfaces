package riucyse.proyecto;

import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import riucyse.proyecto.clases.Dispositivo;

import java.time.LocalDate;

public class VentanaController {

    public TableView<Dispositivo> tableDatos;
    public TableColumn columnaIdentificador;
    public TableColumn columnaFecha;
    public TableColumn columnaPrecio;
    public TableColumn columnaTipo;
    public TableColumn columnaMarca;
    public TableColumn columnaModelo;
    public TextField fieldIdentificador;
    public DatePicker dateFecha;
    public TextField fieldPrecio;
    public ComboBox comboBoxTipo;
    public TextField fieldMarca;
    public TextField fieldModelo;
    public Text textoError;
    public Button botonAnadir;
    public Button botonModificar;
    public Button botonImprimir;

    public void initialize(){
        columnaIdentificador.setCellFactory(new PropertyValueFactory<Dispositivo, String>("identificador"));
        columnaFecha.setCellFactory(new PropertyValueFactory<Dispositivo, LocalDate>("fechaCompra"));
        columnaPrecio.setCellFactory(new PropertyValueFactory<Dispositivo, Double>("precio"));
        columnaTipo.setCellFactory(new PropertyValueFactory<Dispositivo, String>("atributo"));
        columnaMarca.setCellFactory(new PropertyValueFactory<Dispositivo, String>("marca"));
        columnaModelo.setCellFactory(new PropertyValueFactory<Dispositivo, String>("modelo"));
        tableDatos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        textoError.setFill(Color.RED);
        textoError.setText("");
    }

    public void pulsarAnadir(){
        if(fieldIdentificador.getText().isEmpty()){
            textoError.setText("Falta el identificador por rellenar");
        }
    }

    public void pulsarModificar(){

    }

    public void pulsarImprimir(){

    }
}
