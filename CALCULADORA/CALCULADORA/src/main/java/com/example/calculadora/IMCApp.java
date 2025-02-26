package com.example.calculadora;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IMCApp extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo FXML
        Parent root = FXMLLoader.load(getClass().getResource("/com/example/calculadora/IMC_view.fxml"));

        // Define o título da janela
        primaryStage.setTitle("Calculadora de IMC");

        // Define a cena com o layout carregado do FXML e as dimensões da janela
        primaryStage.setScene(new Scene(root, 600, 400));

        // Exibe a janela
        primaryStage.show();
    }

    // Método main para iniciar a aplicação
    public static void main(String[] args) {
        launch(args);
    }
}
