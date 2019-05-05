package ce.yildiz.sand.category;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import ce.yildiz.sand.R;
import ce.yildiz.sand.databaseUtils.ItemContract;
import ce.yildiz.sand.databaseUtils.ItemDBHelper;
import ce.yildiz.sand.mainScreen.PopularityAdapter;

public class CategoryActivity extends AppCompatActivity {
    private SQLiteDatabase mDatabase;
    private CategoryAdapter mAdapter;
    private int categoryNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        Intent intent = getIntent();

        TextView header = findViewById(R.id.categoryActivityHeader);
        categoryNumber = intent.getIntExtra("category", -1);

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

        // Open database connection
        ItemDBHelper dbHelper = new ItemDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        // Find recyclerview and set layout and adapter
        RecyclerView recyclerView = findViewById(R.id.categoryActivityRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new CategoryAdapter(this, getAllItems());
        recyclerView.setAdapter(mAdapter);
        recyclerView.setHasFixedSize(true);
    }

    private Cursor getAllItems() {
        return mDatabase.query(
                ItemContract.ItemEntry.TABLE_NAME,
                null,
                ItemContract.ItemEntry.COLUMN_CATEGORY + "=" + categoryNumber,
                null,
                null,
                null,
                null
        );
    }
}
