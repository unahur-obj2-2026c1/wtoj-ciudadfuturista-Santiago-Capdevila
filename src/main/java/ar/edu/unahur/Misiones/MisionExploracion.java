package ar.edu.unahur.Misiones;

import ar.edu.unahur.Drones.Dron;

public class MisionExploracion extends Mision{
    private static MisionExploracion misionExploracion;

    public MisionExploracion() {
    }

    public static MisionExploracion getMisionExploracion() {
        return misionExploracion;
    }

    @Override
    public Integer extraSegunTipo() {
        return 0;
    }

    @Override
    public Boolean esAvanzadoSegunMision(Dron dron) {
        return dron.eficienciaOperativa() % 2 == 0;
    }
    
}
