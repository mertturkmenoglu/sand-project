package ce.yildiz.sand.databaseUtils;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ce.yildiz.sand.databaseUtils.ItemContract.*;

public class ItemDBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "itemList.db";
    public static final int DATABASE_VERSION = 1;

    public ItemDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_ITEMLIST_TABLE = "CREATE TABLE " +
                ItemEntry.TABLE_NAME + " (" +
                ItemEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ItemEntry.COLUMN_NAME + " TEXT NOT NULL, " +
                ItemEntry.COLUMN_CATEGORY + " INTEGER NOT NULL, " +
                ItemEntry.COLUMN_DOWNLOAD + " INTEGER NOT NULL, " +
                ItemEntry.COLUMN_VERSION + " TEXT NOT NULL, " +
                ItemEntry.COLUMN_LOADED + " INTEGER NOT NULL, " +
                ItemEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                ");";
        db.execSQL(SQL_CREATE_ITEMLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ItemEntry.TABLE_NAME);
        onCreate(db);
    }


    public Item getItem(long id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Item.TABLE_NAME,
                new String[]{Item.COLUMN_ID, Item.COLUMN_NAME, Item.COLUMN_CATEGORY, Item.COLUMN_DOWNLOAD, Item.COLUMN_VERSION,
                        Item.COLUMN_LOADED, Item.COLUMN_TIMESTAMP},
                Item.COLUMN_ID + "=" + id,
                null,
                null,
                null,
                null);

        if (cursor != null)
            cursor.moveToFirst();

        Item item = new Item(
                cursor.getInt(cursor.getColumnIndex(Item.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Item.COLUMN_NAME)),
                cursor.getInt(cursor.getColumnIndex(Item.COLUMN_CATEGORY)),
                cursor.getInt(cursor.getColumnIndex(Item.COLUMN_DOWNLOAD)),
                cursor.getString(cursor.getColumnIndex(Item.COLUMN_VERSION)),
                cursor.getInt(cursor.getColumnIndex(Item.COLUMN_LOADED)),
                cursor.getString(cursor.getColumnIndex(Item.COLUMN_TIMESTAMP))
        );

        return item;
    }
}
