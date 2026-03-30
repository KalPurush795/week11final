package com.example.wek11final;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

// Explicitly importing the R class to force Android Studio to find your layouts
import com.example.wek11final.R;
import com.example.wek11final.models.SoccerEntity;

import java.util.List;

public class EntityAdapter extends RecyclerView.Adapter<EntityAdapter.ViewHolder> {
    private List<? extends SoccerEntity> items;

    public EntityAdapter(List<? extends SoccerEntity> items) {
        this.items = items;
    }

    // This updates the list when we use our Lambda search filter!
    public void updateData(List<? extends SoccerEntity> newItems) {
        this.items = newItems;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_entity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SoccerEntity item = items.get(position);
        holder.textName.setText(item.getName());
        holder.textDetail.setText("ID: " + item.getId());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName, textDetail;

        public ViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textDetail = itemView.findViewById(R.id.textDetail);
        }
    }
}