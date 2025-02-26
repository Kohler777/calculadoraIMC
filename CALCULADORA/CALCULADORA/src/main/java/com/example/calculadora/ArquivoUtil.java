package com.example.calculadora;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArquivoUtil {

    public static void salvarDados(List<Pessoa> pessoas, String arquivo) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            for (Pessoa pessoa : pessoas) {
                writer.write(pessoa.toString());
                writer.newLine();
            }
        }
    }

    public static List<Pessoa> carregarDados(String arquivo) throws IOException {
        List<Pessoa> pessoas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                double altura = Double.parseDouble(dados[1]);
                double peso = Double.parseDouble(dados[2]);
                pessoas.add(new Pessoa(nome, altura, peso));
            }
        }
        return pessoas;
    }
}