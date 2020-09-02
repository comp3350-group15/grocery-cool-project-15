package comp3350.grocerystoreassistant.objects.groceryStore;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

public class OpeningHours implements Parcelable {

    private HashMap<String, String> hours;

    protected OpeningHours(Parcel in) {
        this.hours = (HashMap<String, String>) in.readSerializable();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.hours);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<OpeningHours> CREATOR = new Creator<OpeningHours>() {
        @Override
        public OpeningHours createFromParcel(Parcel in) {
            return new OpeningHours(in);
        }

        @Override
        public OpeningHours[] newArray(int size) {
            return new OpeningHours[size];
        }
    };

    public OpeningHours(ArrayList<String> hours ) {

        this.hours = new HashMap<>();

        for(int i = 0; i < hours.size(); i++) {
            String[] s = hours.get(i).split(": ", 2);
            this.hours.put(s[0].toLowerCase(), s[1]);
        }
    }

    public String getOpeningHours(String day) {
        day = day.toLowerCase();
        if(!hours.containsKey(day)) {
            return day + ": Not Available...";
        }
        return hours.get(day);
    }

    @NonNull
    @Override
    public String toString() {
        return hours.toString();
    }
}
