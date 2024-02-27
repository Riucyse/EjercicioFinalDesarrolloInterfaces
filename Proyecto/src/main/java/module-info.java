module riucyse.proyecto {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens riucyse.proyecto to javafx.fxml;
    exports riucyse.proyecto;
    opens riucyse.proyecto.clases;
    exports riucyse.proyecto.clases;
}