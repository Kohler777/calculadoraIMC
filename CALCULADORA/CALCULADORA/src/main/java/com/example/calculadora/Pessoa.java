package com.example.calculadora;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pessoa {

    private SimpleStringProperty nome;
    private SimpleDoubleProperty altura;
    private SimpleDoubleProperty peso;
    private SimpleDoubleProperty imc;
    private SimpleStringProperty classificacaoIMC;

    public Pessoa(String nome, double altura, double peso) {
        this.nome = new SimpleStringProperty(nome);
        this.altura = new SimpleDoubleProperty(altura);
        this.peso = new SimpleDoubleProperty(peso);
        this.imc = new SimpleDoubleProperty(calcularIMC());
        this.classificacaoIMC = new SimpleStringProperty(getClassificacaoIMC());
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public double getAltura() {
        return altura.get();
    }

    public SimpleDoubleProperty alturaProperty() {
        return altura;
    }

    public double getPeso() {
        return peso.get();
    }

    public SimpleDoubleProperty pesoProperty() {
        return peso;
    }

    public double getImc() {
        return imc.get();
    }

    public SimpleDoubleProperty imcProperty() {
        return imc;
    }

    public String getClassificacaoIMC() {
        if (imc.get() < 18.5) {
            return "Abaixo do Peso";
        } else if (imc.get() < 24.9) {
            return "Peso Normal";
        } else if (imc.get() < 29.9) {
            return "Sobrepeso";
        } else if (imc.get() < 34.9) {
            return "Obesidade Grau 1";
        } else if (imc.get() < 39.9) {
            return "Obesidade Grau 2";
        } else {
            return "Obesidade Grau 3";
        }
    }

    public SimpleStringProperty classificacaoIMCProperty() {
        return classificacaoIMC;
    }

    private double calcularIMC() {
        return peso.get() / (altura.get() * altura.get());
    }
}