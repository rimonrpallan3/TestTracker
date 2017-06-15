package rimon.com.usertraker.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.rimon.userlivetracking.model.LocationData;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class LocationQuery extends  LocationHandler {
    private static String TAG = LocationQuery.class.getSimpleName();
    private static String TABLE=LocationTable.TABLE_TRACKING;
    public LocationQuery(Context context) {
        super(context);
    }
    /**
     * Convenience method for inserting a food details to the database
     * @param locationData this map contains the initial column values for the row.
     * @return boolean about the insert throws exception if Sql Constrains violated
     */
    public boolean addUserLocation(LocationData locationData) throws SQLIntegrityConstraintViolationException {
        boolean result=false;
        ContentValues values = new ContentValues();
        values.put(LocationTable.COLUMN_LATITUDE, locationData.getLatitude());
        values.put(LocationTable.COLUMN_LONGITUDE,locationData.getLongitude());
        values.put(LocationTable.COLUMN_TIME, locationData.getTime());
        try {
            result = database.insert(TABLE, null, values) > 0;
        }catch (SQLiteException e){
            Log.e(TAG, String.format("%s : %s", new Object(){}.getClass().getEnclosingMethod().getName(), e.getMessage()));
        }
        return result;
    }

    /**
     * Convenience method for getting all user location information from the table
     * @return List<LocationData> List of user location
     */
    public List<LocationData> getUserLocations(){
        List<LocationData> locationDataList = new ArrayList<>();
        String selectQuery = String.format("SELECT * FROM %s",TABLE);
        Cursor cursor = database.rawQuery(selectQuery, null);
        Log.e(TAG,"Count : "+cursor.getCount());
        try{
            if (cursor.moveToFirst()) {
                do {
                    LocationData locationData = new LocationData();
                    locationData.setTime(cursor.getString(1));
                    locationData.setLatitude(cursor.getString(2));
                    locationData.setLongitude(cursor.getString(3));
                    locationDataList.add(locationData);
                    Log.e(TAG, String.format("%s : %s", locationData.getLatitude(), locationData.getLongitude()));

                } while (cursor.moveToNext());
            }
            cursor.close();
        }catch (Exception e){
            Log.e(TAG, String.format("%s : %s", new Object(){}.getClass().getEnclosingMethod().getName(), e.getMessage()));
        }finally {
            if(cursor != null){
                cursor.close();
            }
        }
        return locationDataList;
    }
}
