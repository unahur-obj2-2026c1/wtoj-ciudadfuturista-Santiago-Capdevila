package ar.edu.unahur.Drones;

import ar.edu.unahur.Misiones.Mision;

public class DronSeguridad extends Dron{

    public DronSeguridad(Integer autonomia, Integer procesamiento, Mision mision) {
        super(autonomia, procesamiento, mision);
    }

    @Override
    protected Boolean esAvanzadoSegunTipo() {
        return this.getProcesamiento() > 50; 
    }
    
}
