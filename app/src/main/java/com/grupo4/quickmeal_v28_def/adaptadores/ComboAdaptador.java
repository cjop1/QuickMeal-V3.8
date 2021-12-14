package com.grupo4.quickmeal_v28_def.adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.grupo4.quickmeal_v28_def.R;
import com.grupo4.quickmeal_v28_def.modelo.Combo;
import com.grupo4.quickmeal_v28_def.modelo.Carta;

import java.util.ArrayList;

public class ComboAdaptador extends BaseAdapter {
    Context context;
    ArrayList<Combo> combos;
    LayoutInflater inflater;

    public ComboAdaptador(Context context, ArrayList<Combo> combos) {
        this.context = context;
        this.combos = combos;
    }

    @Override
    public int getCount() {
        return combos.size() ;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null){
            convertView = inflater.inflate(R.layout.grid_general, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imageGrid);
        TextView campoId = convertView.findViewById(R.id.txtId);
        TextView campo1 = convertView.findViewById(R.id.txtcampo1);
        TextView campo2 = convertView.findViewById(R.id.txtcampo2);
        TextView campo3 = convertView.findViewById(R.id.txtcampo3);

        Combo combo = combos.get(position);
        byte[] image = combo.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);

        campoId.setText("ID:"+ combo.getId());
        campo1.setText(combo.getNombre());
        campo2.setText(combo.getDescripcion());
        campo3.setText(combo.getPrecio());
        imageView.setImageBitmap(bitmap);

        return convertView;
    }

}
