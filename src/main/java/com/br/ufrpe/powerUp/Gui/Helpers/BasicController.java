package com.br.ufrpe.powerUp.Gui.Helpers;

import com.br.ufrpe.powerUp.Dados.Exceptions.CNException;
import com.br.ufrpe.powerUp.Negocios.PerfilController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

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
}
