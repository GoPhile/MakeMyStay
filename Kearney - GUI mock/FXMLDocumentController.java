

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class FXMLDocumentController implements Initializable {

    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {

        Parent scene2parent = FXMLLoader.load(getClass().getResource("forgetlogin.fxml"));
        Scene Scene2scene = new Scene(scene2parent);
        Stage app_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Scene2scene);
        app_stage.show();
        
    }
    
        public void handleButtonAction2(ActionEvent event) throws IOException {

        Parent scene2parent = FXMLLoader.load(getClass().getResource("CustomerRegistration.fxml"));
        Scene Scene2scene = new Scene(scene2parent);
        Stage app_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Scene2scene);
        app_stage.show();
        
    }
        
        public void handleButtonAction3 (ActionEvent event) throws IOException {

        Parent scene2parent = FXMLLoader.load(getClass().getResource("PropertyOwnerRegistration.fxml"));
        Scene Scene2scene = new Scene(scene2parent);
        Stage app_stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(Scene2scene);
        app_stage.show();
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
