package com.br.ufrpe.powerUp.Dados;

import com.br.ufrpe.powerUp.Dados.Exceptions.CJEException;
import com.br.ufrpe.powerUp.Dados.Exceptions.CNException;
import com.br.ufrpe.powerUp.Negocios.Beans.Perfil;

import java.io.*;
import java.util.ArrayList;

public class RepositorioPerfis implements Serializable {
    private static RepositorioPerfis instancia;
    private ArrayList<Perfil> perfils;

    private RepositorioPerfis() {
        perfils = new ArrayList<>();
    }

    public static RepositorioPerfis getInstance() {
        if (instancia == null) {
            try {
                instancia = RepositorioPerfis.carregarDeArquivo("src/repositorioPerfis.ser");
            } catch (IOException | ClassNotFoundException e) {
                instancia = new RepositorioPerfis();
                return instancia;
            }
        }
        return instancia;
    }

    public void adicionarConta(Perfil perfil) throws CJEException {
        if (perfils.contains(perfil)) {
            throw new CJEException();
        }

        perfils.add(perfil);
    }

    public void removerConta(Perfil perfil) throws CNException {
        if (perfils.contains(perfil)) {
            perfils.remove(perfil);
        } else {
            throw new CNException();
        }
    }

    public Perfil procurarConta(Perfil perfilAlvo) throws CNException {
        Perfil perfilRetorno = null;

        for (Perfil perfil : perfils) {
            if (perfilAlvo.equals(perfil)) {
                perfilRetorno = perfil;
            }
        }

        if (perfilRetorno == null) {
            throw new CNException();
        }

        return perfilRetorno;
    }

    private static RepositorioPerfis carregarDeArquivo(String caminho) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            instancia = (RepositorioPerfis) ois.readObject();
            return instancia;
        }
    }

    public void salvarEmArquivo(String caminho) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(this);
        }
    }

    public ArrayList<String> getNomes() {
        ArrayList<String> nomes = new ArrayList<>();
        for (Perfil perfil : perfils) {
            nomes.add(perfil.getNome());
        }

        return nomes;
    }

}
