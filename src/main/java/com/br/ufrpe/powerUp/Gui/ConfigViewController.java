package com.br.ufrpe.powerUp.Gui;

import com.br.ufrpe.powerUp.Gui.Helpers.BasicController;
import com.br.ufrpe.powerUp.Gui.Helpers.PerfilControllerInterface;
import com.br.ufrpe.powerUp.Negocios.PerfilController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class ConfigViewController extends BasicController implements PerfilControllerInterface {
    @FXML
    private Button buttonPerfil;
    @FXML
    private Button buttonAtividades;

    PerfilController perfilController;

    @Override
    public void setPerfilController(PerfilController perfilController) {
        this.perfilController = perfilController;
    }

    @Override
    public PerfilController getUserController() {
        return perfilController;
    }

    @FXML
    private void bPerfilOnAction(ActionEvent event) throws IOException {
        criarCena(event, "/Views/PerfilView.fxml", this);
    }

    @FXML
    private void bAtividadesOnAction(ActionEvent event) throws IOException {
        criarCena(event, "/Views/atividadesView.fxml", this);
    }

    @FXML
    private void atividadesMouseEntered() {
        buttonMouseEntered(buttonAtividades);
    }

    @FXML
    private void atividadesMouseExited() {
        buttonMouseExited(buttonAtividades);
    }

    @FXML
    private void perfilMouseEntered() {
        buttonMouseEntered(buttonPerfil);
    }

    @FXML
    private void perfilMouseExited() {
        buttonMouseExited(buttonPerfil);
    }

}
