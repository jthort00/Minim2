package edu.upc.projecte;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;


import java.util.List;

public class BadgeItemAdapter extends RecyclerView.Adapter<BadgeItemAdapter.ItemViewHolder> {

    private List<Badge> badgeList;
    private Context context;
    private RecyclerView recyclerView;

    public BadgeItemAdapter(List<Badge> itemList, Context context) {
        this.badgeList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_badge_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Badge badge = badgeList.get(position);
        holder.itemName.setText(badge.getName());
        Glide.with(context)
                .load(badge.getAvatar()) // URL of the image
                .placeholder(R.drawable.champi) // Placeholder while loading
                .error(R.drawable.ic_launcher_background) // Image if error occurs
                .into(holder.itemImage); // Target ImageView
    }

    @Override
    public int getItemCount() {
        return badgeList.size();
    }

    private List<Integer> getQuantities() {
        return java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }


    public Item[] getItemList() {
        return badgeList.toArray(new Item[0]);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        ImageView itemImage;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemImage = itemView.findViewById(R.id.item_image);
        }
    }

}
