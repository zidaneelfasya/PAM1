package com.example.projekpam;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HiitAdapter extends RecyclerView.Adapter<HiitAdapter.HiitViewHolder>{
    private List<Hiit> HiitList;

    public HiitAdapter(List<Hiit> HiitList) {
        this.HiitList = HiitList;
    }

    @NonNull
    @Override
    public HiitAdapter.HiitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hiit, parent, false);
        return new HiitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HiitAdapter.HiitViewHolder holder, int position) {
        Hiit hiit = HiitList.get(position);
        holder.tvHiitName.setText(hiit.getName());
        holder.tvHiitReps.setText(hiit.getReps());
        holder.imgHiit.setImageResource(hiit.getImageResourceId());
    }

    @Override
    public int getItemCount() {
        return HiitList.size();
    }

    public static class HiitViewHolder extends RecyclerView.ViewHolder {
        ImageView imgHiit;
        TextView tvHiitName;
        TextView tvHiitReps;

        public HiitViewHolder(@NonNull View itemView) {
            super(itemView);
            imgHiit = itemView.findViewById(R.id.img_workout);
            tvHiitName = itemView.findViewById(R.id.editTextTitle);
            tvHiitReps = itemView.findViewById(R.id.editTextDescription);
        }
    }
}
