package mythsearcher.mythsearcher;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCtrl {
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
}
