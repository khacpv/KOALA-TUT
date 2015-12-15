package is.cinnamon.tuya.common.views.viewpager.interpolator;

import is.cinnamon.tuya.common.views.viewpager.SCInterpolator;

/**
 * Created by khacpham on 11/25/15.
 */
public class SCParabolInterpolator implements SCInterpolator {
    @Override
    public float apply(float offset) {
        return (float)Math.sin(offset*Math.PI);
    }
}
