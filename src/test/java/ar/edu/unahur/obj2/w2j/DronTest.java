package ar.edu.unahur.obj2.w2j;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.Drones.Dron;
import ar.edu.unahur.Drones.DronComercial;
import ar.edu.unahur.Drones.DronSeguridad;
import ar.edu.unahur.Misiones.MisionExploracion;
import ar.edu.unahur.Misiones.MisionTransporte;
import ar.edu.unahur.Misiones.MisionVigilancia;
import ar.edu.unahur.Sensores.Sensor;

public class DronTest {
    @Test
    void laEficienciaEnMisionTransporteEsAutonomiaPorDiezMasCien() {
        Dron dron = new DronSeguridad(20, 10, new MisionTransporte());

        assertEquals(300, dron.eficienciaOperativa());
    }
        
    @Test
    void unDronComercialSumaQuinceUnidadesExtra() {
        Dron dron = new DronComercial(20, 10, new MisionExploracion());

        assertEquals(215, dron.eficienciaOperativa());
    }

    @Test
    void laMisionVigilanciaSumaLaEficienciaDeLosSensores() {
        Sensor sensorUno = new Sensor(10, 30, true);
        Sensor sensorDos = new Sensor(5, 15, false);
        Dron dron = new DronSeguridad(10, 10, new MisionVigilancia(List.of(sensorUno, sensorDos)));

        assertEquals(125, dron.eficienciaOperativa());
    }

    @Test
    void unSensorEsDuraderoSiSuDurabilidadSuperaAlDobleDeSuCapacidad() {
        Sensor sensorUno = new Sensor(7, 15, false);
        Sensor sensorDos = new Sensor(7, 14, false);

        assertTrue(sensorUno.esDuradero());
        assertFalse(sensorDos.esDuradero());
    }

    @Test
    void dronSeguridadEsAvanzadoSiNivelProcesamientoSuperaCincuenta() {
        Dron dron = new DronSeguridad(10, 51, new MisionExploracion());

        assertTrue(dron.esAvanzado());
    }

    @Test
    void dronComercialNoEsAvanzadoPorTipoPeroSiPorMisionTransporteConAltaAutonomia() {
        Dron dron = new DronComercial(60, 10, new MisionTransporte());

        assertTrue(dron.esAvanzado());
    }

    @Test
    void enMisionExploracionEsAvanzadoSiLaEficienciaEsPar() {
        Dron dronEfiPar = new DronSeguridad(11, 10, new MisionExploracion());
        Dron dronEfiImpar = new DronComercial(10, 10, new MisionExploracion());

        assertTrue(dronEfiPar.esAvanzado());
        assertFalse(dronEfiImpar.esAvanzado());
    }

    @Test
    void enMisionVigilanciaEsAvanzadoSiTodosLosSensoresSonDuraderos() {
        Dron dronUno = new DronComercial(10, 10, new MisionVigilancia(List.of(new Sensor(5, 11, false), new Sensor(3, 7, true))));
        Dron dronDos = new DronComercial(10, 10, new MisionVigilancia(List.of(new Sensor(5, 11, false), new Sensor(3, 6, true))));

        assertTrue(dronUno.esAvanzado());
        assertFalse(dronDos.esAvanzado());
    }

    @Test
    void unDronPuedeCambiarDeMisionSiSeReprograma() {
        Dron dron = new DronSeguridad(20, 10, new MisionExploracion());

        dron.setMision(new MisionTransporte());

        assertEquals(300, dron.eficienciaOperativa());
    }
}
