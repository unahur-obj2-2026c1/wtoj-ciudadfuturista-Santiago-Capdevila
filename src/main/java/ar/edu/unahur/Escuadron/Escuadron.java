package ar.edu.unahur.Escuadron;

import java.util.ArrayList;
import java.util.List;
import ar.edu.unahur.Ciudades.CiudadFuturista;
import ar.edu.unahur.Drones.Dron;
import ar.edu.unahur.Zonas.Zona;

public class Escuadron {
    private final List<Dron> drones = new ArrayList<>();

    public Escuadron() {
    }

    

    public void agregarDron(Dron dron, CiudadFuturista ciudadFuturista) {
        if (this.drones.size() >= ciudadFuturista.getCantMaxDrones()) {
            throw new RuntimeException("Supera la cantidad máxima definida por la ciudad");
        }

        this.drones.add(dron);
    }

    protected Boolean alMenosUnAvanzado() {
        return drones.stream().anyMatch(d -> d.esAvanzado());
    }

    protected Integer eficienciaOperativa() {
        return drones.stream().mapToInt(d -> d.eficienciaOperativa()).sum();
    }

    protected Boolean puedeOperar(Zona zona) {
        return this.alMenosUnAvanzado() && this.eficienciaOperativa() > zona.getTamaño() * 2;
    }

    public void operarZona(Zona zona) {
        if (this.puedeOperar(zona)) {
            zona.registrarOperacion();
            drones.forEach(d -> d.disminuirAutonomia());
        }
    }

    public List<Dron> getDrones() {
        return drones;
    }
}
