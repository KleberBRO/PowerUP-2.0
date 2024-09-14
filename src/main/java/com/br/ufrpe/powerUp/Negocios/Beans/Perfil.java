package com.br.ufrpe.powerUp.Negocios.Beans;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Perfil {
    private String nome;
    private String caminhoImagem;

    public Perfil(String nome) {
        this.nome = nome;
        this.caminhoImagem = "/Images/default.png";
    }

    public Perfil(String nome, String caminho) {
        this.nome = nome;
        this.caminhoImagem = caminho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Perfil perfil = (Perfil) o;
        return nome.equals(perfil.nome);
    }
}
