package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("resources/view/home.fxml"));

        Scene scene = new Scene(root);
        //scene.getStylesheets().add(getClass().getResource("resources/css/estilos.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.setTitle("Verificación de trazabilidad");
        primaryStage.show();

    }


    public static void main(String[] args) throws IOException {
        launch(args);

        /*
        File archivo = new File("src/sample/ReporteListadoMensualTXT.txt");
        FileReader reader = new FileReader(archivo);
        BufferedReader br = new BufferedReader(reader);

        String line = br.readLine();

        int c = 0;

        while(c<5){

            System.out.println(line);
            line = br.readLine();
            c++;
        }

         */

    }



}
