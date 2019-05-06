package ce.yildiz.sand.myApps;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import ce.yildiz.sand.R;
import ce.yildiz.sand.databaseUtils.ItemContract;
import ce.yildiz.sand.databaseUtils.ItemDBHelper;
import ce.yildiz.sand.recommendations.RecommendationAdapter;

public class MyAppsActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private RecommendationAdapter mAdapter;
    private static final int loaded = 1;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_apps);

        // Open database connection
        ItemDBHelper dbHelper = new ItemDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        // Find recyclerview and set layout and adapter
        RecyclerView recyclerView = findViewById(R.id.myAppsActivityRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecommendationAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
    }

    // TODO: Change this
    private Cursor getAllItems() {
        return mDatabase.query(
                ItemContract.ItemEntry.TABLE_NAME,
                null,
                ItemContract.ItemEntry.COLUMN_LOADED + "=" + loaded,
                null,
                null,
                null,
                null
        );
    }
}
