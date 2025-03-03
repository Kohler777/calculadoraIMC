package com.example.calculadora.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.calculadora.Pessoa;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IMCController {

    @FXML
    private TextField nomeField;

    @FXML
    private TextField alturaField;

    @FXML
    private TextField pesoField;

    @FXML
    private Label resultadoLabel;

    @FXML
    private TableView<Pessoa> tabela;

    @FXML
    private TableColumn<Pessoa, String> nomeCol;

    @FXML
    private TableColumn<Pessoa, Double> alturaCol;

    @FXML
    private TableColumn<Pessoa, Double> pesoCol;

    @FXML
    private TableColumn<Pessoa, Double> imcCol;

    @FXML
    private TableColumn<Pessoa, String> classificacaoCol;

    private final List<Pessoa> pessoas = new ArrayList<>();

    private static final String FILE_PATH = "C:\\Users\\kohle\\IdeaProjects\\calculadoraIMC\\CALCULADORA\\CALCULADORA\\src\\main\\java\\com\\example\\calculadora\\cadastros_salvos";

    @FXML
    public void initialize() {
        nomeCol.setCellValueFactory(new PropertyValueFactory<>("nome"));
        alturaCol.setCellValueFactory(new PropertyValueFactory<>("altura"));
        pesoCol.setCellValueFactory(new PropertyValueFactory<>("peso"));
        imcCol.setCellValueFactory(new PropertyValueFactory<>("imc"));
        classificacaoCol.setCellValueFactory(new PropertyValueFactory<>("classificacaoIMC"));

        carregarCadastrosSalvos();
    }

    @FXML
    public void onCalculatorButtonClick(ActionEvent event) {
        try {
            String nome = nomeField.getText();
            double altura = Double.parseDouble(alturaField.getText());
            double peso = Double.parseDouble(pesoField.getText());

            Pessoa pessoa = new Pessoa(nome, altura, peso);

            resultadoLabel.setText("IMC: " + String.format("%.2f", pessoa.getImc()) + " - " + pessoa.getClassificacaoIMC());
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: Altura e Peso devem ser números válidos.");
        }
    }

    @FXML
    public void onSalvarButtonClick(ActionEvent event) {
        try {
            String nome = nomeField.getText();
            double altura = Double.parseDouble(alturaField.getText());
            double peso = Double.parseDouble(pesoField.getText());

            Pessoa pessoa = new Pessoa(nome, altura, peso);
            pessoas.add(pessoa);

            salvarCadastroNoArquivo(pessoa);
            tabela.getItems().add(pessoa);
            resultadoLabel.setText("Cadastro salvo com sucesso!");
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Erro: Altura e Peso devem ser números válidos.");
        }
    }

    @FXML
    public void onRecarregarButtonClick(ActionEvent event) {
        carregarCadastrosSalvos();
        resultadoLabel.setText("Dados recarregados.");
    }

    private void salvarCadastroNoArquivo(Pessoa pessoa) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(pessoa.getNome() + "," + pessoa.getAltura() + "," + pessoa.getPeso() + "," + pessoa.getImc() + "," + pessoa.getClassificacaoIMC());
            writer.newLine();
        } catch (IOException e) {
            resultadoLabel.setText("Erro ao salvar no arquivo.");
        }
    }

    private void carregarCadastrosSalvos() {
        pessoas.clear();
        tabela.getItems().clear();

        File arquivo = new File(FILE_PATH);
        if (!arquivo.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(",");
                if (dados.length == 5) {
                    String nome = dados[0];
                    double altura = Double.parseDouble(dados[1]);
                    double peso = Double.parseDouble(dados[2]);
                    double imc = Double.parseDouble(dados[3]);
                    String classificacao = dados[4];

                    Pessoa pessoa = new Pessoa(nome, altura, peso);
                    pessoas.add(pessoa);
                    tabela.getItems().add(pessoa);
                }
            }
        } catch (IOException e) {
            resultadoLabel.setText("Erro ao carregar os cadastros.");
        }
    }
}
