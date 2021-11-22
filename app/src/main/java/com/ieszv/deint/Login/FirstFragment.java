package com.ieszv.deint.Login;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.google.android.material.snackbar.Snackbar;
import com.ieszv.deint.Login.databinding.FragmentFirstBinding;

import java.util.Objects;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    private Database db;
    private final String TAG = FirstFragment.class.getName() + "xyzyx";
    @Override
    public View onCreateView(

            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState

    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        db = new Database();

        Usuario admin = new Usuario("messi","admin@admin.com", "admin");
        db.insertUsuario(admin);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btSignIG.setOnClickListener(this::iniciarSesion);
        binding.btRegistrarse.setOnClickListener(v -> NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment));
    }
    public void iniciarSesion(View v){
        assert binding.TextInputUsername != null;
        String username = Objects.requireNonNull(binding.TextInputUsername.getText()).toString();
        String correo = Objects.requireNonNull(binding.tvRegisterEmail.getText()).toString();
        String password = Objects.requireNonNull(binding.tvRegisterPassword.getText()).toString();
            if (!Database.existsUsuarioLogin(username, correo, password)){
                Snackbar.make(v, "Error al loguear  :  "  , Snackbar.LENGTH_SHORT).show();
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
                Log.v(TAG,String.valueOf(Database.usuarios));
            }
            else{
                Snackbar.make(v, "Bienvenido de nuevo:  "  , Snackbar.LENGTH_SHORT).show();
            }

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}