module com.br.ufrpe.poweruproutine {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires static lombok;

    exports com.br.ufrpe.powerUp.Gui;
    exports com.br.ufrpe.powerUp.Gui.Helpers;
    opens com.br.ufrpe.powerUp.Gui to javafx.fxml;
    opens com.br.ufrpe.powerUp.Gui.Helpers to javafx.fxml;
}