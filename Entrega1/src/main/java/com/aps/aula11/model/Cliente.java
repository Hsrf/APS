package com.aps.aula11;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

public class Cliente {

    private Long id;
    private String nome;

    public Cliente(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public Long getId(){
        return id;
    }

}