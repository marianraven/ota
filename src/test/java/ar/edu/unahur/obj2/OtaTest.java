package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.testng.Assert.*;

public class OtaTest {

    @org.testng.annotations.Test
    public void testBuscarVuelos() {
        Sabre sabre = new Sabre();
        AdapterSabre adapterSabre= new AdapterSabre(sabre);

        Amadeus amadeus = new Amadeus();
        AdapterAmadeus adapterAmadeus= new AdapterAmadeus(amadeus);

        Worldspan worldspan= new Worldspan();
        AdapterWorldspan adapterWorldspan = new AdapterWorldspan(worldspan);

        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(Stream.of(adapterSabre,adapterAmadeus,adapterWorldspan).collect(Collectors.toList()));
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");


        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");


    }

    @org.testng.annotations.Test
    public void testReservar() {
        Sabre sabre = new Sabre();
        AdapterSabre adapterSabre= new AdapterSabre(sabre);
        Amadeus amadeus = new Amadeus();
        AdapterAmadeus adapterAmadeus= new AdapterAmadeus(amadeus);

        Worldspan worldspan= new Worldspan();
        AdapterWorldspan adapterWorldspan = new AdapterWorldspan(worldspan);


        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(Stream.of(adapterSabre,adapterAmadeus,adapterWorldspan).collect(Collectors.toList()));
        Ota ota = new Ota(distribuidorDeTrafico);
        DateTime fecha = new DateTime("2019-12-13");

        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Juan", "Pérez", 40)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );

        assertEquals(boleto.getVuelo(), elegido);


    }
}