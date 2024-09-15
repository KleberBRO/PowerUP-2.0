package com.br.ufrpe.powerUp.Gui;

import com.br.ufrpe.powerUp.Gui.Helpers.BasicController;
import com.br.ufrpe.powerUp.Gui.Helpers.PerfilControllerInterface;
import com.br.ufrpe.powerUp.Negocios.PerfilController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class PerfilViewController extends BasicController implements PerfilControllerInterface {
    @FXML
    private Button buttonConfig;

    PerfilController perfilController;

    @Override
    public PerfilController getUserController() {
        return perfilController;
    }

    @Override
    public void setPerfilController(PerfilController perfilController) {
        this.perfilController = perfilController;
    }

    @FXML
    private void bConfigOnAction (ActionEvent event) throws IOException {
        criarCena(event, "/Views/ConfigView.fxml", this);
    }

    @FXML
    private void buttonMouseEntered() {
        buttonConfig.getStyleClass().remove("button-exited");
        buttonConfig.getStyleClass().add("button-entered");
    }

    @FXML
    private void buttonMouseExited() {
        buttonConfig.getStyleClass().remove("button-entered");
        buttonConfig.getStyleClass().add("button-exited");
    }
}
