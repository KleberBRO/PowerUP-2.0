package com.br.ufrpe.powerUp.Gui;

import com.br.ufrpe.powerUp.Dados.Exceptions.CJEException;
import com.br.ufrpe.powerUp.Gui.Helpers.BasicController;
import com.br.ufrpe.powerUp.Negocios.PerfilController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Objects;

public class CadastroViewController extends BasicController {
    @FXML
    private TextField txtFieldNome;
    @FXML
    private Label labelExiste;
    @FXML
    private ScrollPane scrollPaneFotos;

    private String caminhoFoto;
    private ImageView ultimaImagem = null;

    public void initialize() {
        try {
            File dir = new File(Objects.requireNonNull(PerfilController.class.getResource("/Images/fotoPerfil")).toURI());
            if (dir.isDirectory()) {
                File[] arquivos = dir.listFiles();
                if (arquivos != null){
                    FlowPane flowPane = new FlowPane();
                    flowPane.setPrefWrapLength(480);
                    flowPane.setHgap(10);
                    flowPane.setVgap(10);

                    for (File arquivo : arquivos) {
                        String caminho = PerfilController.class.getResource("/Images/fotoPerfil").toString() + arquivo.getName();
                        ImageView imagem = gerarFotoPerfil(caminho);
                        imagem.setCursor(Cursor.HAND);

                        imagem.setOnMouseClicked(event -> {
                            if (ultimaImagem != null) {
                                ultimaImagem.setEffect(null);
                            }

                            DropShadow borda = new DropShadow();
                            borda.setColor(Color.BLUE);
                            borda.setWidth(20);
                            borda.setHeight(20);
                            imagem.setEffect(borda);

                            ultimaImagem = imagem;
                            caminhoFoto = caminho;
                        });

                        flowPane.getChildren().add(imagem);
                    }

                    scrollPaneFotos.setContent(flowPane);

                }
            }
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void voltarOnAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/Views/LoginView.fxml")));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void criarPerfilOnAction(ActionEvent event) {
        try {
            String nome = txtFieldNome.getText();
            if (caminhoFoto != null)
                PerfilController.criarPerfil(nome, caminhoFoto);
            else
                PerfilController.criarPerfil(nome, getClass().getResource("/Images/fotoPerfil/zDefault.png").toString());


            voltarOnAction(event);
        } catch (CJEException e) {
            labelExiste.setVisible(true);
        }
    }
}
