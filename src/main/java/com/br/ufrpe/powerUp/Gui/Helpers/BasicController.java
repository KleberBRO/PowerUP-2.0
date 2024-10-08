package com.br.ufrpe.powerUp.Gui.Helpers;

import com.br.ufrpe.powerUp.Dados.Exceptions.CNException;
import com.br.ufrpe.powerUp.Negocios.PerfilController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public abstract class BasicController {

    protected ImageView gerarFotoPerfil(String caminho) {
        Image fotoPerfil = new Image(caminho);
        ImageView imagem = new ImageView(fotoPerfil);
        imagem.setFitWidth(100);
        imagem.setFitHeight(100);
        Circle clip = new Circle(50, 50, 50);
        imagem.setClip(clip);

        return imagem;
    }

    protected static <C> void criarCena(ActionEvent event, String fxmlFile, C controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BasicController.class.getResource(fxmlFile));
        Parent root = fxmlLoader.load();

        // Obter o controlador da tela
        C loadedController = fxmlLoader.getController();
        if (controller != null) {
            if (controller instanceof PerfilControllerInterface) {
                // 'controller' é o atual e o 'loadedController' é o próximo
                ((PerfilControllerInterface) loadedController).setPerfilController(((PerfilControllerInterface) controller).getUserController());
            }
        }

        // Configurar a cena e o palco
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    protected void buttonMouseInteract(Button button) {
        if (button.getStyleClass().contains("button-exited")) {
            button.getStyleClass().remove("button-exited");
            button.getStyleClass().add("button-entered");
        } else {
            button.getStyleClass().remove("button-entered");
            button.getStyleClass().add("button-exited");
        }
    }

    @FXML
    protected void bPerfilOnAction(ActionEvent event) throws IOException {
        criarCena(event, "/Views/PerfilView.fxml", this);
    }

    @FXML
    protected void bAtividadesOnAction(ActionEvent event) throws IOException {
        criarCena(event, "/Views/atividadesView.fxml", this);
    }

    @FXML
    protected void bConfigOnAction (ActionEvent event) throws IOException {
        criarCena(event, "/Views/ConfigView.fxml", this);
    }

    @FXML
    protected void bSemanaOnAction(ActionEvent event) throws IOException {
        criarCena(event, "/Views/SemanaView.fxml", this);
    }
}
