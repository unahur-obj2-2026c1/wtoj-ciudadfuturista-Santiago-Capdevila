package ar.edu.unahur.Drones;

import ar.edu.unahur.Misiones.Mision;

public class DronComercial extends Dron {

    public DronComercial(Integer autonomia, Integer procesamiento, Mision mision) {
        super(autonomia, procesamiento, mision);
    }

    @Override
    public Integer eficienciaOperativa() {
        return super.eficienciaOperativa() + 15;
    }

    @Override
    protected Boolean esAvanzadoSegunTipo() {
        return false;
    }
}
