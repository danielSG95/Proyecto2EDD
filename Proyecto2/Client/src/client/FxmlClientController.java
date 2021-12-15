/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.github.fxrouter.FXRouter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import client.conexionServer.adminServer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author da9ni5el
 */
public class FxmlClientController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private JFXTextField txtUsername;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private JFXButton btnAceptarLogin;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private Hyperlink hyperlinkRegister;

    @FXML
    void Login(ActionEvent event) {
        //enviar la solicitud al servidor                
        try {
            loginUser();
        } catch (IOException ex) {
            Logger.getLogger(FxmlClientController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void cleanAction(ActionEvent event) {
        //limpiar controles
        txtUsername.clear();
        txtPassword.clear();
    }

    @FXML
    void registerAction(ActionEvent event) throws IOException {
        //llamar a la vista de registro

        FXRouter.bind(this, (Stage) anchorPane.getScene().getWindow(), "Registro", 405, 459);
        FXRouter.when("registro", "Register/Registro.fxml");
        FXRouter.goTo("registro");
//        FXRouter.setAnimationType("fadeIn", 800);
    }

    @FXML
    void LoginKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            try {
                loginUser();
            } catch (IOException ex) {
                Logger.getLogger(FxmlClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void loginUser() throws IOException {
        int log = new adminServer().loginController(txtUsername.getText(), txtPassword.getText());
        switch (log) {
            case 1:
                System.out.println("Login Admin");
                FXRouter.bind(this, (Stage) anchorPane.getScene().getWindow(), "Administrador", 900, 650);
                FXRouter.when("admin", "AdminMain/AdminMain.fxml");
                FXRouter.goTo("admin");
                FXRouter.setAnimationType("fade", 800);
                break;
            case 0:
                System.out.println("User Login");
                FXRouter.bind(this, (Stage) anchorPane.getScene().getWindow(), "Usuario", 950, 650);
                FXRouter.when("user", "UsuarioFinal/Usuario.fxml");
                FXRouter.goTo("user", txtUsername.getText());
                FXRouter.setAnimationType("fade", 800);                
                break;
            default:
                /*Las credenciales no coinciden*/
                txtUsername.getStyleClass().add("wrong-credentials");
                txtPassword.getStyleClass().add("wrong-credentials");
                break;
        }
    }

}
