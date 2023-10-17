package mythsearcher.mythsearcher.utils;

import javafx.scene.control.Alert;

public class AlertTemp {
    public static void mostrarError(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setContentText(mensaje);
        alerta.show();
    }
    public static void mostrarInfo(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setContentText(mensaje);
        alerta.show();
    }
    public static void mostrarWarning(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
