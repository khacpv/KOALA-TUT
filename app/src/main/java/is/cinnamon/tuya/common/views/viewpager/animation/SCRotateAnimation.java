package is.cinnamon.tuya.common.views.viewpager.animation;

import android.view.View;

import is.cinnamon.tuya.common.views.viewpager.SCPageAnimation;

/**
 * Created by khacpham on 11/24/15.
 */
public class SCRotateAnimation extends SCPageAnimation {
    private float startDegree;
    private float toDegree;

    private float pivotX;
    private float pivotY;

    /**
     * @param toDegree rotate degree. >0: clockwise
     * */
    public SCRotateAnimation(int forPage, float toDegree) {
        super(forPage);
        this.startDegree = 0;
        this.toDegree = toDegree;
    }

    public SCRotateAnimation(int forPage, float toDegree, float pivotX, float pivotY) {
        this(forPage,toDegree);
        this.pivotX = pivotX;
        this.pivotY = pivotY;
    }

    public void applyTransformation(View onView, float positionOffset) {
        if((double)positionOffset <= 1.0E-4D) {
            this.startDegree = onView.getRotation();
            onView.setPivotX(this.pivotX);
            onView.setPivotY(this.pivotY);
        } else {
            onView.setRotation(this.toDegree * positionOffset + this.startDegree);
            onView.setPivotX(0);
            onView.requestLayout();
        }
    }
}
