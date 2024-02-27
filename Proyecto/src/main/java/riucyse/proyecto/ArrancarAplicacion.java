package riucyse.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Es la clase que arranca la ventana principal de la aplicacion
 * @author Enric Gonzalez
 * @version 1.0
 */
public class ArrancarAplicacion extends Application {

    /**
     * Metodo para crear la stage principal, indicando tamaños, titulo y ventana a abrir
     * @param stage Obtiene la stage actual
     * @throws IOException Si no encuentra el fxml que abrir saltara
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ArrancarAplicacion.class.getResource("Ventana.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Ventas");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Arranca la ventana principal de la aplicacion
     * @param args Ningúno
     */
    public static void main(String[] args) {
        launch();
    }
}