package cl.duoc.productossalmontt.model;

/** Clase que representa los distintos tipo de salmón, su peso disponible,
 *  el centro de producción y lugar de origen
 */
public class Salmones {

    private String tipoSalmon;
    private int kg;
    private String criadero;
    private String provincia;

    //constructor vacío
    public Salmones(){

    }
    /**
     * Constructor de objeto salmones con atributos inicializados
     * @param tipoSalmon nombre del tipo de salmón
     * @param kg cantidad disponible de salmón en Kg
     * @param criadero centro de cultivo del salmón
     * @param provincia lugar de procedencia
     */
    public Salmones(String tipoSalmon, int kg, String criadero, String provincia){
        setTipoSalmon(tipoSalmon);
        setKg(kg);
        setCriadero(criadero);
        setProvincia(provincia);
    }

    //getters
    public String getTipoSalmon(){
        return tipoSalmon;
    }
    public int getKg(){
        return kg;
    }
    public String getCriadero(){
        return criadero;
    }
    public String getProvincia(){
        return provincia;
    }

    //setters con validaciones
    public void setTipoSalmon(String tipoSalmon){
        if(tipoSalmon == null || tipoSalmon.trim().isEmpty()){
            throw new IllegalArgumentException("Tipo de Salmon no puede estar vacío");
        }
        this.tipoSalmon = tipoSalmon;
    }
    public void setKg(int kg){
        if (kg <= 0){
            throw new IllegalArgumentException("Peso debe ser un numero entero positivo");
        }
        this.kg = kg;
    }
    public void setCriadero(String criadero){
        if(criadero == null || criadero.trim().isEmpty()){
            throw new IllegalArgumentException("Debe especificar el centro de cultivo");
        }
        this.criadero = criadero;
    }

    public void setProvincia(String provincia) {
        if(provincia == null || provincia.trim().isEmpty()){
            throw new IllegalArgumentException("Debe indicar lugar de procedencia");
        }
        this.provincia = provincia;
    }

    //método toString para imprimir correctamente datos

    @Override
    public String toString() {
        return "Salmones{" +
                "Tipo de Salmon: '" + tipoSalmon + '\'' +
                ", Peso: " + kg + "Kg" +
                ", Centro de Cultivo: '" + criadero + '\'' +
                ", Provincia: '" + provincia + '\'' +
                '}';
    }
}
