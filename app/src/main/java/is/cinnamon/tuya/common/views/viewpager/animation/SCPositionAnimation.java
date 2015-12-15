package is.cinnamon.tuya.common.views.viewpager.animation;

import android.graphics.PointF;
import android.view.View;

import is.cinnamon.tuya.common.views.viewpager.SCPageAnimation;

public class SCPositionAnimation extends SCPageAnimation {

    public Float fromX,fromY;
    public Float toX,toY;

    public SCPositionAnimation(int forPage, float fromX, float fromY,float toX,float toY) {
        super(forPage);
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }

    public SCPositionAnimation(int forPage, PointF from,PointF to) {
        super(forPage);
        fromX = from.x;
        fromY = from.y;
        toX = to.x;
        toY = to.y;
    }

    public void applyTransformation(View onView, float positionOffset) {
        if(toX != UNDEFINED) {
            onView.setX(positionOffset * (toX - fromX)+fromX);
        }
        if(toY != UNDEFINED) {
            onView.setY(positionOffset * (toY - fromY)+fromY);
        }
        onView.requestLayout();
    }
}
