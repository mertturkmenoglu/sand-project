package ce.yildiz.sand;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ce.yildiz.sand.databaseUtils.ItemContract;
import ce.yildiz.sand.databaseUtils.ItemDBHelper;
import ce.yildiz.sand.mainScreen.MainActivity;

public class AddAppActivity extends AppCompatActivity {
    private EditText mAppName;
    private EditText mCategory;
    private EditText mDownload;
    private EditText mVersion;
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_app);

        ItemDBHelper dbHelper = new ItemDBHelper(this);
        mDatabase = dbHelper.getWritableDatabase();

        mAppName = findViewById(R.id.addAppName);
        mCategory = findViewById(R.id.addAppCategory);
        mDownload = findViewById(R.id.addAppDownload);
        mVersion = findViewById(R.id.addAppVersion);
        Button add = findViewById(R.id.addAppButton);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
                Intent intent = new Intent(AddAppActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addItem() {
        String name = mAppName.getText().toString();
        int category = Integer.parseInt(mCategory.getText().toString());
        int downloadCount = Integer.parseInt(mDownload.getText().toString());
        String version = mVersion.getText().toString();

        ContentValues cv = new ContentValues();
        cv.put(ItemContract.ItemEntry.COLUMN_NAME, name);
        cv.put(ItemContract.ItemEntry.COLUMN_CATEGORY, category);
        cv.put(ItemContract.ItemEntry.COLUMN_DOWNLOAD, downloadCount);
        cv.put(ItemContract.ItemEntry.COLUMN_VERSION, version);
        cv.put(ItemContract.ItemEntry.COLUMN_LOADED, 0);

        mDatabase.insert(ItemContract.ItemEntry.TABLE_NAME, null, cv);
    }
}
