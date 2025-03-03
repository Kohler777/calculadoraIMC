package com.example.calculadora;

import javafx.beans.property.*;

public class Pessoa {
    private final StringProperty nome;
    private final DoubleProperty altura;
    private final DoubleProperty peso;

    public Pessoa(String nome, double altura, double peso) {
        this.nome = new SimpleStringProperty(nome);
        this.altura = new SimpleDoubleProperty(altura);
        this.peso = new SimpleDoubleProperty(peso);
    }

    public String getNome() {
        return nome.get();
    }

    public double getAltura() {
        return altura.get();
    }

    public double getPeso() {
        return peso.get();
    }

    public double getImc() {
        return peso.get() / (altura.get() * altura.get());
    }

    public String getClassificacaoIMC() {
        double imc = getImc();
        if (imc < 18.5) return "Abaixo do peso";
        if (imc < 24.9) return "Peso normal";
        if (imc < 29.9) return "Sobrepeso";
        if (imc < 34.9) return "Obesidade grau I";
        if (imc < 39.9) return "Obesidade grau II";
        return "Obesidade grau III";
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public DoubleProperty alturaProperty() {
        return altura;
    }

    public DoubleProperty pesoProperty() {
        return peso;
    }

    public DoubleProperty imcProperty() {
        return new SimpleDoubleProperty(getImc());
    }

    public StringProperty classificacaoIMCProperty() {
        return new SimpleStringProperty(getClassificacaoIMC());
    }
}
