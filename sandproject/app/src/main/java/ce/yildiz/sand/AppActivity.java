package ce.yildiz.sand;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ce.yildiz.sand.databaseUtils.Item;
import ce.yildiz.sand.databaseUtils.ItemContract;
import ce.yildiz.sand.databaseUtils.ItemDBHelper;

public class AppActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        TextView categoryName = findViewById(R.id.appActivityCategoryName);
        TextView downloadCount = findViewById(R.id.appActivityDownloadCount);
        TextView version = findViewById(R.id.appActivityVersions);
        Button downloadButton = findViewById(R.id.appActivityDownloadButton);

        Intent intent = getIntent();
        int appID = intent.getIntExtra("appID", 0);

        ItemDBHelper dbHelper = new ItemDBHelper(this);
        final SQLiteDatabase database = dbHelper.getWritableDatabase();

        Item item = dbHelper.getItem(appID);
        Log.d("APPACTIVITY", item.getName());

        Toast.makeText(getApplicationContext(), "Successful", Toast.LENGTH_SHORT).show();
        downloadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "UPDATE THIS METHOD", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
