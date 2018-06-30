

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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author User
 */
public class forgetloginController implements Initializable {

    @FXML
    private Label label;
    
    @FXML
    private void handleButtonActionBack (ActionEvent event) throws IOException {

        Parent scene2parent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
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
