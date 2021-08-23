module gr.kouretas.first.javafxsimpleproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens gr.kouretas.first.javafxsimpleproject to javafx.fxml;
    exports gr.kouretas.first.javafxsimpleproject;
}