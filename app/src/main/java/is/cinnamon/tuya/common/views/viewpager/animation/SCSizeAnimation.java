package is.cinnamon.tuya.common.views.viewpager.animation;

import android.view.View;
import android.view.ViewGroup;

import is.cinnamon.tuya.common.views.viewpager.SCPageAnimation;

public class SCSizeAnimation extends SCPageAnimation {
    public float dHeigh;
    public float dWidth;
    private int startHeigh;
    private int startWidth;

    public SCSizeAnimation(int forPage, float dh, float dw) {
        super(forPage);
        this.dHeigh = dh;
        this.dWidth = dw;
    }

    public void applyTransformation(View onView, float positionOffset) {
        ViewGroup.LayoutParams param = onView.getLayoutParams();
        if(positionOffset <= 0.0F) {
            this.startHeigh = onView.getMeasuredHeight();
            this.startWidth = onView.getMeasuredWidth();
        } else {
            param.height = (int)(this.dHeigh * (float)this.startHeigh * positionOffset) + this.startHeigh;
            param.width = (int)(this.dWidth * (float)this.startHeigh * positionOffset) + this.startWidth;
            onView.setLayoutParams(param);
        }
    }
}
