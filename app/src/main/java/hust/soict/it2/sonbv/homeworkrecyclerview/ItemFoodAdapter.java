package hust.soict.it2.sonbv.homeworkrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemFoodAdapter extends RecyclerView.Adapter<ItemFoodAdapter.ViewHolder> {
    private ArrayList<ItemFood> listItemFood;
    private Context mContext;

    public ItemFoodAdapter(ArrayList<ItemFood> listItemFood, Context mContext) {
        this.listItemFood = listItemFood;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        if (listItemFood.get(position).getType() == ItemFood.TYPE_HORIZONTAL) {
            return ItemFood.TYPE_HORIZONTAL;
        } else return -1;
    }

    @NonNull
    @Override
    public ItemFoodAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == ItemFood.TYPE_HORIZONTAL) {
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_horizontal, parent, false));
        } else
            return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_food, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemFoodAdapter.ViewHolder holder, int position) {
        if (listItemFood.get(position).getType()==ItemFood.TYPE_HORIZONTAL)
        {
            // no thing
        } else {
            ItemFood curItem = listItemFood.get(position);
            holder.bindView(curItem);
        }
    }

    @Override
    public int getItemCount() {
        return listItemFood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mDescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTitle = itemView.findViewById(R.id.title_food);
            mDescription = itemView.findViewById(R.id.description_food);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getLayoutPosition();
                    ItemFood itemFood = listItemFood.get(index);
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra("ITEM", (Serializable) itemFood);
                    itemView.getContext().startActivity(intent);
                }
            });
        }

        public void bindView(ItemFood curItem) {
            mTitle.setText(curItem.getTitle());
            mDescription.setText(curItem.getDescription());
        }
    }
}
