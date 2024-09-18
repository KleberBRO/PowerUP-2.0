package com.br.ufrpe.powerUp.Negocios.Beans;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Atividade {
    String nome;
    LocalDate data;
    boolean done;

}
