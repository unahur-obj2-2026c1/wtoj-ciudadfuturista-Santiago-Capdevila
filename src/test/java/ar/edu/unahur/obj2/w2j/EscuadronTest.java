package ar.edu.unahur.obj2.w2j;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import ar.edu.unahur.Ciudades.CiudadFuturista;
import ar.edu.unahur.Drones.Dron;
import ar.edu.unahur.Drones.DronComercial;
import ar.edu.unahur.Drones.DronSeguridad;
import ar.edu.unahur.Escuadron.Escuadron;
import ar.edu.unahur.Misiones.MisionExploracion;
import ar.edu.unahur.Misiones.MisionTransporte;
import ar.edu.unahur.Zonas.Zona;

public class EscuadronTest {
    CiudadFuturista ciudadFuturista = CiudadFuturista.getCiudadFuturista();

    @Test
    void noSePuedeSuperarLaCantidadMaximaDeDrones() {
        ciudadFuturista.setCantMaxDrones(1);

        Escuadron escuadron = new Escuadron();
        escuadron.agregarDron(new DronComercial(30, 10, new MisionTransporte()), ciudadFuturista);

        assertThrows(RuntimeException.class, () -> escuadron.agregarDron(new DronComercial(30, 10, new MisionTransporte()), ciudadFuturista));
    }

    @Test
    void puedeOperarZonaSiTieneUnDronAvanzadoYCapacidadSuficiente() {
        Escuadron escuadron = new Escuadron();
        escuadron.agregarDron(new DronComercial(60, 10, new MisionTransporte()), ciudadFuturista);
        escuadron.agregarDron(new DronSeguridad(20, 10, new MisionExploracion()), ciudadFuturista);

        Zona zona = new Zona(150);

        escuadron.operarZona(zona);

        assertEquals(1, zona.getOperacionesRecibidas());
    }

    @Test
    void noPuedeOperarZonaSiNoTieneDronesAvanzados() {
        ciudadFuturista.setCantMaxDrones(10);

        Escuadron escuadron = new Escuadron();
        escuadron.agregarDron(new DronComercial(20, 10, new MisionExploracion()), ciudadFuturista);
        escuadron.agregarDron(new DronComercial(21, 10, new MisionExploracion()), ciudadFuturista);

        Zona zona = new Zona(50);

        escuadron.operarZona(zona);

        assertEquals(0, zona.getOperacionesRecibidas());
    }

    @Test
    void operarZonaRegistraOperacionYReduceAutonomiaEnCadaDron() {
        Dron dron1 = new DronSeguridad(30, 60, new MisionExploracion());
        Dron dron2 = new DronSeguridad(40, 10, new MisionTransporte());

        Escuadron escuadron = new Escuadron();
        escuadron.agregarDron(dron1, ciudadFuturista);
        escuadron.agregarDron(dron2, ciudadFuturista);

        Zona zona = new Zona(200);
        escuadron.operarZona(zona);

        assertEquals(1, zona.getOperacionesRecibidas());
        assertEquals(28, dron1.getAutonomia());
        assertEquals(38, dron2.getAutonomia());

    }

    @Test
    void siNoPuedeOperarLaZonaNoHayCambios() {
        Dron dron = new DronComercial(20, 10, new MisionExploracion());

        Escuadron escuadron = new Escuadron();
        escuadron.agregarDron(dron, ciudadFuturista);

        Zona zona = new Zona(1000);
        escuadron.operarZona(zona);

        escuadron.operarZona(zona);

        assertEquals(0, zona.getOperacionesRecibidas());
        assertEquals(20, dron.getAutonomia());
    }

    @Test
    void xd() {
        ciudadFuturista.setCantMaxDrones(10);

        Escuadron escuadron = new Escuadron();
        
        escuadron.agregarDron(new DronSeguridad(10, 60, new MisionExploracion()), ciudadFuturista);
        escuadron.agregarDron(new DronComercial(10, 30, new MisionExploracion()), ciudadFuturista);

        Zona zona = new Zona(1000);

        escuadron.operarZona(zona);
        
        assertFalse(zona.getOperacionesRecibidas() > 1);
        assertFalse(escuadron.getDrones().stream().mapToInt(d -> d.getAutonomia()).sum() > 20);
    }
}
