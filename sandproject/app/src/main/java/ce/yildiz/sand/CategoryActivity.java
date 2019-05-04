package ce.yildiz.sand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent intent = getIntent();

        TextView header = findViewById(R.id.categoryActivityHeader);
        int categoryNumber = intent.getIntExtra("category", -1);

        switch (categoryNumber) {
            case 0:
                header.setText(getResources().getString(R.string.music));
                break;
            case 1:
                header.setText(getResources().getString(R.string.social));
                break;
            case 2:
                header.setText(getResources().getString(R.string.gaming));
                break;
            case 3:
                header.setText(getResources().getString(R.string.news));
                break;
            case 4:
                header.setText(getResources().getString(R.string.tools));
                break;
            case -1:
                header.setText(getResources().getString(R.string.app_name));
        }

        // TODO: Implement
    }
}
