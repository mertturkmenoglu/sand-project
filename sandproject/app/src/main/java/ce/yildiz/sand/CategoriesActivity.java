package ce.yildiz.sand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;

import ce.yildiz.sand.category.CategoryActivity;

public class CategoriesActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        Button musicButton = findViewById(R.id.musicButton);
        Button socialButton = findViewById(R.id.socialButton);
        Button gamingButton = findViewById(R.id.gamingButton);
        Button newsButton = findViewById(R.id.newsButton);
        Button toolsButton = findViewById(R.id.toolsButton);

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", 0);
                startActivity(intent);
            }
        });

        socialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", 1);
                startActivity(intent);
            }
        });

        gamingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", 2);
                startActivity(intent);
            }
        });


        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", 3);
                startActivity(intent);
            }
        });

        toolsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", 4);
                startActivity(intent);
            }
        });
    }
}
