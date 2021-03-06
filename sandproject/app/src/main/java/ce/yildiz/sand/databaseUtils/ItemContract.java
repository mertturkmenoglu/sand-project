package ce.yildiz.sand.databaseUtils;

import android.provider.BaseColumns;

@SuppressWarnings("unused")
public class ItemContract {
    private ItemContract() {

    }

    public static final class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "itemList";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CATEGORY = "category";
        public static final String COLUMN_DOWNLOAD = "download";
        public static final String COLUMN_VERSION = "version";
        public static final String COLUMN_LOADED = "loaded";
        public static final String COLUMN_TIMESTAMP = "timestamp";
        public static final String[] COLUMN_NAMES = new String[]{
                ItemEntry._ID, COLUMN_NAME, COLUMN_CATEGORY, COLUMN_DOWNLOAD, COLUMN_VERSION, COLUMN_LOADED, COLUMN_TIMESTAMP};
    }
}
