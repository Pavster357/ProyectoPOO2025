package Model.Secundarios;

public class Orden {
    private String codigo;
    private String tipo;        
    private String nombre;     
    private double precio;

    private String estado;          
    private String resultado;      
    private String fechaResultado;

    public Orden(String codigo, String tipo, String nombre) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = 50.0; 

        this.estado = "Pendiente";
        this.resultado = "";        // mantener cadena vacía para compatibilidad
        this.fechaResultado = "";
    }

    public void registrarTomaMuestra() {
        this.estado = "En Proceso";
    }

    public void cargarResultado(String resultadoTexto, String fecha) {
        if (resultadoTexto == null) resultadoTexto = "";
        this.resultado = resultadoTexto;
        this.fechaResultado = fecha != null ? fecha : "";
        this.estado = "Finalizado";
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public String getResultado() {
        return resultado;
    }

    public String getFechaResultado() {
        return fechaResultado;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nombre + " - " + estado;
    }
    
    public void setResultado(String resultado) {
    this.resultado = resultado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    private String observacionesMuestra;
    private String rutaArchivoResultado;

    public String getObservacionesMuestra() {
        return observacionesMuestra;
    }

    public void setObservacionesMuestra(String observacionesMuestra) {
        this.observacionesMuestra = observacionesMuestra;
    }

    public String getRutaArchivoResultado() {
        return rutaArchivoResultado;
    }

    public void setRutaArchivoResultado(String rutaArchivoResultado) {
        this.rutaArchivoResultado = rutaArchivoResultado;
    }
}