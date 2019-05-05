package ce.yildiz.sand;

import android.provider.BaseColumns;

public class ItemContract {
    private ItemContract() {

    }

    public static final class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "groceryList";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_AMOUNT = "amount";
        public static final String COLUMN_TIMESTAMP = "timestamp";
    }
}
