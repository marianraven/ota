package ar.edu.unahur.obj2;
import org.joda.time.DateTime;
import java.util.List;
import java.util.Set;
import ar.edu.unahur.obj2.proveedores.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.*;


public class OtaTest {

    private Amadeus amadeus;
    private  Sabre sabre;
    private Worldspan worldspan;

    private AdapterAmadeus adapterAmadeus;
    private AdapterSabre adapterSabre;
    private AdapterWorldspan adapterWorldspan;

    private Vuelo vueloSabre;
    private Vuelo vueloAmadeus;
    private Vuelo vueloWorldspan;

    @BeforeTest
    public void beforeTest() {
        amadeus = new Amadeus();
        sabre = new Sabre();
        worldspan = new Worldspan();

        Sabre sabre = new Sabre();
        AdapterSabre adapterSabre = new AdapterSabre(sabre);

        Amadeus amadeus = new Amadeus();
        AdapterAmadeus adapterAmadeus = new AdapterAmadeus(amadeus);

        Worldspan worldspan = new Worldspan();
        AdapterWorldspan adapterWorldspan = new AdapterWorldspan(worldspan);
        DistribuidorDeTrafico distribuidorDeTrafico=new DistribuidorDeTrafico(Stream.of(adapterAmadeus,adapterSabre,adapterWorldspan).collect(Collectors.toList()));
        Ota ota= new Ota(distribuidorDeTrafico);

    }
// test de prueba cargado anteriormente en el codigo original.
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
    //test de prueba con otro pasajero en cualquier vuelo disponible y reserva
    @org.testng.annotations.Test
    public void testReservar2() {

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
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Karl", "Marx", 35)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );

        assertEquals(boleto.getVuelo(), elegido);

    }
    //test amadeus,vuelo y reserva
    @org.testng.annotations.Test
    public void testReservar3() {

        Amadeus amadeus = new Amadeus();
        AdapterAmadeus adapterAmadeus= new AdapterAmadeus(amadeus);

        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(Stream.of(adapterAmadeus).collect(Collectors.toList()));
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");

        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Thomas", "Hobbes", 18)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );
        vueloAmadeus = new Vuelo(fecha,"BUE", "MIA", "AA1000",10,"Amadeus");

        assertEquals( boleto.getVuelo(), new Boleto(vueloAmadeus,pasajeros).getVuelo());
        assertEquals(boleto.getVuelo(), elegido);

    }
    //test sabre vuelo y reserva
    @org.testng.annotations.Test
    public void testReservar4() {

        Sabre sabre = new Sabre();
        AdapterSabre adapterSabre= new AdapterSabre(sabre);

        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(Stream.of(adapterSabre).collect(Collectors.toList()));
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");

        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Arthur Conan", "Doyle", 48)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );
        vueloSabre = new Vuelo(fecha,"BUE", "MIA", "AA1000",10,"Sabre");

        assertEquals( boleto.getVuelo(), new Boleto(vueloSabre,pasajeros).getVuelo());
        assertEquals(boleto.getVuelo(), elegido);

    }

    //test worldspan, vuelo y reserva
    @org.testng.annotations.Test
    public void testReservar5() {

        Worldspan worldspan= new Worldspan();
        AdapterWorldspan adapterWorldspan = new AdapterWorldspan(worldspan);

        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(Stream.of(adapterWorldspan).collect(Collectors.toList()));
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");

        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Agatha", "Christie", 48)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );
        vueloWorldspan = new Vuelo(fecha,"BUE", "MIA", "AA1000",10,"Worldspan");

        assertEquals( boleto.getVuelo(), new Boleto(vueloWorldspan,pasajeros).getVuelo());
        assertEquals(boleto.getVuelo(), elegido);

    }
// busco vuelos en todas las empresas y reservo
    @org.testng.annotations.Test
    public void testBuscarVueloTodasEmpresas() {
        Sabre sabre = new Sabre();
        AdapterSabre adapterSabre= new AdapterSabre(sabre);

        Amadeus amadeus = new Amadeus();
        AdapterAmadeus adapterAmadeus= new AdapterAmadeus(amadeus);

        Worldspan worldspan= new Worldspan();
        AdapterWorldspan adapterWorldspan = new AdapterWorldspan(worldspan);

        DistribuidorDeTrafico distribuidorDeTrafico = new DistribuidorDeTrafico(Stream.of(adapterWorldspan,adapterAmadeus,adapterSabre).collect(Collectors.toList()));
        Ota ota = new Ota(distribuidorDeTrafico);

        DateTime fecha = new DateTime("2019-12-13");

        List<Vuelo> vuelos = ota.buscarVuelos(fecha, "BUE", "MIA");

        Vuelo elegido =  vuelos.get(0);
        Set<Pasajero> pasajeros = Stream.of(new Pasajero("Jean Jacques", "Rousseau", 48)).collect(Collectors.toSet());

        Boleto boleto = ota.reservar(elegido, pasajeros );
        vueloWorldspan = new Vuelo(fecha,"BUE", "MIA", "AA1000",10,"Worldspan");

        assertEquals( boleto.getVuelo(), new Boleto(vueloWorldspan,pasajeros).getVuelo());
        assertEquals(boleto.getVuelo(), elegido);

    }




}

