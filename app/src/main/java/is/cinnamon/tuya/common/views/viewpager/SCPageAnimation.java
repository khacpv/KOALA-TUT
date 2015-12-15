package is.cinnamon.tuya.common.views.viewpager;

import android.view.View;

public abstract class SCPageAnimation {
    public static final float UNDEFINED = Float.MIN_VALUE;

    public int page;

    public SCPageAnimation(int page) {
        this.page = page;
    }

    public abstract void applyTransformation(View var1, float var2);
}
