package com.ieszv.deint.Login;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.snackbar.Snackbar;

import com.ieszv.deint.Login.databinding.FragmentSecondBinding;

import java.util.Objects;

public class SecondFragment extends Fragment {
    private FuncionesValidadoras  funcion;
    private FragmentSecondBinding binding;
    private Database db;
    private final String TAG = SecondFragment.class.getName() + "xyzyx";
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        funcion = new FuncionesValidadoras();
        db = new Database();
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btRegistrarse.setOnClickListener(this::registroSession);
        binding.btCancelar.setOnClickListener(v-> NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_FirstFragment));
}


    public void registroSession(View v){

        String usuarioregistrado = Objects.requireNonNull(binding.textRegisterUsername.getText()).toString();
        String correoRegis = Objects.requireNonNull(binding.tvRegisterEmail.getText()).toString();
        String passwordRegis = Objects.requireNonNull(binding.tvRegisterPassword.getText()).toString();
        String passwordConfirm = Objects.requireNonNull(binding.tvRegisterPasswordConfirm.getText()).toString();

            if(funcion.ValidaEmail(correoRegis) && passwordRegis.equals(passwordConfirm)) {
                if (db.existsUsuarioRegister(usuarioregistrado,correoRegis, passwordRegis)){
                    Snackbar.make(v, "Este Usuario ya existe", Snackbar.LENGTH_SHORT).show();
                } else {
                    Usuario u = new Usuario(usuarioregistrado,correoRegis, passwordRegis);
                    db.insertUsuario(u);
                    Log.v(TAG,u.toString());
                    Log.v(TAG, Database.usuarios.toString());
                    Snackbar.make(v, "Bienvenido: "+ usuarioregistrado, Snackbar.LENGTH_SHORT).show();
                    NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_FirstFragment);
                }
            }else{
               Snackbar.make(v,"ERROR EN EL Formato", Snackbar.LENGTH_SHORT).show();
            }
        }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}