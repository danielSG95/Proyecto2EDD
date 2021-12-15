/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.UsuarioFinal;

import com.github.fxrouter.FXRouter;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author da9ni5el
 */
public class UsuarioController implements Initializable {
    
    private Catalogo c = new Catalogo();  
    private String numeroFactura = "";
    private String username;
    @FXML
    private StackPane container;
    @FXML
    private JFXComboBox<String> selectFactura;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        username = (String)FXRouter.getData();
        String facturas = c.listaFacturasController(username);
        if(!facturas.isEmpty()) {
            String facturasA[] = facturas.split("\n");
            
            for(int i = 0; i < facturasA.length; i++) {
                if(facturasA[i] != null) {
                    selectFactura.getItems().add(facturasA[i]);                 
                }
            }
            
            selectFactura.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    numeroFactura = newValue;
                }
            });
            
        }            
    }
        
    @FXML
    private void cerrarSesion(ActionEvent event) throws IOException {
        FXRouter.bind(this, (Stage) container.getScene().getWindow(), "Iniciar Sesion", 404, 463);
        FXRouter.when("login", "FxmlClient.fxml");
        FXRouter.goTo("login");
    }

    @FXML
    private void exitApp(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void reporteDeseos(ActionEvent event) {
        c.generarReporteDeseos(username);
    }

    @FXML
    private void imprimirFactura(ActionEvent event) {
        c.generarFacturaController(username, numeroFactura);
    }

    @FXML
    private void reporteCarrito(ActionEvent event) {
        c.generarReporteCarritoController(username);
    }

}
