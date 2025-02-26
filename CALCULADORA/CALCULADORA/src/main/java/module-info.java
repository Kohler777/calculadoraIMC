module com.example.calculadora {
    // Requer módulos do JavaFX
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;  // Necessário para a funcionalidade básica do JavaFX

    // Exporta os pacotes necessários
    exports com.example.calculadora;  // Exporta o pacote principal
    exports com.example.calculadora.Controller;  // Exporta o pacote do controlador para o javafx.fxml

    // Abertura do pacote para introspecção (necessário para o FXML)
    opens com.example.calculadora to javafx.fxml;  // Isso permite o acesso ao controlador
    opens com.example.calculadora.Controller to javafx.fxml; // Garante que o controlador seja acessível
}
