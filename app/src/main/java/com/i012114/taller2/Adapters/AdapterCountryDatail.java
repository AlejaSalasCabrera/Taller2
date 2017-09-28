package com.i012114.taller2.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.i012114.taller2.CountriesActivity;
import com.i012114.taller2.MainActivity;
import com.i012114.taller2.Models.CountryDetail;
import com.i012114.taller2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aula7 on 28/09/17.
 */

public class AdapterCountryDatail extends RecyclerView.Adapter<AdapterCountryDatail.ViewHolder>{

    List<CountryDetail> countryDetailList = new ArrayList<>();
    Context context;
    // Constructor de la clase
    public AdapterCountryDatail(List<CountryDetail> countryDetailList, Context context) {
        this.countryDetailList = countryDetailList;
        this.context = context;
    }
    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// Configuracion del ViewAdapter
// Obtener la vista (item.xml)
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail,parent, false);
// Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
// Encargado de trabajar con el item.xml y sus componentes
        holder.textViewSubregion.setText(countryDetailList.get(position).getSubregion());
        holder.textViewLanguages.setText(countryDetailList.get(position).getLanguages());
        holder.textViewArea.setText(Integer.toString(countryDetailList.get(position).getArea()));
    }
    @Override
    public int getItemCount() {
        return countryDetailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewSubregion;
        TextView textViewLanguages;
        TextView textViewArea;
        public ViewHolder(View item) {
            super(item);
            item.setOnClickListener(this);
            textViewSubregion= (TextView) item.findViewById(R.id.id_tv_item_nameregion);
            textViewLanguages = (TextView) item.findViewById(R.id.id_tv_item_namelenguaje);
            textViewArea = (TextView) item.findViewById(R.id.id_tv_item_numarea);
        }

        @Override
        public void onClick(View view) {
            //

            Context contextItem = view.getContext();
            Intent in = new Intent(contextItem, MainActivity.class);
            contextItem.startActivity(in);

                Toast.makeText(context, "Click en el item", Toast.LENGTH_SHORT).show();


        }
    }

}
