package mythsearcher.mythsearcher;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mythsearcher.mythsearcher.domain.Mytho;
import mythsearcher.mythsearcher.utils.AlertTemp;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class EraseCtrl implements Initializable {
    @FXML
    private Button CloseBtn;

    @FXML
    private Button EraseBtn;

    @FXML
    private Button VolverBtn;
    @FXML
    private TableView<Mytho> TbMythos;

    @FXML
    private TableColumn<?,?> TbcMythos1;

    @FXML
    private TableColumn<?,?> TbcMythos2;
    private MythosDAO mythosDAO;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.TbcMythos1.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.TbcMythos2.setCellValueFactory(new PropertyValueFactory("tipo"));

        List<Mytho> mythos = null;
        try {
            mythos = mythosDAO.obtenerMythos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<Mytho> listaMythos = FXCollections.observableArrayList(mythos);
        TbMythos.setItems(listaMythos);
    }
    @FXML
    void OnClickClose(ActionEvent event) {
        Stage stage = (Stage) this.CloseBtn.getScene().getWindow();
        stage.close();
    }

    public EraseCtrl(){
        mythosDAO = new MythosDAO();

        try {
            mythosDAO.conectar();
        } catch (SQLException sqle) {
            AlertTemp.mostrarError("Error al conectar con la base de datos");
        } catch (ClassNotFoundException cnfe) {
            AlertTemp.mostrarError("Error al iniciar la aplicación");
        } catch (IOException ioe) {
            AlertTemp.mostrarError("Error al cargar la configuración");
        }

        System.out.println(System.getProperty("user.home"));
    }
    @FXML
    void OnClickErase(ActionEvent event) {
        Mytho mytho = TbMythos.getSelectionModel().getSelectedItem();
        if(mytho == null){
            AlertTemp.mostrarWarning("No has elegido nada");
            return;
        }

        try{
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Eliminar mytho");
            confirmacion.setContentText("¿Estas seguro?");
            Optional<ButtonType> respuesta = confirmacion.showAndWait();
            if(respuesta.get().getButtonData() == ButtonBar.ButtonData.CANCEL_CLOSE){
                return;
            }
            mythosDAO.eliminarMytho(mytho);
            reloadTable();

        }catch (SQLException sqle){
            AlertTemp.mostrarError("Error al borrar el mytho");
        }
    }
    public void reloadTable(){
        List<Mytho> mythos = null;
        try {
            mythos = mythosDAO.obtenerMythos();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ObservableList<Mytho> listaMythos = FXCollections.observableArrayList(mythos);
        TbMythos.setItems(listaMythos);
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
