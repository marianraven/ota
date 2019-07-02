package ar.edu.unahur.obj2;

import org.joda.time.DateTime;
import ar.edu.unahur.obj2.Vuelo.*;
import ar.edu.unahur.obj2.Pasajero.*;
import ar.edu.unahur.obj2.Boleto.*;
import ar.edu.unahur.obj2.DistribuidorDeTrafico.*;
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
        Proveedors proveedores = distribuidorDeTrafico.proveedors();

        return proveedores.buscarVuelo(fecha,origen,destino);
    }


    public Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros) {
        Proveedors proveedores = distribuidorDeTrafico.proveedors();

        return proveedores.comprar(vuelo,pasajeros);
    }



}
