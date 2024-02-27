package riucyse.proyecto;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import riucyse.proyecto.clases.Dispositivo;
import riucyse.proyecto.clases.Ventas;

import java.time.LocalDate;

public class VentanaController {

    public TableView<Dispositivo> tableDatos;
    public TableColumn<Dispositivo, String> columnaIdentificador;
    public TableColumn<Dispositivo, LocalDate> columnaFecha;
    public TableColumn<Dispositivo, Double> columnaPrecio;
    public TableColumn<Dispositivo, String> columnaTipo;
    public TableColumn<Dispositivo, String> columnaMarca;
    public TableColumn<Dispositivo, String> columnaModelo;
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
    public Button botonQuitar;
    private Ventas ventas;
    private Dispositivo dispositivoSeleccionado;

    public void initialize(){
        columnaIdentificador.setCellValueFactory(new PropertyValueFactory<Dispositivo, String>("identificador"));
        columnaFecha.setCellValueFactory(new PropertyValueFactory<Dispositivo, LocalDate>("fechaCompra"));
        columnaPrecio.setCellValueFactory(new PropertyValueFactory<Dispositivo, Double>("precio"));
        columnaTipo.setCellValueFactory(new PropertyValueFactory<Dispositivo, String>("atributo"));
        columnaMarca.setCellValueFactory(new PropertyValueFactory<Dispositivo, String>("marca"));
        columnaModelo.setCellValueFactory(new PropertyValueFactory<Dispositivo, String>("modelo"));
        tableDatos.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        textoError.setFill(Color.RED);
        textoError.setText("");
        String[] elecciones = {"ORDENADOR", "PANTALLA", "IMPRESORA", "PROYECTOR", "PORTATIL", "ROUTER"};
        comboBoxTipo.getItems().addAll(elecciones);
        ventas = new Ventas();
        dateFecha.getEditor().setDisable(true);
        reiniciarDispositivoSeleccionado();
    }

    public void pulsarAnadir(){
        if(fieldIdentificador.getText().isEmpty()){
            textoError.setText("Falta el identificador por rellenar");
        } else if(fieldMarca.getText().isEmpty()){
            textoError.setText("Falta la marca por rellenar");
        } else if(fieldModelo.getText().isEmpty()){
            textoError.setText("Falta el modelo por rellenar");
        } else if(fieldModelo.getText().isEmpty()){
            textoError.setText("Falta el precio por rellenar");
        } else if(comboBoxTipo.getValue() == null){
            textoError.setText("Falta por seleccionar el tipo del objeto");
        } else if(dateFecha.getValue() == null){
            textoError.setText("Falta por seleecionar la fecha de venta");
        } else {
            try{
                String stringIdentificador = fieldIdentificador.getText();
                String stringPrecio = fieldPrecio.getText();
                int identificador = Integer.parseInt(stringIdentificador);
                double precio = Double.parseDouble(stringPrecio);
                LocalDate fecha = dateFecha.getValue();
                Ventas ventasTableDatos = new Ventas(tableDatos.getItems());
                if(ventasTableDatos.existeDispositivo(identificador)){
                    textoError.setText("Ya existe este identificador, pulsa modificar si quiere modificarlo");
                } else{
                    Dispositivo nuevoDispositivo = new Dispositivo(identificador, fecha, precio, comboBoxTipo.getValue().toString(),
                            fieldMarca.getText(), fieldModelo.getText());
                    tableDatos.getItems().add(nuevoDispositivo);
                    reiniciarDispositivoSeleccionado();
                }
            } catch (Exception e){
                textoError.setText("El identificador y precio deben ser campos numericos");
            }
        }
    }

    public void pulsarImprimir(){
        Ventas ventasAImprimir = new Ventas(tableDatos.getItems());
        ventasAImprimir.imprimirTxt();
    }

    public void pulsarElementoTable(MouseEvent mouseEvent) {
        dispositivoSeleccionado = tableDatos.getSelectionModel().getSelectedItem();
        if(dispositivoSeleccionado != null){
            fieldIdentificador.setText(String.valueOf(dispositivoSeleccionado.getIdentificador()));
            fieldMarca.setText(dispositivoSeleccionado.getMarca());
            fieldModelo.setText(dispositivoSeleccionado.getModelo());
            fieldPrecio.setText(String.valueOf(dispositivoSeleccionado.getPrecio()));
            comboBoxTipo.setValue(dispositivoSeleccionado.getAtributo());
            dateFecha.getEditor().setText(dispositivoSeleccionado.getFechaCompra().toString());
        }
    }

    public void pulsarQuitar(ActionEvent actionEvent) {
        if(dispositivoSeleccionado != null){
            ventas.bajaDispositivo(dispositivoSeleccionado.getIdentificador());
            tableDatos.getItems().remove(dispositivoSeleccionado);
            reiniciarDispositivoSeleccionado();
        }
    }


    public void cambiarIdentificador(KeyEvent actionEvent) {
        try{
            int nuevoIdentificador = Integer.parseInt(fieldIdentificador.getText());
            dispositivoSeleccionado.setIdentificador(nuevoIdentificador);
            tableDatos.refresh();
            textoError.setText("");
        } catch(Exception e){
            textoError.setText("El campo de identificador debe ser un numero natural");
        }
    }

    public void cambiarFecha(ActionEvent actionEvent) {
        dispositivoSeleccionado.setFechaCompra(dateFecha.getValue());
        tableDatos.refresh();
    }

    public void cambiarPrecio(KeyEvent actionEvent) {
        try{
            double nuevoPrecio = Double.parseDouble(fieldPrecio.getText());
            dispositivoSeleccionado.setPrecio(nuevoPrecio);
            tableDatos.refresh();
            textoError.setText("");
        } catch(Exception e){
            textoError.setText("El precio ha de ser un numero con posibilidad de decimales");
        }
    }

    public void cambiarTipo(ActionEvent actionEvent) {
        dispositivoSeleccionado.setAtributo(comboBoxTipo.getValue().toString());
        tableDatos.refresh();
    }

    public void cambiarMarca(KeyEvent actionEvent) {
        dispositivoSeleccionado.setMarca(fieldMarca.getText());
        tableDatos.refresh();
    }

    public void cambiarModelo(KeyEvent actionEvent) {
        dispositivoSeleccionado.setModelo(fieldModelo.getText());
        tableDatos.refresh();
    }

    private void reiniciarDispositivoSeleccionado(){
        dispositivoSeleccionado = new Dispositivo(0, null, 0, "", "", "");
        fieldIdentificador.setText("");
        fieldPrecio.setText("");
        fieldMarca.setText("");
        fieldModelo.setText("");
    }

    public void pulsarDeseleccionar(ActionEvent actionEvent) {
        reiniciarDispositivoSeleccionado();
    }
}
