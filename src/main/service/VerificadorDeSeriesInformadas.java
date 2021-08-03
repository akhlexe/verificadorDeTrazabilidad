package main.service;

import main.model.ProductoFacturado;

import java.util.List;

public class VerificadorDeSeriesInformadas {

    List<ProductoFacturado> productoFacturados;
    List<String> seriesInformadas;

    public VerificadorDeSeriesInformadas(List<ProductoFacturado> productosFacturados, List<String> seriesInformadas) {
        this.productoFacturados = productosFacturados;
        this.seriesInformadas = seriesInformadas;
    }

    public List<ProductoFacturado> getProductosVerificados(){

        for (ProductoFacturado prod:productoFacturados){

            if (seriesInformadas.contains(prod.getSerie())){
                prod.setInformed(true);
            }
        }

        return productoFacturados;
    }

}
