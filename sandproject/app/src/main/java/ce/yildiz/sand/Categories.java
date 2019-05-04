package ce.yildiz.sand;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;

public class Categories extends AppCompatActivity {
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
                // TODO: Add Intent
                Toast.makeText(getApplicationContext(), "Music Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        socialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add Intent
                Toast.makeText(getApplicationContext(), "Social Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        gamingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add Intent
                Toast.makeText(getApplicationContext(), "Gaming Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        newsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add Intent
                Toast.makeText(getApplicationContext(), "News Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        toolsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: Add Intent
                Toast.makeText(getApplicationContext(), "Tools Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
