package ce.yildiz.sand.recommendations;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import ce.yildiz.sand.R;
import ce.yildiz.sand.databaseUtils.ItemContract;
import ce.yildiz.sand.databaseUtils.ItemDBHelper;

public class RecommendationActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private RecommendationAdapter mAdapter;
    private static final int loaded = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendation);

        // Open database connection
        ItemDBHelper dbHelper = new ItemDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        // Find recyclerview and set layout and adapter
        RecyclerView recyclerView = findViewById(R.id.recommendationActivityRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new RecommendationAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private Cursor getAllItems() {
        Cursor cursor = mDatabase.query(
                ItemContract.ItemEntry.TABLE_NAME,
                null,
                ItemContract.ItemEntry.COLUMN_LOADED + " = " + loaded,
                null,
                null,
                null,
                ItemContract.ItemEntry.COLUMN_TIMESTAMP + " DESC"
        );

        if (cursor != null) {
            cursor.moveToFirst();
        } else {
            Log.d(RecommendationActivity.class.getSimpleName(), "CURSOR IS NULL");
        }
        return cursor;
    }

}
