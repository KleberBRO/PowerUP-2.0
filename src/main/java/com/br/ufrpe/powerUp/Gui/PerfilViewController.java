package com.br.ufrpe.powerUp.Gui;

import com.br.ufrpe.powerUp.Gui.Helpers.BasicController;
import com.br.ufrpe.powerUp.Gui.Helpers.PerfilControllerInterface;
import com.br.ufrpe.powerUp.Negocios.PerfilController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class PerfilViewController extends BasicController implements PerfilControllerInterface {
    @FXML
    private Button buttonConfig;
    @FXML
    private Button buttonAtividades;
    @FXML
    private Button buttonSemana;

    @FXML
    private Label labelNome;
    @FXML
    private HBox hBoxPerfil;

    PerfilController perfilController;

    @Override
    public PerfilController getUserController() {
        return perfilController;
    }

    @Override
    public void setPerfilController(PerfilController perfilController) {
        this.perfilController = perfilController;

        ImageView fotoPerfil = gerarFotoPerfil(perfilController.getPerfil().getCaminhoImagem());

        hBoxPerfil.getChildren().addFirst(fotoPerfil);
        labelNome.setText(perfilController.getPerfil().getNome());
    }


    @FXML
    private void atividadesMouseEntered() {
        buttonMouseInteract(buttonAtividades);
    }

    @FXML
    private void configMouseEntered() {
        buttonMouseInteract(buttonConfig);
    }

    @FXML
    private void semanaMouseEntered() {
        buttonMouseInteract(buttonSemana);
    }

}
