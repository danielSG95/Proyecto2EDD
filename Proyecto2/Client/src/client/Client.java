/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import com.github.fxrouter.FXRouter;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author da9ni5el
 */
public class Client extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        FXRouter.bind(this, stage, "Iniciar Sesion", 404, 463);
        FXRouter.when("login", "FxmlClient.fxml");
        FXRouter.goTo("login");
        FXRouter.setAnimationType("fade", 1200);
        
                       
    }

    /**
     * @param args the command line arguments
     */
    
    
    
            
    public static void main(String[] args) {
        launch(args);
    }
    
}
