package ce.yildiz.sand;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private GenericRecyclerAdapter mAdapter;

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

        // Find recyclerview and set layout and adapter
        RecyclerView recyclerView = findViewById(R.id.mainActivityRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new GenericRecyclerAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);

        // Add button click listeners

        myAppsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "My Apps Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, MyAppsActivity.class);
                startActivity(intent);
            }
        });

        categoriesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "CategoriesActivity Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(intent);
            }
        });

        recommendationsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Recommendations Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, RecommendationActivity.class);
                startActivity(intent);
            }
        });

        addAppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Add App Button Clicked", Toast.LENGTH_SHORT).show();
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
