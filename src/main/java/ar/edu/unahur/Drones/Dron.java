package ar.edu.unahur.Drones;

import ar.edu.unahur.Misiones.Mision;

public abstract class Dron {
    private Integer autonomia = 0;
    private Integer procesamiento = 0;
    private Mision mision;

    public Dron(Integer autonomia,Integer procesamiento, Mision mision) {
        this.autonomia = autonomia;
        this.procesamiento = procesamiento;
        this.mision = mision;
    }

    public Integer getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(Integer autonomia) {
        this.autonomia = autonomia;
    }

    public Integer getProcesamiento() {
        return procesamiento;
    }

    public Mision getMision() {
        return mision;
    }

    public void setMision(Mision mision) {
        this.mision = mision;
    }
    
    public Integer eficienciaOperativa() {
        return (this.autonomia * 10) + mision.extraSegunTipo();
    }

    public Boolean esAvanzado() {
        return this.esAvanzadoSegunTipo() || mision.esAvanzadoSegunMision(this);
    }

    protected abstract Boolean esAvanzadoSegunTipo();

    public void disminuirAutonomia() {
        this.autonomia = Math.max(0, this.autonomia - 2);
    }

}
