package comp3350.grocerystoreassistant.objects.groceryStore;

import android.os.Parcel;
import android.os.Parcelable;


public class Store implements Parcelable {

    // We use the first index with day as placeholder to make it intuitive working with
    // java DAY_OF_THE_WEEK
    public static String[] days = {"Day", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    private int storeID;

    private String name;
    private String phoneNumber;
    private String url;
    private double rating;

    private String storeAddress;
    private OpeningHours openHours;
    private LocationCoordinate coordinate;

    private int imageAddress;

    protected Store(Parcel in) {
        name = in.readString();
        phoneNumber = in.readString();
        url = in.readString();
        rating = in.readDouble();
        storeAddress = in.readString();
        imageAddress = in.readInt();
        openHours = in.readParcelable(OpeningHours.class.getClassLoader());
        coordinate = in.readParcelable(LocationCoordinate.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(phoneNumber);
        dest.writeString(url);
        dest.writeDouble(rating);
        dest.writeString(storeAddress);
        dest.writeInt(imageAddress);
        dest.writeParcelable(openHours, flags);
        dest.writeParcelable(coordinate, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Store> CREATOR = new Creator<Store>() {
        @Override
        public Store createFromParcel(Parcel in) {
            return new Store(in);
        }

        @Override
        public Store[] newArray(int size) {
            return new Store[size];
        }
    };

    public Store() {

    }

    public Store(String name, String phoneNumber, String url, double rating, String storeAddress, OpeningHours openHours, LocationCoordinate coordinate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.url = url;
        this.rating = rating;
        this.storeAddress = storeAddress;
        this.openHours = openHours;
        this.coordinate = coordinate;
    }


    @Override
    public String toString() {
        String s = "";
        s += "Name: " + name + "\n";
        s += "Phone : " + phoneNumber + "\n";
        s += "url : " + url + "\n";
        s += "rating : " + rating + "\n";
        s += "position : " + "(" + getLatidue() + "," + getLongitude() + ")" + "\n";
        s += openHours.getOpeningHours("tuesday") + "\n";

        return s;
    }

    public double getLatidue() {
        return this.coordinate.getLatitude();
    }

    public double getLongitude() {
        return this.coordinate.getLongitude();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUrl() {
        return url;
    }

    public double getRating() {
        return rating;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getHours(String day) {
        return this.openHours.getOpeningHours(day);
    }

    public int getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(int imageAddress) {
        this.imageAddress = imageAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStoreAddress(String addr) {
        this.storeAddress = addr;
    }

    public void setStoreID(int id) {
        this.storeID = id;
    }
}
