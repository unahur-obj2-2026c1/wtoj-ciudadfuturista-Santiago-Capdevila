package ar.edu.unahur.Ciudades;

public class CiudadFuturista {
    private Integer cantMaxDrones = 10;
    private static CiudadFuturista ciudadFuturista = new CiudadFuturista();

    private CiudadFuturista() {
    }

    public void setCantMaxDrones(Integer cantMaxDrones) {
        this.cantMaxDrones = cantMaxDrones;
    }

    public Integer getCantMaxDrones() {
        return cantMaxDrones;
    }

    public static CiudadFuturista getCiudadFuturista() {
        return ciudadFuturista;
    }

}
