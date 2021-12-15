/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.AdminMain;

import client.conexionServer.adminServer;
import com.github.fxrouter.FXRouter;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.server.servicio.Producto;
import com.server.servicio.Usuario;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author da9ni5el
 */
public class AdminMainController implements Initializable {
    private int typeReport;
    
    
    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXTextArea txtDireccion;

    @FXML
    private JFXTextField txtBuscarUsuario;

    @FXML
    private Pane busquedaContenedor;

    @FXML
    private JFXTextField txtUsernameBusqueda;

    @FXML
    private JFXPasswordField txtPasswordBusqueda;

    @FXML
    private JFXComboBox<String> showSampleAdminReports;


    @FXML
    private MenuItem archivoUsuario;

    @FXML
    private MenuItem archivoDireccion;

    @FXML
    private MenuItem archivoCompra;

    @FXML
    private MenuItem archivoCarrito;

    @FXML
    private MenuItem archivoProducto;

    @FXML
    private MenuItem archivoVenta;

    @FXML
    private MenuItem archivoDetalle;
    @FXML
    private JFXTextField txtidproducto;
    @FXML
    private JFXTextField txtnombreproducto;
    @FXML
    private JFXTextField txtmarcaproducto;
    @FXML
    private JFXTextField txtprecioproducto;
    @FXML
    private JFXTextField txturlimage;
    @FXML
    private JFXTextField txtbuscarproducto;
    @FXML
    private Pane contenedorBusquedaP;
    @FXML
    private JFXTextField txtbusquedaproducto;
    @FXML
    private JFXTextField txtbusquedamarcaproducto;
    @FXML
    private JFXTextField txtbusquedaprecioproducto;
    @FXML
    private JFXTextField txtbusquedaimagenproducto;
    @FXML
    private JFXComboBox<String> comboboxporbusqueda;
    @FXML
    private JFXTextField txtReporteBusqueda;

    @FXML
    void buscarUsuario(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            System.out.println("Enter pressed");
            Usuario userFind = new adminServer().buscarUsuarioController(txtBuscarUsuario.getText());
            if (userFind != null) {
                /*Se carga la informacion a los controles necesarios*/
                busquedaContenedor.setVisible(true);
                txtUsernameBusqueda.setText(userFind.getNickname());
                txtPasswordBusqueda.setText(userFind.getPassword());
                txtUsernameBusqueda.setEditable(false);
                txtBuscarUsuario.clear();
            }
        }
    }

    @FXML
    void cancelarInsert(ActionEvent event) {
        txtUsername.setText("");
        txtPassword.setText("");
        txtDireccion.setText("");
    }

    //Pendiente de procesar
    @FXML
    void cargarArchivo(ActionEvent event) {
        MenuItem pressed = (MenuItem) event.getSource();
        File temporal = seleccionarArchivo();
        adminServer adminFiles = new adminServer();
        String salida = "";
        switch (pressed.getId()) {
            case "archivoUsuario":
                System.out.println("Archivo usuario");
                salida = adminFiles.cargarArchivo(temporal, 0);
                System.out.println(salida);
                break;
            case "archivoDireccion":
                System.out.println("Archivo Direccion");
                salida = adminFiles.cargarArchivo(temporal, 1);
                System.out.println(salida);
                break;
            case "archivoCompra":
                System.out.println("Archivo Compra");
                salida = adminFiles.cargarArchivo(temporal, 2);
                System.out.println(salida);
                break;
            case "archivoCarrito":
                System.out.println("Archivo Carrito");
                salida = adminFiles.cargarArchivo(temporal, 3);
                System.out.println(salida);
                break;
            case "archivoProducto":
                System.out.println("Archivo Producto");
                salida = adminFiles.cargarArchivo(temporal, 4);
                System.out.println(salida);
                break;
            case "archivoVenta":
                System.out.println("Archivo Venta");
                salida = adminFiles.cargarArchivo(temporal, 5);
                System.out.println(salida);
                break;
            case "archivoDetalle":
                System.out.println("Archivo Detalle");
                salida = adminFiles.cargarArchivo(temporal, 6);
                System.out.println(salida);
                break;
        }
    }

    @FXML
    void cerrarSesionAdmin(ActionEvent event) throws IOException {
        FXRouter.bind(this, (Stage) busquedaContenedor.getScene().getWindow(), "Iniciar Sesion", 404, 463);
        FXRouter.when("login", "FxmlClient.fxml");
        FXRouter.goTo("login");
    }

    @FXML
    void editarUsuario(ActionEvent event) {
        boolean salida = new adminServer().modificarUsuarioController(txtUsernameBusqueda.getText(), txtPasswordBusqueda.getText());
        if(salida) {
            //todo bien
            System.out.println("Usuario editado correctamente");
//            busquedaContenedor.setVisible(false);
        }else {
            //todo mal
            System.out.println("Ha ocurrido un error");
        }
    }

    @FXML
    void eliminarUsuario(ActionEvent event) {
        if(txtUsernameBusqueda.getText() != null) {
            boolean salida = new adminServer().eliminarUsuarioController(txtUsernameBusqueda.getText());
            if(salida){
                //todo bien
                System.out.println("Usuario eliminado");
                txtUsernameBusqueda.clear();
                txtPasswordBusqueda.clear();
                busquedaContenedor.setVisible(false);
            }else {
                //todo mal
                System.out.println("Ha ocurrido un error");
            }
        }        
    }
        
    @FXML
    void exitApplication(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void ingresarUsuario(ActionEvent event) {
        if (txtUsername.getText() != null && txtPassword.getText() != null) {
            boolean salida = new adminServer().crearUsuarioController(txtUsername.getText(), txtPassword.getText(), txtDireccion.getText());
            if (salida) {
                //Todo bien
                txtUsername.clear();
                txtPassword.clear();
                txtDireccion.clear();
            } else {
                //Algo salio mal
                txtUsername.clear();
                txtPassword.clear();
                txtDireccion.clear();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showSampleAdminReports.getItems().add("Reporte Usuarios");
        showSampleAdminReports.getItems().add("Reporte Productos");
        showSampleAdminReports.getItems().add("Reporte Ventas");        
        showSampleAdminReports.getItems().add("Reporte Del Sistema");
        showSampleAdminReports.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (newValue != null) {
                    switch (newValue) {
                        case "Reporte Usuarios":
                            new adminServer().generarReporteUsuariosController();
                            System.out.println("usuarios");
                            break;
                        case "Reporte Ventas":  
                            new adminServer().generarReporteVentasController();
                            System.out.println("Ventas");
                            break;
                        case "Reporte Productos":
                            new adminServer().generarReporteProductosController();
                            break;
                        case "Reporte Del Sistema":
                            new adminServer().generarReporteGeneralController();
                            System.out.println("Sistema");
                            break;
                    }                        
                }
            }

        });
        
        
        comboboxporbusqueda.getItems().add("Busqueda por fecha");
        comboboxporbusqueda.getItems().add("Busqueda por Usuario");
        comboboxporbusqueda.getItems().add("Busqueda por Total");
        comboboxporbusqueda.getItems().add("Busqueda por Rango Fecha");
        comboboxporbusqueda.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue != null) {
                    switch (newValue) {
                        case "Busqueda por fecha":
                            typeReport = 0;
                            break;
                        case "Busqueda por Usuario":
                            typeReport = 1;
                            break;
                        case "Busqueda por Total":
                            typeReport = 2;
                            break;
                        case "Busqueda por Rango Fecha" :
                            typeReport = 3;
                            break;
                    }
                    
                    
                }
            }
        });
    }
    
    private File seleccionarArchivo() {
        FileChooser jfc = new FileChooser();
        jfc.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Cargar Archivos CSV", "*.csv")            
            );
        
        File returnVal = jfc.showOpenDialog(busquedaContenedor.getScene().getWindow());
        return returnVal;
    }

    @FXML
    private void cancelarProducto(ActionEvent event) {
        cancelarProducto();                
    }

    @FXML
    private void insertarProducto(ActionEvent event) {
        String id = txtidproducto.getText();
        String nobmroe = txtnombreproducto.getText();
        String marca = txtmarcaproducto.getText();
        String precio = txtprecioproducto.getText();
        String img = txturlimage.getText();
        
        
        boolean salida = new adminServer().insertarProductoController(id, nobmroe, marca, precio, img);
        if(salida) {
            System.out.println("Se inserto correctamente");
            cancelarProducto();
        }else {
            System.out.println("No se inserto");
        }
    }

    @FXML
    private void buscarProducto(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {            
            Producto p = new adminServer().buscarProductoController(txtbuscarproducto.getText());
            if (p != null) {
                System.out.println("Producto encontrado");
                txtbusquedaproducto.setText(p.getNombre());
                txtbusquedamarcaproducto.setText(p.getMarca());
                txtbusquedaprecioproducto.setText(String.valueOf(p.getPrecio()));
                txtbusquedaimagenproducto.setText(p.getPathImagen());
                contenedorBusquedaP.setVisible(true);
            }else {
                System.out.println("No se encontro el producto");
            }
        }
    }

    @FXML
    private void elimnarProducto(ActionEvent event) {
        boolean salida = new adminServer().eliminarProductoController(txtbuscarproducto.getText());
        if(salida) {
            System.out.println("Eliminado");
            contenedorBusquedaP.setVisible(false);
            txtbuscarproducto.setText("");
        } else {
            System.out.println("Error!");
        }
    }

    @FXML
    private void modificarProducto(ActionEvent event) {        
        String id = txtbuscarproducto.getText();
        String nobmroe = txtbusquedaproducto.getText();
        String marca = txtbusquedamarcaproducto.getText();
        String precio = txtbusquedaprecioproducto.getText();
        String img = txtbusquedaimagenproducto.getText();
        
        
        boolean salida = new adminServer().modificarProductoController(id, nobmroe, marca, precio, img);
        if(salida) {
            System.out.println("Se modifico correctamente");
        }else {
            System.out.println("No se Modifico");
        }
        
    }
    
    
    private void cancelarProducto() {
        txtidproducto.clear();
        txtnombreproducto.clear();
        txtmarcaproducto.clear();
        txtprecioproducto.clear();
        txturlimage.clear();        
    }

    @FXML
    private void reporteBuscar(ActionEvent event) {
        System.out.println("Se tiene seleccionado el item:" + typeReport);
        switch(typeReport) {
            case 0:
                new adminServer().generarReporteBusquedaFechaController(txtReporteBusqueda.getText());
                break;
            case 1:
                new adminServer().generarReporteBusquedaNicknameController(txtReporteBusqueda.getText());
                break;
            case 2:
                double cantidad = Double.parseDouble(txtReporteBusqueda.getText());
                new adminServer().generarReporteBusquedaCantidadController(cantidad);
                break;
            case 3:                
                new adminServer().generarReportePorRangoFecha(txtReporteBusqueda.getText());
                break;
        }
    }
}
