package ar.edu.unahur.Misiones;

import ar.edu.unahur.Drones.Dron;

public abstract class Mision {
    public abstract Integer extraSegunTipo();
    public abstract Boolean esAvanzadoSegunMision(Dron dron);
}
