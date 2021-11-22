package com.ieszv.deint.Login;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FuncionesValidadoras {
    private static final String TAG = FuncionesValidadoras.class.getName() + "xyzyx";
    public  boolean ValidaEmail(String email){
        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
/**
 * Mete el patron a comparar que queremos
 */

        Matcher mather = pattern.matcher(email);


        /**
         * Estructura de control para ver si lo encuentra
         */
        return mather.find();

    }
}