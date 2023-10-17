module mythsearcher.mythsearcher {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
    requires java.sql;

    opens mythsearcher.mythsearcher to javafx.fxml;
    opens mythsearcher.mythsearcher.domain to javafx.base;
    exports mythsearcher.mythsearcher;
}