package mythsearcher.mythsearcher;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import mythsearcher.mythsearcher.utils.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class App extends Application {

    @Override
    public void init() throws Exception {
        super.init();
    }
    @Override
    public void start(Stage stage) throws IOException {
        AppCtrl controller = new AppCtrl();

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        //Con esto se deberian cargar los datos de la BBDD,
        //pero dice que es NULL
        fxmlLoader.setController(controller);
        System.out.println("Beep");
        //controller.cargarDatos();
        System.out.println("Beep");


        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void stop() throws Exception {
        super.stop();
    }

    public static void main(String[] args) {


        launch();
    }
}