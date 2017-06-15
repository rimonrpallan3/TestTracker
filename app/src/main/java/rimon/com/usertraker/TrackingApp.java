package rimon.com.usertraker;

import android.app.Application;

/**
 *
 */

public class TrackingApp extends Application {
    private static TrackingApp mTrackingAppInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mTrackingAppInstance=this;
    }
    public static TrackingApp getInstance() {
        return mTrackingAppInstance;
    }

}
