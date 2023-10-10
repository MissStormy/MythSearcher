package mythsearcher.mythsearcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class AppCtrl {
    @FXML
    private Button AddBtn;

    @FXML
    private Button CloseBtn;

    @FXML
    private Button EraseBtn;

    @FXML
    private Button ListBtn;

    @FXML
    private Button ModBtn;

    @FXML
    private ListView<?> MythosList;

    @FXML
    void OnClickAdd(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("add.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        Stage stagePrincipal = (Stage) AddBtn.getScene().getWindow();
        stagePrincipal.close();
    }

    @FXML
    void OnClickClose(ActionEvent event) {
        Stage stage = (Stage) this.CloseBtn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnClickErase(ActionEvent event) {

    }

    @FXML
    void OnClickList(ActionEvent event) {

    }

    @FXML
    void OnClickMod(ActionEvent event) {

    }
}