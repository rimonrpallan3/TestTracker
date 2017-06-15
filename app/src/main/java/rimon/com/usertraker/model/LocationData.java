package rimon.com.usertraker.model;

/**
 *
 */

public class LocationData {
    private String Latitude,
     Longitude,
     Time;

    public LocationData(){

    }
    public LocationData(String latitude, String longitude, String date){
        Latitude=latitude;
        Longitude=longitude;
        Time = date;
    }
    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}
