package main.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.model.ProductoFacturado;
import main.model.ProductoInformado;
import main.service.MercaderiaFacturadaServicio;
import main.service.MercaderiaInformadaServicio;
import main.service.VerificadorDeSeriesInformadas;

import java.io.File;
import java.util.List;

public class Controller {


    Stage stage;
    FileChooser fileChooser;

    @FXML
    private Label carenaLabel;
    @FXML
    private Label anmatLabel;
    @FXML
    private TextArea textArea;
    @FXML
    private Button run;
    @FXML
    private Label informadasLabel;
    @FXML
    private Label totalSeriesLabel;
    @FXML
    private Label pendientesLabel;



    private File carenaFile;
    private File anmatFile;

    VerificadorDeSeriesInformadas verificadorDeSeriesInformadas;

    private MercaderiaFacturadaServicio mercaderiaFacturadaServicio = new MercaderiaFacturadaServicio();

    public void openFileCarena(ActionEvent event){

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir detalle de mercadería facturada");
        carenaFile = fileChooser.showOpenDialog(stage);

        if (carenaFile!=null){
            carenaLabel.setText(carenaFile.getName());
            carenaLabel.setStyle("-fx-background-color: #37ab69;" +
                    "-fx-border-color: #11672e;");
            checkReadyCondition();
        }

    }

    public void openFileANMAT(ActionEvent event){

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();

        fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir detalle de mercadería facturada");
        anmatFile = fileChooser.showOpenDialog(stage);

        if (anmatFile!=null){
            anmatLabel.setText(anmatFile.getName());
            anmatLabel.setStyle("-fx-background-color: #37ab69;" +
                    "-fx-border-color: #11672e;");
            checkReadyCondition();
        }

    }

    public void runProgram(ActionEvent event){

        // Listado de productos facturados pendientes de verificar si fueron informados
        List<ProductoFacturado> productosFacturados = MercaderiaFacturadaServicio.getProductos(carenaFile);

        // Listado de productos informados a ANMAT
        List<ProductoInformado> productosInformados = MercaderiaInformadaServicio.getProductosInformados(anmatFile);

        // Listado de String de las series informadas para verificar si las series
        // facturadas se encuentran informadas
        //assert productosInformados != null;
        List<String> seriesInformadas = MercaderiaInformadaServicio.getSeriesInformadas(productosInformados);

        // Obtengo lista de los productos, verificando si se encuentran informados
        verificadorDeSeriesInformadas = new VerificadorDeSeriesInformadas(productosFacturados,seriesInformadas);
        List<ProductoFacturado> productosVerificados = verificadorDeSeriesInformadas.getProductosVerificados();

        // TODO Devuelve cantidad de aciertos/total, y muestra detalle de los casos pendientes de informar

        int total = productosVerificados.size();
        System.out.println("Total:"+total);

        int verificados = 0;

        for (ProductoFacturado prodVerificado:productosVerificados){
            if(prodVerificado.isInformed()){
                verificados++;
                System.out.println("Verificados: "+verificados);
            } else{
                System.out.println(prodVerificado.toString());
            }
        }
        System.out.println(verificados);

        double resultado = (double) verificados/total;

        System.out.println(resultado);
        System.out.println("Done.");

        informadasLabel.setText("prueba");



    }


    public void checkReadyCondition(){

        if(!carenaLabel.textProperty().get().equals("sin referencia") && (!anmatLabel.textProperty().get().equals("sin referencia"))){
            run.disableProperty().set(false);
        }
    }


}
