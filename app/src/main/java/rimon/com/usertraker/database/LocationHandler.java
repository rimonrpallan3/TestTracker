package rimon.com.usertraker.database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 *
 */

class LocationHandler {
     SQLiteDatabase database;
    private LocationDatabaseHelper dbHelper;
    private Context mContext;

    LocationHandler(Context context) {
        this.mContext = context;
        dbHelper = LocationDatabaseHelper.getHelper(mContext);
        open();

    }
    /**
     * Convenience method for open layoutdatabase read / writable
     * throws SQLiteException if the database cannot be opened for writing
     */
    private void open() throws SQLException {
        if(dbHelper == null)
            dbHelper = LocationDatabaseHelper.getHelper(mContext);
        database = dbHelper.getWritableDatabase();
    }
    /**
     * Convenience method for close the database
     * throws SQLiteException if the database cannot be opened for writing
     */
    private void close() throws SQLException {
        if(dbHelper == null)
            database.close();
    }

}
