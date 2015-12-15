package is.cinnamon.tuya.common.views.viewpager.animation;

import android.view.View;
import android.view.ViewGroup;

import is.cinnamon.tuya.common.views.viewpager.SCPageAnimation;

public class SCScaleAnimation extends SCPageAnimation {
    public float dHeigh;
    public float dWidth;
    private int startHeigh;
    private int startWidth;

    private float pivotX;
    private float pivotY;

    /**
     * @param dh additional dimesion for new size. < 0: subtraction
     * @param dw additional dimesion for new size. < 0: subtraction
     * */
    public SCScaleAnimation(int forPage, float dh, float dw) {
        super(forPage);
        this.dHeigh = dh;
        this.dWidth = dw;
    }

    public SCScaleAnimation(int forPage, float dh, float dw,float pivotX,float pivotY) {
        super(forPage);
        this.dHeigh = dh;
        this.dWidth = dw;
        this.pivotX = pivotX;
        this.pivotY = pivotY;
    }

    public void applyTransformation(View onView, float positionOffset) {
        ViewGroup.LayoutParams param = onView.getLayoutParams();
        if(positionOffset <= 0.0F) {
            this.startHeigh = onView.getMeasuredHeight();
            this.startWidth = onView.getMeasuredWidth();
            onView.setPivotX(this.pivotX);
            onView.setPivotY(this.pivotY);
        } else {
            param.height = (int)(this.dHeigh * (float)this.startHeigh * positionOffset) + this.startHeigh;
            param.width = (int)(this.dWidth * (float)this.startWidth * positionOffset) + this.startWidth;
            onView.setLayoutParams(param);
        }
    }
}
