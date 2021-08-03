package main.model;


/**
 * Modelizacion de producto con serie para informar
 */

public class ProductoFacturado {

    private String fecha;
    private String cliente;
    private String remito;
    private String factura;
    private double codProd;
    private String GTIN;
    private String descripcion;
    private String serie;
    private boolean isInformed=false;



    // TODO variable booleana para determinar si esta informado o no, isInformed

    public ProductoFacturado() {
    }

    @Override
    public String toString() {
        return "ProductoFacturado{" +
                "fecha='" + fecha + '\'' +
                ", cliente='" + cliente + '\'' +
                ", remito='" + remito + '\'' +
                ", factura='" + factura + '\'' +
                ", codProd=" + codProd +
                ", GTIN='" + GTIN + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", serie='" + serie + '\'' +
                ", isInformed=" + isInformed +
                '}';
    }

    public boolean isInformed() {
        return isInformed;
    }

    public void setInformed(boolean informed) {
        isInformed = informed;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getRemito() {
        return remito;
    }

    public void setRemito(String remito) {
        this.remito = remito;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public double getCodProd() {
        return codProd;
    }

    public void setCodProd(double codProd) {
        this.codProd = codProd;
    }

    public String getGTIN() {
        return GTIN;
    }

    public void setGTIN(String GTIN) {
        this.GTIN = GTIN;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}
