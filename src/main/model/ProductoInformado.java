package main.model;


/**
 * Modelización del producto informado por nosotros al cliente
 */

public class ProductoInformado {

    private String idANMAT;
    private String GTIN;
    private String descripcion;
    private String glnOrigen;
    private String glnDestino;
    private String agenteOrigen;
    private String agenteDestino;
    private String factura;
    private String remito;
    private String estado;
    private String serie;



    public ProductoInformado() {
    }

    public ProductoInformado(String idANMAT, String GTIN, String descripcion, String glnOrigen, String glnDestino, String agenteOrigen, String agenteDestino, String factura, String remito, String estado, String serie) {
        this.idANMAT = idANMAT;
        this.GTIN = GTIN;
        this.descripcion = descripcion;
        this.glnOrigen = glnOrigen;
        this.glnDestino = glnDestino;
        this.agenteOrigen = agenteOrigen;
        this.agenteDestino = agenteDestino;
        this.factura = factura;
        this.remito = remito;
        this.estado = estado;
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "ProductoInformado{" +
                "idANMAT='" + idANMAT + '\'' +
                ", GTIN='" + GTIN + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", glnOrigen='" + glnOrigen + '\'' +
                ", glnDestino='" + glnDestino + '\'' +
                ", agenteOrigen='" + agenteOrigen + '\'' +
                ", agenteDestino='" + agenteDestino + '\'' +
                ", factura='" + factura + '\'' +
                ", remito='" + remito + '\'' +
                ", estado='" + estado + '\'' +
                ", serie='" + serie + '\'' +
                '}';
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getIdANMAT() {
        return idANMAT;
    }

    public void setIdANMAT(String idANMAT) {
        this.idANMAT = idANMAT;
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

    public String getGlnOrigen() {
        return glnOrigen;
    }

    public void setGlnOrigen(String glnOrigen) {
        this.glnOrigen = glnOrigen;
    }

    public String getGlnDestino() {
        return glnDestino;
    }

    public void setGlnDestino(String glnDestino) {
        this.glnDestino = glnDestino;
    }

    public String getAgenteOrigen() {
        return agenteOrigen;
    }

    public void setAgenteOrigen(String agenteOrigen) {
        this.agenteOrigen = agenteOrigen;
    }

    public String getAgenteDestino() {
        return agenteDestino;
    }

    public void setAgenteDestino(String agenteDestino) {
        this.agenteDestino = agenteDestino;
    }

    public String getFactura() {
        return factura;
    }

    public void setFactura(String factura) {
        this.factura = factura;
    }

    public String getRemito() {
        return remito;
    }

    public void setRemito(String remito) {
        this.remito = remito;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
