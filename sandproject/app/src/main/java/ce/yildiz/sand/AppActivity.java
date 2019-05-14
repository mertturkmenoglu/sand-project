package ce.yildiz.sand;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ce.yildiz.sand.databaseUtils.ItemContract;
import ce.yildiz.sand.databaseUtils.ItemDBHelper;
import ce.yildiz.sand.mainScreen.MainActivity;

public class AppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        TextView header = findViewById(R.id.appActivityHeader);
        TextView categoryName = findViewById(R.id.appActivityCategoryName);
        TextView downloadCount = findViewById(R.id.appActivityDownloadCount);
        TextView version = findViewById(R.id.appActivityVersions);
        Button downloadButton = findViewById(R.id.appActivityDownloadButton);
        Button removeButton = findViewById(R.id.appActivityRemoveButton);

        Intent intent = getIntent();
        long appID = intent.getLongExtra("appID", 0);
        String text;
        int tmpInt;

        ItemDBHelper dbHelper = new ItemDBHelper(this);
        final SQLiteDatabase database = dbHelper.getWritableDatabase();

        final Cursor cursor = database.query(
                    ItemContract.ItemEntry.TABLE_NAME,
                    null,
                    "_id =" + appID,
                    null,
                    null,
                    null,
                    ItemContract.ItemEntry.COLUMN_DOWNLOAD + " DESC"
        );

        if (cursor != null) {
            cursor.moveToFirst();
        } else {
            Log.d("APP ACTIVITY", "CURSOR IS NULL");
        }

        try {
            assert cursor != null;
            text = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));
            header.setText(text);

            tmpInt = cursor.getInt(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CATEGORY));
            categoryName.setText(String.format("%s %s", getResources().getString(R.string.category), handleCategory(tmpInt)));

            tmpInt = cursor.getInt(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_DOWNLOAD));
            downloadCount.setText(String.format("%s %s", getResources().getString(R.string.download_count), String.valueOf(tmpInt)));

            text = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_VERSION));
            version.setText(String.format("%s %s", getResources().getString(R.string.version), text));
        } catch (Exception e) {
            e.printStackTrace();
        }

        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                downloadApp(cursor, database);
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeApp(cursor, database);
            }
        });
    }

    public String handleCategory(int no) {
        String s;
        switch (no) {
            case 0:
                s = "music";
                break;
            case 1:
                s = "social";
                break;
            case 2:
                s = "gaming";
                break;
            case 3:
                s = "news";
                break;
            case 4:
                s = "tools";
                break;
                default:
                    s = "Category";
                    break;
        }
        return s;
    }

    private void downloadApp(Cursor cursor, SQLiteDatabase database) {
        long id = cursor.getLong(cursor.getColumnIndex(ItemContract.ItemEntry._ID));
        int loaded = cursor.getInt(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_LOADED));

        if (loaded == 1) {
            Toast.makeText(getApplicationContext(), getApplicationContext().getResources().getString(R.string.download_error), Toast.LENGTH_SHORT).show();
            return;
        }

        String name = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));
        int category = cursor.getInt(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CATEGORY));
        int downloadCount = cursor.getInt(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_DOWNLOAD));
        String version = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_VERSION));

        ContentValues cv = new ContentValues();
        cv.put(ItemContract.ItemEntry.COLUMN_NAME, name);
        cv.put(ItemContract.ItemEntry.COLUMN_CATEGORY, category);
        cv.put(ItemContract.ItemEntry.COLUMN_DOWNLOAD, downloadCount + 1);
        cv.put(ItemContract.ItemEntry.COLUMN_VERSION, version);
        cv.put(ItemContract.ItemEntry.COLUMN_LOADED, 1);

        database.delete(ItemContract.ItemEntry.TABLE_NAME, ItemContract.ItemEntry._ID + "=" + id, null);
        database.insert(ItemContract.ItemEntry.TABLE_NAME, null, cv);

        Toast.makeText(getApplicationContext(), getApplicationContext().getResources().getString(R.string.download_success), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AppActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private void removeApp(Cursor cursor, SQLiteDatabase database) {
        long id = cursor.getLong(cursor.getColumnIndex(ItemContract.ItemEntry._ID));
        int loaded = cursor.getInt(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_LOADED));

        if (loaded == 0) {
            Toast.makeText(getApplicationContext(), getApplicationContext().getResources().getString(R.string.remove_error), Toast.LENGTH_SHORT).show();
            return;
        }

        String name = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_NAME));
        int category = cursor.getInt(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_CATEGORY));
        int downloadCount = cursor.getInt(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_DOWNLOAD));
        String version = cursor.getString(cursor.getColumnIndex(ItemContract.ItemEntry.COLUMN_VERSION));

        ContentValues cv = new ContentValues();
        cv.put(ItemContract.ItemEntry.COLUMN_NAME, name);
        cv.put(ItemContract.ItemEntry.COLUMN_CATEGORY, category);
        cv.put(ItemContract.ItemEntry.COLUMN_DOWNLOAD, downloadCount - 1);
        cv.put(ItemContract.ItemEntry.COLUMN_VERSION, version);
        cv.put(ItemContract.ItemEntry.COLUMN_LOADED, 0);

        database.delete(ItemContract.ItemEntry.TABLE_NAME, ItemContract.ItemEntry._ID + "=" + id, null);
        database.insert(ItemContract.ItemEntry.TABLE_NAME, null, cv);

        Toast.makeText(getApplicationContext(), getApplicationContext().getResources().getString(R.string.remove_success), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(AppActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
