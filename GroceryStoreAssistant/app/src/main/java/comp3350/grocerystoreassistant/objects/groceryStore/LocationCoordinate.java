package comp3350.grocerystoreassistant.objects.groceryStore;

import android.os.Parcel;
import android.os.Parcelable;

public class LocationCoordinate implements Parcelable {

    private double latitude;
    private double longitude;

    protected LocationCoordinate(Parcel in) {
        latitude = in.readDouble();
        longitude = in.readDouble();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<LocationCoordinate> CREATOR = new Creator<LocationCoordinate>() {
        @Override
        public LocationCoordinate createFromParcel(Parcel in) {
            return new LocationCoordinate(in);
        }

        @Override
        public LocationCoordinate[] newArray(int size) {
            return new LocationCoordinate[size];
        }
    };

    public LocationCoordinate(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
