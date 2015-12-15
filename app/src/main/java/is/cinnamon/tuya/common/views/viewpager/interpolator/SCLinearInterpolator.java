package is.cinnamon.tuya.common.views.viewpager.interpolator;

import is.cinnamon.tuya.common.views.viewpager.SCInterpolator;

/**
 * Created by khacpham on 11/25/15.
 */
public class SCLinearInterpolator implements SCInterpolator {

    private float from;
    private float to;

    private float fromOffset;
    private float toOffset;

    // y = ax+b;
    private float a;
    private float b;

    public SCLinearInterpolator(float from,float to,float fromOffset, float toOffset){
        this.from = from;
        this.to = to;
        this.fromOffset = fromOffset;
        this.toOffset = toOffset;

        // from = a * fromOffset + b
        // to   = a * toOffset + b

        a = (from-to)/(fromOffset-toOffset);
        b = from-a*fromOffset;
    }

    @Override
    public float apply(float offset) {
        float y = a * offset + b;
        return y;
    }
}
