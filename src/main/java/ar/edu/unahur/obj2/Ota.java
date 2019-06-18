package ar.edu.unahur.obj2;

import org.joda.time.DateTime;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import ar.edu.unahur.obj2.proveedores.*;
public class Ota {

    private DistribuidorDeTrafico distribuidorDeTrafico;
    private AdapterAmadeus adapterAmadeus;
    private AdapterWorldspan adapterWorldspan;
    private AdapterSabre adapterSabre;

    public Ota(DistribuidorDeTrafico distribuidorDeTrafico) {
        this.distribuidorDeTrafico = distribuidorDeTrafico;
        this.adapterAmadeus = adapterAmadeus;
        this.adapterWorldspan = adapterWorldspan;
        this.adapterSabre = adapterSabre;
    }

    public List<Vuelo> buscarVuelos(DateTime fecha, String origen, String destino) {
        String codigoProveedor = distribuidorDeTrafico.proveedor();

       //adapter de cada una implementara este metodo
        return Collections.emptyList();
    }

    public Boleto reservar(Vuelo vuelo, Set<Pasajero> pasajeros) {
        String codigoProveedor = distribuidorDeTrafico.proveedor();

        ///adapter de cada una implementara este metodo y que devuelva un boleto
        return null;
    }


}
