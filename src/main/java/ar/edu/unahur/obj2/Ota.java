package ar.edu.unahur.obj2;

import org.joda.time.DateTime;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import ar.edu.unahur.obj2.proveedores.*;
public class Ota {

    private DistribuidorDeTrafico distribuidorDeTrafico;

    public Ota(DistribuidorDeTrafico distribuidorDeTrafico) {
        this.distribuidorDeTrafico = distribuidorDeTrafico;

    }

    public List<Vuelo> buscarVuelos(DateTime fecha, String origen, String destino) {
        Proveedors codigoProveedor = distribuidorDeTrafico.proveedors();

        return codigoProveedor.buscarVuelo(fecha,origen,destino);
    }

    public Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros) {
        Proveedors codigoProveedor = distribuidorDeTrafico.proveedors();


        return codigoProveedor.comprar(vuelo,pasajeros);
    }


}
