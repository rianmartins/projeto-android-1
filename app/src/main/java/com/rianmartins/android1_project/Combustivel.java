package com.rianmartins.android1_project;

/**
 * Created by rianmartins on 17/04/18.
 */

public class Combustivel {

    private String nome = "";
    private double preco = 0;

    public Combustivel(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


}
