package ar.edu.unahur.obj2.proveedores;

import ar.edu.unahur.obj2.Boleto;
import ar.edu.unahur.obj2.Pasajero;
import ar.edu.unahur.obj2.Vuelo;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Set;

public class AdapterAmadeus implements Proveedors {

    public Amadeus amadeus;

    public AdapterAmadeus(Amadeus amadeus) {
        this.amadeus = amadeus;
    }

    @Override
    public List<Vuelo> registrarVuelo(DateTime fecha, String origen, String destino) {
        return amadeus.executeSearch(fecha,origen,destino);
    }

    @Override
    public Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros) {
        return amadeus.executeBook(vuelo, pasajeros);
    }




}
