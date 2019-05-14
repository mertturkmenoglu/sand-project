package ce.yildiz.sand.mainScreen;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import ce.yildiz.sand.AddAppActivity;
import ce.yildiz.sand.CategoriesActivity;
import ce.yildiz.sand.databaseUtils.ItemContract;
import ce.yildiz.sand.databaseUtils.ItemDBHelper;
import ce.yildiz.sand.myApps.MyAppsActivity;
import ce.yildiz.sand.R;
import ce.yildiz.sand.recommendations.RecommendationActivity;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Open database connection
        ItemDBHelper dbHelper = new ItemDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        // Find views
        Button myAppsButton = findViewById(R.id.myAppsButton);
        Button categoriesButton = findViewById(R.id.categoriesButton);
        Button recommendationsButton = findViewById(R.id.recommendationsButton);
        Button addAppButton = findViewById(R.id.addAppButton);

        // Find recyclerView and set layout and adapter
        RecyclerView recyclerView = findViewById(R.id.mainActivityRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PopularityAdapter adapter = new PopularityAdapter(this, getAllItems());
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

        // Add button click listeners

        myAppsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MyAppsActivity.class);
                startActivity(intent);
            }
        });

        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        recommendationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecommendationActivity.class);
                startActivity(intent);
            }
        });

        addAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddAppActivity.class);
                startActivity(intent);
            }
        });
    }

    private Cursor getAllItems() {
        return mDatabase.query(
                ItemContract.ItemEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                ItemContract.ItemEntry.COLUMN_DOWNLOAD + " DESC"
        );
    }
}
