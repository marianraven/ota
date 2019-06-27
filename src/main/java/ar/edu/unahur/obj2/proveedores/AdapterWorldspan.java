package ar.edu.unahur.obj2.proveedores;

import ar.edu.unahur.obj2.Boleto;
import ar.edu.unahur.obj2.Pasajero;
import ar.edu.unahur.obj2.Vuelo;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class AdapterWorldspan implements Proveedors{

    Worldspan worldspan;


    public AdapterWorldspan(Worldspan worldspan) {
        this.worldspan = worldspan;
    }

    @Override
    public List<Vuelo> buscarVuelo(DateTime fecha, String origen, String destino) {
        return worldspan.searchFlights(fecha.getDayOfMonth(),fecha.getMonthOfYear(),fecha.getYear(),origen,destino);
    }

    @Override
    public Boleto comprar(Vuelo vuelo, Set<Pasajero> pasajeros) {
        return worldspan.bookFlight(vuelo, pasajeros);
    }

    @Override
    public String toString() {
        return "AdapterWorldspan{" +
                "worldspan=" + worldspan +
                '}';
    }
}
