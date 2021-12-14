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
import com.grupo4.quickmeal_v28_def.modelo.Carta;

import java.util.ArrayList;

public class CartaAdaptador extends BaseAdapter {
    Context context;
    ArrayList<Carta> cartas;
    LayoutInflater inflater;

    public CartaAdaptador(Context context, ArrayList<Carta> cartas) {
        this.context = context;
        this.cartas = cartas;
    }

    @Override
    public int getCount() {
        return cartas.size() ;
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
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(convertView == null){
            convertView = inflater.inflate(R.layout.grid_general, null);
        }

        ImageView imageView = convertView.findViewById(R.id.imageGrid);
        TextView campoId = convertView.findViewById(R.id.txtId);
        TextView campo1 = convertView.findViewById(R.id.txtcampo1);
        TextView campo2 = convertView.findViewById(R.id.txtcampo2);
        TextView campo3 = convertView.findViewById(R.id.txtcampo3);


        Carta carta = cartas.get(position);
        byte[] image = carta.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);

        campoId.setText("ID:"+ carta.getId());
        campo1.setText(carta.getNombre());
        campo2.setText(carta.getDescripcion());
        campo3.setText(carta.getPrecio());
        imageView.setImageBitmap(bitmap);

        return convertView;
    }
}
