package com.grupo4.quickmeal_v28_def.ui.combos;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.grupo4.quickmeal_v28_def.FormActivity;
import com.grupo4.quickmeal_v28_def.R;
import com.grupo4.quickmeal_v28_def.adaptadores.CartaAdaptador;
import com.grupo4.quickmeal_v28_def.adaptadores.ComboAdaptador;
import com.grupo4.quickmeal_v28_def.casos_de_uso.CasoUsoProducto;
import com.grupo4.quickmeal_v28_def.databinding.FragmentCombosBinding;
import com.grupo4.quickmeal_v28_def.datos.DBHelper;
import com.grupo4.quickmeal_v28_def.modelo.Combo;

import java.util.ArrayList;

public class CombosFragment extends Fragment {

    private FragmentCombosBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentCombosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent intent = new Intent(getContext(), FormActivity.class);
                intent.putExtra("name","COMBOS");
                getActivity().startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}