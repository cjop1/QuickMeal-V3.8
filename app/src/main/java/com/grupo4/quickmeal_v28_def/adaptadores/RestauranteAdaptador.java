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
import com.grupo4.quickmeal_v28_def.modelo.Restaurante;

import java.util.ArrayList;

public class RestauranteAdaptador extends BaseAdapter {
    Context context;
    ArrayList<Restaurante> restaurantes;
    LayoutInflater inflater;

    public RestauranteAdaptador(Context context, ArrayList<Restaurante> restaurantes) {
        this.context = context;
        this.restaurantes = restaurantes;
    }

    @Override
    public int getCount() {
        return restaurantes.size();
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
            convertView = inflater.inflate(R.layout.grid_restaurantes, null);
        }
        ImageView imageView = convertView.findViewById(R.id.imageRest);
        TextView campoId = convertView.findViewById(R.id.txtRestId);
        TextView campoRestaurante = convertView.findViewById(R.id.txtRestRestaurante);
        TextView campoDireccion = convertView.findViewById(R.id.txtRestDireccion);
        TextView campoLocacion = convertView.findViewById(R.id.txtRestLocacion);

        Restaurante restaurante = restaurantes.get(position);
        byte[] image = restaurante.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);

        imageView.setImageBitmap(bitmap);
        campoId.setText(restaurante.getId());
        campoRestaurante.setText(restaurante.getRestaurante());
        campoDireccion.setText(restaurante.getDireccion());
        campoLocacion.setText(restaurante.getLocacion());

        return null;
    }
}
