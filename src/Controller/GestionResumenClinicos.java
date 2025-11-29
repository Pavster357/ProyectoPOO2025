/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Alvaro
 */
public class GestionResumenClinicos {
    private String[][] matrizResumen;
    private int count;

    public GestionResumenClinicos() {
        matrizResumen = new String[200][2]; 
        count = 0;
    }

    public void guardarResumen(String cita, String resumen) {
        if (count < matrizResumen.length) {
            matrizResumen[count][0] = cita;
            matrizResumen[count][1] = resumen;
            count++;
        }
    }

    public String buscarResumen(String cita) {
        for (int i = 0; i < count; i++) {
            if (matrizResumen[i][0].equals(cita)) {
                return matrizResumen[i][1];
            }
        }
        return null;
    }

    public String[][] getMatriz() {
        return matrizResumen;
    }

    public int getCount() {
        return count;
    }
}
