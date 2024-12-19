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

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Item> itemList;
    private Context context;
    private RecyclerView recyclerView;

    public ItemAdapter(List<Item> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_item_layout, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.itemName.setText(item.getName());
        holder.itemPrice.setText("Price: $" + item.getPrice());

        // Set up the quantity spinner
        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_item, getQuantities());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.itemQuantity.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private List<Integer> getQuantities() {
        return java.util.Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }



    public Item[] getItemList() {
        return itemList.toArray(new Item[0]);
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView itemName;
        TextView itemPrice;
        ImageView itemImage;
        Spinner itemQuantity;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.item_name);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemImage = itemView.findViewById(R.id.item_image);
            itemQuantity = itemView.findViewById(R.id.item_quantity);
        }
    }


   public double getTotalPrice() {
    int totalPrice = 0;
    for (int i = 0; i < getItemCount(); i++) {
        ItemViewHolder holder = (ItemViewHolder) recyclerView.findViewHolderForAdapterPosition(i);
        if (holder != null) {
            int quantity = (int) holder.itemQuantity.getSelectedItem();
            double price = itemList.get(i).getPrice();
            totalPrice += quantity * price;
        }
    }
    return totalPrice;
}
}
