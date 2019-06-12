# OTA: Online travel agency

Una agencia de turismo online esta desarrollando su nuevo sistema de reservas y cuanta con 3 proveedores de vuelos de los mas conocidos en el mercado:

* Sabre
* Amadeus
* Worldspan

Se entregan  ya implementadas las clases que se conectan con estos servicios, ustedes pueden modificarlas para agregarles mas disponibilidad de vuelos o corregir cualquier bug que se encuentre.

La clase Ota es la que modela el comportamiento de la agencia que busca o reserva vuelos. Ya se encuentran definidos estos métodos con sus tests correspondientes.

Ota decide utilizar equitativamente los 3 proveedores, para esto se cuenta con la clase DistribuidorDeTrafico, ya implementada, que nos dice el código de proveedor a utilizar.

Se solicita:

* implementar la Clase OTA para q utilice los 3 proveedores (y cualquier otro que pudiese aparecer)
* se puede modificar o cambiar cualquiera de las clases provistas salvo la signatura de los métodos de las clases Amadeus, Sabre y Worldspan.



//crear una nueva interface que implementen las clases para poder interactuar con ota, sin modificar las clases
cliente=ota, adaptado= proveedores, target sera la interfaz para buscar vuelos y en un metodo q ma devuelva la lista de vuelos,
 y otro metodo que me pase una reserva, el adapter seria la implementacion de la interfaz que tendra una referencia de a aquien esta adaptando.
 // cualquier clase que apareciera a partir de ahora debe implementar interfaz proveedors para ser polimorfica con ota.
