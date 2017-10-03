package com.i012114.taller2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.i012114.taller2.Models.Country;
import com.i012114.taller2.Models.Photos;
import com.i012114.taller2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 3/10/17.
 */

public class AdapterPhotos extends RecyclerView.Adapter<AdapterPhotos.ViewHolder> {

    List<Photos> photosList = new ArrayList<>();
    Context context;
    // Constructor de la clase
    public AdapterPhotos(List<Photos> photosList, Context context) {
        this.photosList = photosList;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// Configuracion del ViewAdapter
// Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview,parent, false);
// Pasar la vista (item.xml) al ViewHolder
        AdapterPhotos.ViewHolder viewHolder = new AdapterPhotos.ViewHolder(item);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(AdapterPhotos.ViewHolder holder, int position) {
// Encargado de trabajar con el item.xml y sus componentes
        holder.textViewTitle.setText(photosList.get(position).getTitle());
        holder.textViewthumbnailUrl.setText(photosList.get(position).getUrl());
        Picasso.with(context).load(photosList.get(position).getUrl()).into(holder.imageViewUrl);
    }
    @Override
    public int getItemCount() {
        return photosList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewTitle;
        TextView textViewthumbnailUrl;
        ImageView imageViewUrl;
        public ViewHolder(View item) {
            super(item);
            textViewTitle = (TextView) item.findViewById(R.id.id_tv_item_cv_title);
            textViewthumbnailUrl = (TextView) item.findViewById(R.id.id_tv_item_cv_url);
            imageViewUrl = (ImageView) item.findViewById(R.id.id_img_item_cardvie);
        }
    }

}
