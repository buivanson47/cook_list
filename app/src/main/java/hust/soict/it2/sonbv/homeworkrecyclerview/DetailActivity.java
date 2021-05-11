package hust.soict.it2.sonbv.homeworkrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    private ImageView mImageView;
    private TextView mTextIngredient;
    private TextView mTextProcess;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mImageView = findViewById(R.id.image_food);
        mTextIngredient = findViewById(R.id.ingredient);
        mTextProcess = findViewById(R.id.process);

        Intent intent = getIntent();
        ItemFood itemFood = (ItemFood) intent.getSerializableExtra("ITEM");
        mImageView.setImageResource(itemFood.getResImage());
        mTextIngredient.setText(itemFood.getIngredient());
        mTextProcess.setText(itemFood.getProcess());
    }
}