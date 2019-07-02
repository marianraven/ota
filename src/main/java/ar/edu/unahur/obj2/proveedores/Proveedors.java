package ar.edu.unahur.obj2.proveedores;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.Boleto;
import ar.edu.unahur.obj2.Pasajero;
import ar.edu.unahur.obj2.Vuelo;
import org.joda.time.DateTime;


public interface Proveedors {
     List<Vuelo> buscarVuelo(DateTime fecha, String origen,String destino);
     Boleto comprar(Vuelo vuelo, Set<Pasajero> pasajeros);


}
