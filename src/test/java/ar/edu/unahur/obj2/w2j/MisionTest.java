package ar.edu.unahur.obj2.w2j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.Drones.Dron;
import ar.edu.unahur.Drones.DronComercial;
import ar.edu.unahur.Drones.DronSeguridad;
import ar.edu.unahur.Misiones.Mision;
import ar.edu.unahur.Misiones.MisionExploracion;
import ar.edu.unahur.Misiones.MisionTransporte;
import ar.edu.unahur.Misiones.MisionVigilancia;
import ar.edu.unahur.Sensores.Sensor;

public class MisionTest {

    @Test
    void exploracionNoSumaExtraDeEficiencia() {
        Mision misionExploracion = new MisionExploracion();
        Dron dron = new DronSeguridad(12, 10, misionExploracion);

        assertEquals(0, misionExploracion.extraSegunTipo());
        assertEquals(120, dron.eficienciaOperativa());
    }

    @Test
    void vigilanciaCalculaExtraSegunEficienciaDeCadaSensor() {
        Mision mision = new MisionVigilancia(List.of(
            new Sensor(8, 20, false),
            new Sensor(4, 15, true)
        ));
        Dron dron = new DronSeguridad(1, 1, mision);

        assertEquals(26, dron.eficienciaOperativa());
    }

    @Test
    void transporteEsAvanzadaSiLaAutonomiaSuperaCincuenta() {
        Mision mision = new MisionTransporte();

        Dron dron1 = new DronComercial(51, 10, mision);
        Dron dron2 = new DronComercial(50, 10, mision);

        assertTrue(dron1.esAvanzado());
        assertFalse(dron2.esAvanzado());
    }
}
