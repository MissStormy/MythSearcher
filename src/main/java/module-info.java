module mythsearcher.mythsearcher {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
    requires java.sql;

    opens mythsearcher.mythsearcher to javafx.fxml;
    exports mythsearcher.mythsearcher;
}