package com.br.ufrpe.powerUp.Gui;

import com.br.ufrpe.powerUp.Dados.Exceptions.CNException;
import com.br.ufrpe.powerUp.Gui.Helpers.BasicController;
import com.br.ufrpe.powerUp.Negocios.PerfilController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MainController extends BasicController {
    @FXML
    private Pane paneCriarPerfil;
    @FXML
    private HBox hboxPerfis;
    @FXML
    private Button buttonEditarPerfis;

    private ArrayList<String> nomePerfis;

    private boolean editar;

    public void initialize() throws CNException {
        editar = false;
        atualizarPerifs(false);
        limparHBox();
        atualizarPerifs(false);
    }

    private void atualizarPerifs(boolean editar) throws CNException {
        limparHBox();
        nomePerfis = PerfilController.getNomePerfis();

        if (nomePerfis != null) {
            for (String nome : nomePerfis){
                VBox vBox = new VBox(2);
                vBox.getStyleClass().add("perfil-vbox");
                vBox.setPrefSize(200, 100);
                vBox.setAlignment(Pos.CENTER);
                vBox.setCursor(Cursor.HAND);

                ImageView imagem = gerarFotoPerfil(PerfilController.getCaminhoImagem(nome));

                Label nomeLabel = new Label(nome);
                nomeLabel.getStyleClass().add("nome-label");

                vBox.getChildren().addAll(imagem, nomeLabel);

                if (editar) {
                    Image lixo = new Image(getClass().getResource("/Images/icones/lixo.png").toString());
                    ImageView imageView = new ImageView(lixo);
                    imageView.setFitHeight(20);
                    imageView.setFitWidth(20);

                    Pane imagePane = new Pane();
                    imagePane.setPrefSize(20,20);
                    imagePane.setMaxSize(20, 20);
                    imagePane.setMinSize(20, 20);
                    imagePane.setCursor(Cursor.HAND);
                    imagePane.getChildren().add(imageView);

                    imagePane.setOnMouseClicked(event -> {
                        try {
                            PerfilController.removerPerfil(nome);
                            hboxPerfis.getChildren().remove(vBox);
                            atualizarPerifs(true);

                        } catch (CNException e) {
                            throw new RuntimeException(e);

                        }
                    });
                    vBox.getChildren().add(imagePane);
                } else {
                    vBox.setCursor(Cursor.HAND);
                    vBox.setOnMouseClicked(event -> logarPerfil(event, nome));
                }

                hboxPerfis.getChildren().addFirst(vBox);
            }
        }
    }

    private void logarPerfil(MouseEvent event ,String nome) {
        try {
            PerfilController perfilController = new PerfilController(nome);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Views/PerfilView.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            PerfilViewController perfilViewController = loader.getController();
            perfilViewController.setPerfilController(perfilController);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (CNException | IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void limparHBox() {
        int size = hboxPerfis.getChildren().size();

        if (size > 5) {
            Node ultimoFilho = hboxPerfis.getChildren().get(size - 1);
            ultimoFilho.setDisable(true);
            ultimoFilho.setVisible(false);

            hboxPerfis.getChildren().removeIf(child -> child != ultimoFilho);
        } else {
            if (size > 1) {
                Node ultimoFilho = hboxPerfis.getChildren().get(size - 1);
                ultimoFilho.setDisable(false);
                ultimoFilho.setVisible(true);

                hboxPerfis.getChildren().clear();
                hboxPerfis.getChildren().add(ultimoFilho);
            }
        }
    }


    @FXML
    private void modoEditar() throws CNException {
        if (editar) {
            editar = false;
            buttonEditarPerfis.setText("Editar perfil");
            atualizarPerifs(editar);
        } else {
            editar = true;
            buttonEditarPerfis.setText("Voltar");
            atualizarPerifs(editar);
        }
    }

    @FXML
    private void criarPerfil(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/Views/cadastroView.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }catch (IOException e) {
            throw new RuntimeException();
        }
    }
}