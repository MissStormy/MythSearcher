package mythsearcher.mythsearcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddCtrl implements Initializable {
    @FXML
    private TextField Biotxt;

    @FXML
    private Button CancelBtn;

    @FXML
    private ComboBox<?> ClassCmb;

    @FXML
    private Button CleanBtn;

    @FXML
    private Button CloseBtn;

    @FXML
    private ComboBox<?> GenderCmb;

    @FXML
    private ListView<?> MythList;

    @FXML
    private TextField Nametxt;

    @FXML
    private TextField Origintxt;

    @FXML
    private Button SaveBtn;
    @FXML
    private Button VolverBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void OnClickCancel(ActionEvent event) {

    }

    @FXML
    void OnClickClean(ActionEvent event) {

    }

    @FXML
    void OnClickClose(ActionEvent event) {
        Stage stage = (Stage) this.CloseBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnClickSave(ActionEvent event) {

    }
    @FXML
    void OnClickVolver(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        Stage stagePrincipal = (Stage) VolverBtn.getScene().getWindow();
        stagePrincipal.close();
    }


}
