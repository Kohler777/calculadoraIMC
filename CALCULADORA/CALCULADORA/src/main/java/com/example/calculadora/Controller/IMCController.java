package com.example.calculadora.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import com.example.calculadora.Pessoa;

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
    private Button calcularButton;

    // Este método precisa ter o parâmetro ActionEvent
    @FXML

    public void onCalculatorButtonClick(ActionEvent event) {
        try {
            String nome = nomeField.getText();
            double altura = Double.parseDouble(alturaField.getText());
            double peso = Double.parseDouble(pesoField.getText());

            // Cria um novo objeto Pessoa e calcula o IMC
            Pessoa pessoa = new Pessoa(nome, altura, peso);
            // pessoas.add(pessoa);  // Se você estiver usando uma lista de pessoas, adicione à lista aqui.

            // Exibe o resultado no label
            resultadoLabel.setText("IMC: " + String.format("%.2f", pessoa.getImc()) + " - " + pessoa.getClassificacaoIMC());
        } catch (NumberFormatException e) {
            // Em caso de erro de formato, exibe mensagem de erro
            resultadoLabel.setText("Erro: Altura e Peso devem ser números válidos.");
        }
    }
}
