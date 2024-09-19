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
    @FXML
    private Button buttonSemana;

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
    private void atividadesMouseEntered() {
        buttonMouseInteract(buttonAtividades);
    }

    @FXML
    private void perfilMouseEntered() {
        buttonMouseInteract(buttonPerfil);
    }

    @FXML
    private void semanaMouseEntered() {
        buttonMouseInteract(buttonSemana);
    }

}
