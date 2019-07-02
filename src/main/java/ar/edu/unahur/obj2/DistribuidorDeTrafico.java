package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.proveedores.*;

import java.util.List;
import java.util.Random;

public class DistribuidorDeTrafico {

    private Random random = new Random();
    private List<Proveedors> proveedores;

    public DistribuidorDeTrafico(List<Proveedors> proveedores) {
        this.proveedores = proveedores;
    }


    public void sumarProveedores(Proveedors proveedors){
        proveedores.add(proveedors);
    }

    public Proveedors proveedors(){
        return proveedores.get(random.nextInt(proveedores.size()));
    }


    @Override
    public String toString() {
        return "DistribuidorDeTrafico{" +
                "random=" + random +
                ", proveedores=" + proveedores +
                '}';
    }
}
