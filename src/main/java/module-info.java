module mythsearcher.mythsearcher {
    requires javafx.controls;
    requires javafx.fxml;
            
        requires org.controlsfx.controls;
                            
    opens mythsearcher.mythsearcher to javafx.fxml;
    exports mythsearcher.mythsearcher;
}