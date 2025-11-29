package Controller;

import Model.Usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


/**
 *
 * @author Alvaro
 */
public class GestionUsuarios {
    private Usuario[] usuarios;
    private int nroUsuarios;

    public GestionUsuarios() {
        this.usuarios = new Usuario[100];
        this.nroUsuarios = 0;
    }
    
    public Usuario ValidarUsuario(String pUsuario, String pContraseña){
        for(int i = 0; i < nroUsuarios; i++){
            Usuario User = usuarios[i];
            if(User != null){
                if(User.getUsuario().equals(pUsuario) 
                        && User.getConstraseña().equals(pContraseña)){
                    return User;
                }
            }
        }
        return null;
    }

    public boolean AgregarUsuario(Usuario ref){
        if(nroUsuarios < usuarios.length){
            usuarios[nroUsuarios] = ref;
            nroUsuarios++;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean EliminarUsuario(Usuario usuario){
        for(int i = 0; i < nroUsuarios; i++){
            if(usuarios[i].getEmpleado() != null && usuarios[i] == usuario){
                for(int j = i; j < nroUsuarios - 1; j++){
                    usuarios[j] = usuarios[j+1];
                }
                usuarios[nroUsuarios - 1] = null;
                nroUsuarios--;
                return true;
            }
        }
        return false;
    }

    
    public boolean EditarUsuario(Usuario original, Usuario nuevo){
        for(int i = 0; i < nroUsuarios; i++){
            if(usuarios[i] == original){
                usuarios[i] = nuevo;
                return true;
            }
        }
        return false;
    }

    public Usuario[] getUsuarios() {
        return usuarios;
    }

    public int getNroUsuarios() {
        return nroUsuarios;
    }
    
    
}
