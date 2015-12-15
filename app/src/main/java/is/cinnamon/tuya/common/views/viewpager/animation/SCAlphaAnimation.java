package is.cinnamon.tuya.common.views.viewpager.animation;

import android.util.Log;
import android.view.View;

import is.cinnamon.tuya.common.views.viewpager.SCPageAnimation;

/**
 * Created by khacpham on 11/24/15.
 */
public class SCAlphaAnimation extends SCPageAnimation {
    private float startAlpha;
    private float toAlpha;

    /**
     * @param toAlpha final alpha value
     * */
    public SCAlphaAnimation(int forPage,float fromAlpha,float toAlpha) {
        super(forPage);
        this.startAlpha = fromAlpha;
        this.toAlpha = toAlpha;
    }

    public void applyTransformation(View onView, float positionOffset) {
        if((double)positionOffset <= 1.0E-4D) {

        } else {
            Log.e("Viewpager", "offset: " + positionOffset + "");
            onView.setAlpha(this.startAlpha + this.toAlpha*positionOffset);
            onView.invalidate();
        }
    }
}