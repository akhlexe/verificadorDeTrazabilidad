package main.service;

import main.model.ProductoFacturado;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MercaderiaFacturadaServicio {



    public static List<ProductoFacturado> getProductos(File file) {

        // Lista de productos vacia
        List<ProductoFacturado> productoFacturados = new ArrayList<>();

        try{
            //POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
            InputStream fs = new FileInputStream(file);
            XSSFWorkbook wb = new XSSFWorkbook(fs);
            XSSFSheet sheet = wb.getSheetAt(0);

            XSSFRow row;
            XSSFCell cell;

            int rows = sheet.getPhysicalNumberOfRows();

            for (int i=1;i<rows;i++){
               row = sheet.getRow(i);
               if(row.getCell(10)!=null && row.getCell(10).getCellType() != CellType.BLANK){

                   String[] listaDeSeries;

                   String cliente = row.getCell(1).getStringCellValue();
                   String remito = row.getCell(2).getStringCellValue();
                   String factura = row.getCell(3).getStringCellValue();
                   double codProd = row.getCell(4).getNumericCellValue();
                   String GTIN = row.getCell(5).getRawValue();
                   String descripcion = row.getCell(6).getStringCellValue();
                   int cantidad = (int) row.getCell(7).getNumericCellValue();

                   System.out.println(cliente);

                   if(cantidad>1){
                       String series = row.getCell(10).getStringCellValue();
                       String[] tempArray = series.split("/");
                       listaDeSeries = tempArray;

                   } else{
                       String series = row.getCell(10).getRawValue();
                       String[] tempArray = new String[1];
                       tempArray[0] = series;
                       listaDeSeries = tempArray;
                   }

                   for (String serie:listaDeSeries){

                       String tempSerie = serie;

                       while(tempSerie.length()<8){
                           tempSerie = "0".concat(tempSerie);
                       }

                       ProductoFacturado nuevoProducto = new ProductoFacturado();

                       nuevoProducto.setCliente(cliente);
                       nuevoProducto.setRemito(remito);
                       nuevoProducto.setFactura(factura);
                       nuevoProducto.setCodProd(codProd);
                       nuevoProducto.setGTIN(GTIN);
                       nuevoProducto.setDescripcion(descripcion);



                       nuevoProducto.setSerie(tempSerie);

                       productoFacturados.add(nuevoProducto);
                   }

               }
            }


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return productoFacturados;
    }


}
