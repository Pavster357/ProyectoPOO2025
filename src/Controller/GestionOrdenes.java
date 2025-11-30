package Controller;

import Model.Secundarios.Orden;

/**
 *
 * @author Alvaro
 */
public class GestionOrdenes {
    
    private Orden[] ordenes;
    private int count;

    public GestionOrdenes() {
        this.ordenes = new Orden[100];
        this.count = 0;
    }

    public boolean agregarOrden(Orden ref) {
        if (count < ordenes.length) {
            ordenes[count] = ref;
            count++;
            return true;
        }
        return false;
    }

    public Orden buscarOrdenPorCodigo(String codigo) {
        for (int i = 0; i < count; i++) {
            if (ordenes[i].getCodigo().equalsIgnoreCase(codigo)) {
                return ordenes[i];
            }
        }
        return null;
    }

    public boolean eliminarOrden(String codigo) {
        for (int i = 0; i < count; i++) {
            if (ordenes[i].getCodigo().equalsIgnoreCase(codigo)) {
                
                // desplazar elementos
                for (int j = i; j < count - 1; j++) {
                    ordenes[j] = ordenes[j + 1];
                }
                
                ordenes[count - 1] = null; // limpiamos el último
                count--;
                return true;
            }
        }
        return false;
    }

    public boolean editarOrden(String codigo, Orden nueva) {
        for (int i = 0; i < count; i++) {
            if (ordenes[i].getCodigo().equalsIgnoreCase(codigo)) {
                ordenes[i] = nueva;
                return true;
            }
        }
        return false;
    }

    public Orden[] getOrdenes() {
        return ordenes;
    }


    public int getCount() {
        return count;
    }

    public boolean existeCodigo(String codigo) {
        return buscarOrdenPorCodigo(codigo) != null;
    }
    
    public boolean cargarResultado(String codigo, String resultado) {
    Orden orden = buscarOrdenPorCodigo(codigo);

    if (orden != null) {
        orden.setResultado(resultado);
        orden.setEstado("FINALIZADA");
        return true;
    }

    return false;
    }
    
    public boolean registrarTomaDeMuestra(String codigo) {
    Orden orden = buscarOrdenPorCodigo(codigo);

    if (orden != null) {
        orden.setEstado("EN PROCESO");
        return true;
    }
    return false;
    }
    
    public boolean registrarTomaDeMuestra(String codigo, String observaciones) {
        Orden orden = buscarOrdenPorCodigo(codigo);
        if (orden != null) {
            orden.setObservacionesMuestra(observaciones); 
            orden.setEstado("En Proceso");
            return true;
        }
        return false;
    }

 
    public boolean cargarResultado(String codigo, String resultadoTexto, String rutaArchivo) {
        Orden orden = buscarOrdenPorCodigo(codigo);
        if (orden != null) {
            orden.setResultado(resultadoTexto);
            orden.setRutaArchivoResultado(rutaArchivo); 
            orden.setEstado("Finalizado");
            return true;
        }
        return false;
    }

}
