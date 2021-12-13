package com.grupo4.quickmeal_v28_def.adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.grupo4.quickmeal_v28_def.R;
import com.grupo4.quickmeal_v28_def.modelo.Producto;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ProductoAdaptador extends BaseAdapter {
    Context context;
    ArrayList<Producto> productos;
    LayoutInflater inflater;

    public ProductoAdaptador(Context context, ArrayList<Producto> productos) {
        this.context = context;
        this.productos = productos;
    }

    @Override
    public int getCount() {
        return productos.size() ;
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

        ImageView imageView = convertView.findViewById(R.id.elemento);
        TextView campoId = convertView.findViewById(R.id.txtId);
        TextView campo1 = convertView.findViewById(R.id.txtcampo1);
        TextView campo2 = convertView.findViewById(R.id.txtcampo2);
        TextView campo3 = convertView.findViewById(R.id.txtcampo3);

        Producto producto = productos.get(position);
        byte[] image = producto.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0,image.length);

        campoId.setText("ID:"+ producto.getId());
        campo1.setText(producto.getNombre());
        imageView.setImageBitmap(bitmap);
        campo2.setText(producto.getDescripcion());
        campo3.setText(producto.getPrecio());

        return convertView;
    }
}
