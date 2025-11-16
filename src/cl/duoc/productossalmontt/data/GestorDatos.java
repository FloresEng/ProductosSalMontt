package cl.duoc.productossalmontt.data;

import cl.duoc.productossalmontt.model.Salmones;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/** Clase que se encarga de leer archivo txt ubicado en el classpath.
 * Convierte cada línea del archivo en objetos
 */
public class GestorDatos {

    //creamos una lista que almacene los datos de los distintos tipos de salmones
    public List<Salmones> cargarProductos(String resourceName){
        //lo almacenamos un arraylist para luego imprimirlos
        List<Salmones> listaSalmones = new ArrayList<>();

        //cargamos el archivo desde el classpath
        ClassLoader classLoader =getClass().getClassLoader();

        try{
            InputStream fuente = classLoader.getResourceAsStream(resourceName);
            if (fuente == null){
                System.err.println("No se encuentra la fuente del texto");
                return  listaSalmones;
            }
            //preparamos el lector del archivo
            try{
                BufferedReader lector = new BufferedReader(new InputStreamReader(fuente));

                String linea;
                int nroLinea = 0;

                //ciclo while para que el lector lea todas las lineas
                while ((linea = lector.readLine()) != null){
                    nroLinea++;
                    if (linea.trim().isEmpty())continue;

                    //arreglo para separar los datos del texto unidos por ;
                    String[] partes = linea.split(";");
                    if (partes.length != 4){
                        System.err.println("Linea "+nroLinea+" es invalida");
                        continue;
                    }
                    //asignamos los datos a cada parte
                    String tipoSalmon = partes[0].trim();
                    String kgTxt = partes[1].trim();
                    String criadero = partes[2].trim();
                    String provincia = partes[3].trim();

                    //convertimos peso de String a int
                    try{
                        int kg = Integer.parseInt(kgTxt);
                        //creamos el producto y lo agregamos al arraylist
                        Salmones salmon = new Salmones(tipoSalmon, kg, criadero, provincia);
                        listaSalmones.add(salmon);

                    } catch (NumberFormatException e) {
                        System.err.println("Peso no numerico en linea: "+nroLinea);
                    }
                }
            } catch (Exception e) {
                System.err.println("Error en el sistema");
            }

        } catch (Exception e) {
            System.err.println("Error en el sistema");

        }
        return listaSalmones;
    }
}
