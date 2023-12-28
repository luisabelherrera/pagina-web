package ModelMaterias;

public class Uea {

    private String id;
    private String clave;
    private String nombre;
    private Integer trimestre;
    private String requisito;
    private String dias;
    private String lugar;
    private String hora;

    public Uea(String id, String clave, String nombre, Integer trimestre, String requisito, String dias, String lugar, String hora) {

        this.id = id;
        this.clave = clave;
        this.nombre = nombre;
        this.trimestre = trimestre;
        this.requisito = requisito;
        this.dias = dias;
        this.lugar = lugar;
        this.hora = hora;

    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(Integer trimestre) {
        this.trimestre = trimestre;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public Uea() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
