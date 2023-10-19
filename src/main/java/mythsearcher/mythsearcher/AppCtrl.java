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
import java.util.ResourceBundle;

public class AppCtrl implements Initializable {
    //Este es el controlador de la pantalla principal, desde aqui salen las otras cuatro pantallas
    //Y cuenta con una TableView para poder ver los mitos desde el principio
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
    private TableView<Mytho> TbMythos;

    @FXML
    private TableColumn<?,?> TbcMythos1;

    @FXML
    private TableColumn<?,?> TbcMythos2;

    private MythosDAO mythosDAO;
    //Conexion con BBDD
    public AppCtrl(){
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
    //Inicializamos la TableView
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

    //Con este boton vamos a la pantalla add.fxml, en cuanto arranque la siguiente pantalla
    //La principal se cierra para no gastar recursos
    @FXML
    void OnClickAdd(ActionEvent event) throws IOException {
        //AppCtrl controller = new AppCtrl();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("add.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        //controller.cargarTabla();

        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        Stage stagePrincipal = (Stage) AddBtn.getScene().getWindow();
        stagePrincipal.close();
    }
    //Un boton simple para cerrar la ventana
    @FXML
    void OnClickClose(ActionEvent event) {
        Stage stage = (Stage) this.CloseBtn.getScene().getWindow();
        stage.close();
    }
    //Con este boton vamos a la pantalla erase.fxml
    @FXML
    void OnClickErase(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("erase.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        Stage stagePrincipal = (Stage) EraseBtn.getScene().getWindow();
        stagePrincipal.close();
    }
    //Con este boton vamos a la pantalla list.fxml
    @FXML
    void OnClickList(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("list.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        Stage stagePrincipal = (Stage) EraseBtn.getScene().getWindow();
        stagePrincipal.close();
    }
    //Con este vamos a la pantalla modify.fxml
    @FXML
    void OnClickMod(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("modify.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

        Stage stagePrincipal = (Stage) EraseBtn.getScene().getWindow();
        stagePrincipal.close();
    }


}