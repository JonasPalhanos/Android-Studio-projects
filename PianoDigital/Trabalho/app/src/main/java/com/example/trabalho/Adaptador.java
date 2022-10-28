package com.example.trabalho;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class Adaptador extends BaseAdapter {

    private Context ctx;
    private int[]lista;

    public Adaptador(Context ctx, int[] lista) {
        this.ctx = ctx;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.length;
    }

    @Override
    public Object getItem(int posi) {
        return lista[posi];
    }

    @Override
    public long getItemId(int posi) {
        return posi;
    }

    @Override
    public View getView(int posi, View view, ViewGroup viewGroup) {
        ImageView iv = new ImageView(ctx);
        iv.setImageResource(lista[posi]);
        iv.setLayoutParams(new ViewGroup.LayoutParams(550, 550));
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        iv.setPadding(80,80,80,80);
        return iv;
    }
}
