package mythsearcher.mythsearcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

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
    void OnClickAdd(ActionEvent event) {

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