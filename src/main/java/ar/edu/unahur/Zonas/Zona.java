package ar.edu.unahur.Zonas;

public class Zona {
    private Integer tamaño;
    private Integer operacionesRecibidas = 0;
    
    public Zona(Integer tamaño) {
        this.tamaño = tamaño;
    }

    public Integer getTamaño() {
        return tamaño;
    }

    public void setTamaño(Integer tamaño) {
        this.tamaño = tamaño;
    }

    public Integer getOperacionesRecibidas() {
        return operacionesRecibidas;
    }

    public void setOperacionesRecibidas(Integer operacionesRecibidas) {
        this.operacionesRecibidas = operacionesRecibidas;
    }

    public void registrarOperacion() {
        this.operacionesRecibidas += 1;
    }
}
