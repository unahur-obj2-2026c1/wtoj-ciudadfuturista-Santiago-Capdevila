package ar.edu.unahur.Sensores;

public class Sensor {
    private final Integer capacidad;
    private final Integer durabilidad;
    private final Boolean mejorasTecnologicas;
    
    public Sensor(Integer capacidad, Integer durabilidad, Boolean mejorasTecnologicas) {
        this.capacidad = capacidad;
        this.durabilidad = durabilidad;
        this.mejorasTecnologicas = mejorasTecnologicas;
    }

    public Integer getCapacidad() {
        return capacidad;
    }

    public Integer getDurabilidad() {
        return durabilidad;
    }

    public Boolean getMejorasTecnologicas() {
        return mejorasTecnologicas;
    }

    public Integer eficienciaOperativa() {
        return this.getMejorasTecnologicas() ? this.getCapacidad() * 2 : this.getCapacidad();
    }

    public Boolean esDuradero() {
        return this.durabilidad > this.capacidad * 2; 
    }

}
