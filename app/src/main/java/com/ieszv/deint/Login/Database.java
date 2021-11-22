package com.ieszv.deint.Login;

import android.nfc.Tag;
import android.util.Log;

import java.util.ArrayList;

public class Database  {
    public static ArrayList<Usuario> usuarios = new ArrayList<>();   private final String TAG = Database.class.getName() + "xyzyx";




    public void insertUsuario(Usuario usu){
    
        usuarios.add(usu);
    }

    public static  boolean existsUsuarioLogin(String usuario,String email, String contraseña){
        boolean ok = false;

        for (Usuario u : usuarios) {
            if (usuario.equals(u.getUsername()) && contraseña.equals(u.getPassword()) && email.equals(u.getEmail())) {
                ok = true;
            }

        }
        return  ok;
    }
    public boolean existsUsuarioRegister(String usuario,String email, String contraseña){
        boolean ok = false;
        for (Usuario u : usuarios) {
            if (email.equals(u.getEmail()) && contraseña.equals(u.getPassword()) && usuario.equals(u.getUsername())) {
                ok = true;
            }
        }
        return  ok;
    }

}
