package com.example.rickmorty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class RickAdapter extends RecyclerView.Adapter<RickAdapter.ViewHolder> {

    private Context context;
    List<results> rickList;

    public RickAdapter(Context context, List<results> rickList) {
        this.context = context;
        this.rickList = rickList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        results rick=rickList.get(position);
        holder.txName.setText(rick.getName());
        holder.tvStatus.setText(rick.getStatus());
        holder.tvSpecies.setText(rick.getSpecies());
        holder.tvGender.setText(rick.getGender());
        Picasso.get()
                .load(rick.getImage())
                .into(holder.ivFilm);

        if (holder.tvStatus.getText() == "Alive"){
            holder.ivStatus.setBackgroundColor(R.drawable.status_on);
        }else {
            holder.ivStatus.setBackgroundColor(R.drawable.status_off);
        }
    }

    @Override
    public int getItemCount() {
        return rickList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivFilm, ivStatus;
        private TextView txName, tvStatus, tvSpecies, tvGender;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFilm = (ImageView) itemView.findViewById(R.id.iv_film);
            ivStatus = (ImageView) itemView.findViewById(R.id.iv_status);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_status);
            tvSpecies = (TextView) itemView.findViewById(R.id.tv_species);
            tvGender = (TextView) itemView.findViewById(R.id.tv_gender);


        }
    }


}