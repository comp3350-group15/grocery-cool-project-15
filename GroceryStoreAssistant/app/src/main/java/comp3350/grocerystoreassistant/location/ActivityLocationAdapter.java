package comp3350.grocerystoreassistant.location;

import android.app.Activity;
import android.content.Context;

public class ActivityLocationAdapter {

    private Activity mActivity;

    public ActivityLocationAdapter() {
        this.mActivity = null;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    protected Activity getAppActivity() {
        return this.mActivity;
    }
}
