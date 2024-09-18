package com.br.ufrpe.powerUp.Negocios;

import com.br.ufrpe.powerUp.Dados.Exceptions.CJEException;
import com.br.ufrpe.powerUp.Dados.Exceptions.CNException;
import com.br.ufrpe.powerUp.Dados.RepositorioPerfis;
import com.br.ufrpe.powerUp.Negocios.Beans.Perfil;
import lombok.Getter;

import java.util.ArrayList;

@Getter
public class PerfilController {
    private Perfil perfil;
    private static RepositorioPerfis repo = RepositorioPerfis.getInstance();

    public PerfilController(String nome) throws CNException {
        perfil = new Perfil(nome);

        perfil = repo.procurarConta(perfil);
    }

    public static String getCaminhoImagem(String nome) throws CNException {
        Perfil perfilAlvo = new Perfil(nome);
        perfilAlvo = repo.procurarConta(perfilAlvo);

        return perfilAlvo.getCaminhoImagem();
    }

    public static void criarPerfil(String nome, String caminho) throws CJEException {
        Perfil novoPerfil = new Perfil(nome, caminho);

        repo.adicionarConta(novoPerfil);
    }

    public static void removerPerfil(String nome) throws CNException {
        Perfil removerPerfil = new Perfil(nome);
        repo.removerConta(removerPerfil);
    }

    public static ArrayList<String> getNomePerfis() {
        return repo.getNomes();
    }
}
