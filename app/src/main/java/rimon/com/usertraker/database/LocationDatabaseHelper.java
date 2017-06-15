package rimon.com.usertraker.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 */

class LocationDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "foodies";      // Database Name
    private static final int DATABASE_VERSION = 1;              // Database Version



    private static LocationDatabaseHelper instance;

    static synchronized LocationDatabaseHelper getHelper(Context mContext) {
        if (instance == null) {
            instance = new LocationDatabaseHelper(mContext);
        }
        return instance;
    }

    /*------------------------------------------------------------------*/
    private LocationDatabaseHelper(Context mContext){
        super(mContext, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(LocationTable.DATABASE_CREATE);
    }
    /**
     * Called when the database needs to be downgraded. This is strictly similar to
     * However, this method is not abstract, so it is not mandatory for a customer to
     * implement it. If not overridden, default implementation will reject downgrade and
     * throws SQLiteException
     *
     * <p>
     * This method executes within a transaction.  If an exception is thrown, all changes
     * will automatically be rolled back.
     * </p>
     *
     * @param db The database.
     * @param oldVersion The old database version.
     * @param newVersion The new database version.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String dropQuery = String.format("DROP TABLE IF EXISTS %s",LocationTable.DATABASE_CREATE);
        db.execSQL(dropQuery);
        onCreate(db);
    }
}