package main.service;

import main.model.ProductoInformado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MercaderiaInformadaServicio {

    public static List<ProductoInformado> getProductosInformados(File file) {

        List<ProductoInformado> productosInformados = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while(line!=null){

                if (line.substring(47,53).equals("DISTRI")){

                    String idANMAT = line.substring(0,10).strip();
                    String GTIN = line.substring(526,540).strip();
                    String serie = line.substring(810,826).strip();
                    String descripcion = line.substring(545,797).strip();
                    String glnDestino = line.substring(1094,1107).strip();
                    String agenteDestino = line.substring(1114,1314).strip();
                    String factura = line.substring(1314,1327).strip();
                    String remito = line.substring(1334,1348).strip();


                    ProductoInformado nuevoProductoInformado = new ProductoInformado();

                    nuevoProductoInformado.setIdANMAT(idANMAT);
                    nuevoProductoInformado.setGTIN(GTIN);
                    nuevoProductoInformado.setSerie(serie);
                    nuevoProductoInformado.setDescripcion(descripcion);
                    nuevoProductoInformado.setGlnDestino(glnDestino);
                    nuevoProductoInformado.setAgenteDestino(agenteDestino);
                    nuevoProductoInformado.setFactura(factura);
                    nuevoProductoInformado.setRemito(remito);

                    productosInformados.add(nuevoProductoInformado);

                }

                line=br.readLine();
            }

            return productosInformados;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Fallo al intentar leer los archivos de ANMAT");
            return null;
        }
    }

    public static List<String> getSeriesInformadas(List<ProductoInformado> productosInformados) {

        List<String> seriesInformadas = new ArrayList<>();

        for (ProductoInformado prod:productosInformados){
            seriesInformadas.add(prod.getSerie());
        }

        return seriesInformadas;
    }
}
