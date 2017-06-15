package rimon.com.usertraker.database;

/**
 *
 */

class LocationTable {
    private static String TAG = LocationTable.class.getSimpleName();
    // Database table
    static final String TABLE_TRACKING = "location";
    static final String COLUMN_ID = "_id";
    static final String COLUMN_TIME = "time";
    static final String COLUMN_LONGITUDE = "longitude";
    static final String COLUMN_LATITUDE = "latitude";

    // Database creation SQL statement
    static final String DATABASE_CREATE = "create table "
            + TABLE_TRACKING
            + " ("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_TIME + " text not null, "
            + COLUMN_LONGITUDE + " text not null, "
            + COLUMN_LATITUDE + " text not null"
            + ");";

}

