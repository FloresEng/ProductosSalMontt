package cl.duoc.productossalmontt.ui;

import cl.duoc.productossalmontt.data.GestorDatos;
import cl.duoc.productossalmontt.model.Salmones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**Clase principal que ejecuta la aplicación.
 * carga datos de los productos desde un archivo de texto,
 * los almacena en una lista y luego los imprime por consola.
 */
public class Main {

    public static void main(String[] args){

    //creamos un objeto gestor de datos para que lea la fuente de texto
    GestorDatos gestorDatos = new GestorDatos();

    //llamamos a la fuente de texto
    List<Salmones> stock = gestorDatos.cargarProductos("productos.txt");

    //imprimimos cada linea y elemento con un for each
    System.out.println();
    System.out.println("=============== Stock de Salmones  ===============");

    for (Salmones disponibilidad : stock){
        System.out.println(disponibilidad);
    }
    //filtro según cantidad de salmón disponible
    System.out.println();
    System.out.println("---------- Decisiones de Comercio ----------");
    System.out.println();
    for (Salmones venta : stock){
        if (venta.getKg() >= 1600){
            System.out.println(venta.getTipoSalmon()+": Venta nacional e internacional");

        } else if (venta.getKg() >= 800 && venta.getKg() < 1600) {
            System.out.println(venta.getTipoSalmon()+": Solo venta nacional");

        }else{
            System.out.println(venta.getTipoSalmon()+": En veda. Prohibida su venta");

        }
    }

    }
}