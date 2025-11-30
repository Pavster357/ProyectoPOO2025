package Controller;

import Model.Secundarios.Orden;

public class GestionOrdenes {

  
    public static final String ESTADO_REGISTRADA = "REGISTRADA";
    public static final String ESTADO_EN_PROCESO = "EN_PROCESO";
    public static final String ESTADO_FINALIZADA = "FINALIZADA";

   
    
    private Orden[] ordenes;
    private int count;

    public GestionOrdenes() {
        this.ordenes = new Orden[100];
        this.count = 0;
    }

  
    public boolean agregarOrden(Orden ref) {
        if (count < ordenes.length) {
            ref.setEstado(ESTADO_REGISTRADA);
            ordenes[count] = ref;
            count++;
            return true;
        }
        return false;
    }

  
    public Orden buscarOrdenPorCodigo(String codigo) {
        for (int i = 0; i < count; i++) {
            if (ordenes[i] != null &&
                ordenes[i].getCodigo().equalsIgnoreCase(codigo)) {
                return ordenes[i];
            }
        }
        return null;
    }


    public boolean eliminarOrden(String codigo) {
        for (int i = 0; i < count; i++) {
            if (ordenes[i].getCodigo().equalsIgnoreCase(codigo)) {

                // desplazamiento
                for (int j = i; j < count - 1; j++) {
                    ordenes[j] = ordenes[j + 1];
                }

                ordenes[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    // ---------------- EDITAR ----------------
    public boolean editarOrden(String codigo, Orden nueva) {
        for (int i = 0; i < count; i++) {
            if (ordenes[i].getCodigo().equalsIgnoreCase(codigo)) {
                nueva.setEstado(ordenes[i].getEstado()); // mantiene estado actual
                ordenes[i] = nueva;
                return true;
            }
        }
        return false;
    }


    public boolean registrarTomaDeMuestra(String codigo) {
        Orden orden = buscarOrdenPorCodigo(codigo);

        if (orden != null) {
            orden.setEstado(ESTADO_EN_PROCESO);
            return true;
        }
        return false;
    }

    public boolean registrarTomaDeMuestra(String codigo, String observaciones) {
        Orden orden = buscarOrdenPorCodigo(codigo);

        if (orden != null) {
            orden.setObservacionesMuestra(observaciones);
            orden.setEstado(ESTADO_EN_PROCESO);
            return true;
        }
        return false;
    }

    
    public boolean cargarResultado(String codigo, String resultado) {
        Orden orden = buscarOrdenPorCodigo(codigo);

        if (orden != null) {
            orden.setResultado(resultado);
            orden.setEstado(ESTADO_FINALIZADA);
            return true;
        }
        return false;
    }

    public boolean cargarResultado(String codigo, String resultadoTexto, String rutaArchivo) {
        Orden orden = buscarOrdenPorCodigo(codigo);

        if (orden != null) {
            orden.setResultado(resultadoTexto);
            orden.setRutaArchivoResultado(rutaArchivo);
            orden.setEstado(ESTADO_FINALIZADA);
            return true;
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
}

