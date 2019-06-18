package ar.edu.unahur.obj2.proveedores;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.Boleto;
import ar.edu.unahur.obj2.Pasajero;
import ar.edu.unahur.obj2.Vuelo;
import org.joda.time.DateTime;


public interface Proveedors {
     List<Vuelo>registrarVuelo(DateTime fecha, final String origen, final String destino);
     Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros);

}
