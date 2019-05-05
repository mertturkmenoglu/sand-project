package ce.yildiz.sand.databaseUtils;

public class Item {
    public static final String TABLE_NAME = "notes";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_DOWNLOAD = "download";
    public static final String COLUMN_VERSION = "version";
    public static final String COLUMN_LOADED = "loaded";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    private int id;
    private String name;
    private int category;
    private int download;
    private String version;
    private int loaded;
    private String timestamp;

    // Create table SQL query
    public static final String CREATE_TABLE =
            TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_CATEGORY + " INTEGER NOT NULL, " +
                    COLUMN_DOWNLOAD + " INTEGER NOT NULL, " +
                    COLUMN_VERSION + " TEXT NOT NULL, " +
                    COLUMN_LOADED + " INTEGER NOT NULL, " +
                    COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" + ");";

    public Item() {
    }

    public Item(int id, String name, int category, int download, String version, int loaded, String timestamp) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.download = download;
        this.version = version;
        this.loaded = loaded;
        this.timestamp = timestamp;
    }

    public static String getTableName() {
        return TABLE_NAME;
    }

    public static String getColumnId() {
        return COLUMN_ID;
    }

    public static String getColumnName() {
        return COLUMN_NAME;
    }

    public static String getColumnCategory() {
        return COLUMN_CATEGORY;
    }

    public static String getColumnDownload() {
        return COLUMN_DOWNLOAD;
    }

    public static String getColumnVersion() {
        return COLUMN_VERSION;
    }

    public static String getColumnLoaded() {
        return COLUMN_LOADED;
    }

    public static String getColumnTimestamp() {
        return COLUMN_TIMESTAMP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getDownload() {
        return download;
    }

    public void setDownload(int download) {
        this.download = download;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public int getLoaded() {
        return loaded;
    }

    public void setLoaded(int loaded) {
        this.loaded = loaded;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public static String getCreateTable() {
        return CREATE_TABLE;
    }
}
