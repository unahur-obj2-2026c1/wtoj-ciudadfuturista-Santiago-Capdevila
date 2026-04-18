package ar.edu.unahur.Misiones;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.Drones.Dron;
import ar.edu.unahur.Sensores.Sensor;

public class MisionVigilancia extends Mision{
    private List<Sensor> sensores = new ArrayList<>();

    public MisionVigilancia(List<Sensor> sensores) {
        this.sensores = new ArrayList<>(sensores);
    }

    @Override
    public Integer extraSegunTipo() {
        return this.sensores.stream().mapToInt(s -> s.eficienciaOperativa()).sum();
    }

    @Override
    public Boolean esAvanzadoSegunMision(Dron dron) {
        return this.sensores.stream().allMatch(s -> s.esDuradero());
    }

}
