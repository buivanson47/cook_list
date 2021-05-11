package hust.soict.it2.sonbv.homeworkrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    public static ArrayList<ItemFood> listItemFood;
    private ItemFoodAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerview_food);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        listItemFood = new ArrayList<>();
        mAdapter = new ItemFoodAdapter(listItemFood, this);
        mRecyclerView.setAdapter(mAdapter);

        // Input Data
        initializeData();
    }

    private void initializeData() {
        String[] listTitle = getResources().getStringArray(R.array.title_list);
        String[] listDescription = getResources().getStringArray(R.array.description_list);
        TypedArray listImage = getResources().obtainTypedArray(R.array.image_list);
        String[] listIngredient = getResources().getStringArray(R.array.ingredient_list);
        String[] listProcess = getResources().getStringArray(R.array.process_list);

        listItemFood.clear();
        for (int i = 0; i < listImage.length(); i++) {
            listItemFood.add(new ItemFood(ItemFood.TYPE_HORIZONTAL));
            listItemFood.add(new ItemFood(listTitle[i],listDescription[i],
                    listImage.getResourceId(i, 0), listIngredient[i], listProcess[i]));
        }

        listImage.recycle();
        mAdapter.notifyDataSetChanged();
    }
}