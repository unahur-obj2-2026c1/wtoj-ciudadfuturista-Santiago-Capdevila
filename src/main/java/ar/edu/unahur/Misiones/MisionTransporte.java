package ar.edu.unahur.Misiones;

import ar.edu.unahur.Drones.Dron;

public class MisionTransporte extends Mision{
    private static MisionTransporte misionTransporte;

    public MisionTransporte() {
    }

    public static MisionTransporte getMisionTransporte() {
        return misionTransporte;
    }

    @Override
    public Integer extraSegunTipo() {
        return 100;
    }

    @Override
    public Boolean esAvanzadoSegunMision(Dron dron) {
        return dron.getAutonomia() > 50;
    }

    
}
