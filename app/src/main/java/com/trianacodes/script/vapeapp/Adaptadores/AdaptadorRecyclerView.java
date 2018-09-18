package com.trianacodes.script.vapeapp.Adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdaptadorRecyclerView extends RecyclerView.Adapter<AdaptadorRecyclerView.ViewHolder>{
    private String[] elDataset;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView texto;
        public ViewHolder(TextView v){

            super(v);
            texto = v;

        }

    }

    public AdaptadorRecyclerView(String[] myDataset){

        elDataset = myDataset;

    }

    @Override
    public AdaptadorRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)

}
